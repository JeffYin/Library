package cgc.library.webapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.model.Book;
import cgc.library.service.BookManager;

@Controller
@RequestMapping("/book")
public class BookFormController extends BaseFormController {
  private BookManager bookManager = null;

  @Autowired
  public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
  }
  
  public BookFormController() {
	  setCancelView("redirect:books"); 
	  setSuccessView("redirect:books"); 
  }
  
  
  
  @ModelAttribute
  @RequestMapping(method=RequestMethod.GET)
  protected Book showForm(HttpServletRequest request) throws Exception {
	  String id = request.getParameter("id"); 
	  
	  if (!StringUtils.isBlank(id)) {
		  return bookManager.get(new Long(id)); 
	  }
	  
	  
	  Book book = new Book(); 
	  return book;
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String onSubmit(Book book, FileUpload fileUpload, BindingResult errors, HttpServletRequest request,
                         HttpServletResponse response)
  throws Exception {
      if (request.getParameter("cancel") != null) {
          return getCancelView();
      }

      if (validator != null) { // validator is null during testing
          validator.validate(book, errors);

          if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
              return "book";
          }
      }

      log.debug("entering 'onSubmit' method...");

      //get Cover Image
      if (fileUpload!=null) {
	      byte[]coverImg =  uploadCoverImage(fileUpload, request); 
	      Blob cover = new SerialBlob(coverImg);
	      if (coverImg!=null) {
	    	  book.setCover(cover); 
	      }
      }
      
      boolean isNew = (book.getId() == null);
      String success = getSuccessView();
      Locale locale = request.getLocale();

      if (request.getParameter("delete") != null) {
          bookManager.remove(book.getId());
          saveMessage(request, getText("book.deleted", locale));
      } else {
          bookManager.save(book);
          String key = (isNew) ? "book.added" : "book.updated";
          saveMessage(request, getText(key, locale));

          if (!isNew) {
              success = "redirect:book?id=" + book.getId();
          }
      }

      return success;
  }
  
  
	/**
	 * Get cover's image
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/cover/{bookId}", method = RequestMethod.GET)
	public ModelAndView getCoverFromDatabase(@PathVariable Long bookId, HttpServletResponse response) throws Exception {
		return null; 
		
	}
  
  private byte[] uploadCoverImage(FileUpload fileUpload, HttpServletRequest request) {
	  // validate a file was entered
	  byte[]imageData = null; 
	  byte[]imageContent = fileUpload.getFile();
      if (imageContent!=null) {
    	  MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
          CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
          InputStream stream;
  		
  		  try {
			stream = file.getInputStream();
  			
  	        imageData = IOUtils.toByteArray(stream); 

  	        //close the stream
  	        stream.close();
  	        
  		  } catch (IOException e) {
			e.printStackTrace();
		}
      }
      return imageData; 
  }
  
  
}
