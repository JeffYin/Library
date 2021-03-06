package cgc.library.webapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.Constants;
import cgc.library.model.Book;
import cgc.library.model.BookItem;
import cgc.library.model.Item;
import cgc.library.model.Tag;
import cgc.library.service.BookItemManager;
import cgc.library.service.BookManager;
import cgc.library.service.TagManager;



@Transactional
@Controller
@RequestMapping("/book")
public class BookFormController extends BaseFormController {
  private BookManager bookManager = null;
  private BookItemManager bookItemManager = null; 
  private TagManager tagManager = null; 

  @Autowired
  public void setBookManager(BookManager bookManager) {
		this.bookManager = bookManager;
  }

  @Autowired
  public void setBookItemManager(BookItemManager bookItemManager) {
	  this.bookItemManager = bookItemManager;
  }

  @Autowired
  public void setTagManager(TagManager tagManager) {
	  this.tagManager = tagManager;
  }
  
  public BookFormController() {
	  setCancelView("redirect:books"); 
	  setSuccessView("redirect:books"); 
  }
  
  
  
  @RequestMapping(method=RequestMethod.GET)
  @Transactional
  protected ModelAndView showForm(HttpServletRequest request) throws Exception {
	  String id = request.getParameter("id"); 
	  Model model = new ExtendedModelMap();
	  Book book = null; 
	  if (!StringUtils.isBlank(id)) {
		  Long bookId = Long.parseLong(id); 
		  book = bookManager.getBook(bookId); 
	  } else {
	      book = new Book(); 
	  }
	  
	 
	  if (book!=null) {
		  List<Item> items = book.getItems(); 
			 if (items==null || items.size()==0) {
				 BookItem item = new BookItem(); 
			     book.addBookItem(item); 
			 }
	  }
	  
	  //Load Book Tags
	  List<Tag> tagList = tagManager.getAll(); 
	  model.addAttribute(Constants.TAGS, tagList); 
	  
	  
	  model.addAttribute(Constants.BOOK, book); 
	  return new ModelAndView(Constants.BOOK, model.asMap());
  }
  
  
  @RequestMapping(method = RequestMethod.POST)
  public String onSubmit(Book book, FileUpload fileUpload, BindingResult errors, 
		     HttpServletRequest request, HttpServletResponse response)
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

      boolean isNew = (book.getId() == null);
      String success = getSuccessView();
      Locale locale = request.getLocale();

      if (request.getParameter("delete") != null) {
          bookManager.remove(book.getId());
          saveMessage(request, getText("book.deleted", locale));
      } else {
    	
    	  saveBook(book, fileUpload, request); 
          String key = (isNew) ? "book.added" : "book.updated";
          saveMessage(request, getText(key, locale));

          if (!isNew) {
              success = "redirect:book?id=" + book.getId();
          }
      }

      return success;
  }
  
  /**
   * Save the Book. 
   * @param book
   * @param fileUpload
   * @param request
   * @return
   * @throws SerialException
   * @throws SQLException
   */
  private Book saveBook(Book book, FileUpload fileUpload, HttpServletRequest request) throws SerialException, SQLException {
	  //get Cover Image
      if (fileUpload!=null) {
	      byte[]coverImg =  uploadCoverImage(fileUpload, request); 
	      if (coverImg!=null && coverImg.length>0) {
		      Blob cover = new SerialBlob(coverImg);
		      if (coverImg!=null) {
		    	  book.setCover(cover); 
		      }
	      }
      }
      
    //Get Tags 
      String[] tagArray = request.getParameterValues("bookTags"); 
      if (tagArray!=null) {
    	  for (String tagName:tagArray) {
    		  if (StringUtils.isNotEmpty(tagName)) {
	    		  Map<String,Object> queryParams = new HashMap<String, Object>(1); 
	    		  queryParams.put("name", tagName); 
	    		  List<Tag> tagList = tagManager.findByNamedQuery("findTagByName", queryParams); 
	    		  if (tagList.size()>0) {
	    			  Tag tag = tagList.get(0); 
	    			  book.addTag(tag); 
	    		  } else if (tagList.size()==0) {
	    			  Tag tag = new Tag(tagName); 
	    			  book.addTag(tag); 
	    		  }
    		  }
    	  }
      }
      
      
      //Book already exists
      Long bookId = book.getId(); 
      if (bookId!=null) {
    	  List<BookItem>bookItemList = bookItemManager.getBookItemList(bookId); 
    	  //Remove the blank barcodes. 
          List<BookItem>tempItems = book.getTempItems(); 
          refineItemBarcodes(tempItems); 
          updateBookItems(bookItemList, tempItems, book); 
      }
    
      
      
      return book; 
      
  }
  
  /**
   * Synchronize the targetBookItem with the sourceBookItemList. 
   * @param referennceBookItemList
   * @param targetBookItemList
   */
  private void updateBookItems(List<BookItem> targetBookItemList, List<BookItem>referennceBookItemList, Book book) {
	 Map<Long, BookItem> sourceBookItemMap = convertBookItemListToMap(referennceBookItemList); 
	 
	 Iterator<BookItem> targetIterator = targetBookItemList.iterator(); 
	 
	 while (targetIterator.hasNext()) {
		 BookItem targetBookItem = targetIterator.next(); 
		 Long targetBookId = targetBookItem.getId(); 
		 BookItem relevantSourceBookItem = sourceBookItemMap.get(targetBookId);
		 //If the bookId already removed from the source list, it should be removed from the targetBookItemList.
		 if (relevantSourceBookItem==null) {
			 targetIterator.remove();
			 bookItemManager.remove(targetBookItem); 
		 } else {
			 targetBookItem.setBarcode(relevantSourceBookItem.getBarcode()); 
			 targetBookItem.setBibliography(book); 
			 bookItemManager.save(targetBookItem); 
		 }
	 }
	 
	 for (BookItem sourceBookItem:referennceBookItemList) {
		 if (sourceBookItem.getId()==null) {
			 sourceBookItem.setBibliography(book); 
			 targetBookItemList.add(sourceBookItem); 
			 bookItemManager.save(sourceBookItem); 
		 }
	 }
	 
			
	
	 
  }
  
  /**
   * Convert the BookItemList to BOokItemMap. BookId is the key of the Map. 
   * @param bookItemList
   * @return
   */
  private Map<Long, BookItem> convertBookItemListToMap(List<BookItem>bookItemList) {
	  Map<Long, BookItem> bookItemMap = new HashMap<Long, BookItem>(bookItemList.size()); 
	  for (BookItem item:bookItemList) {
		  bookItemMap.put(item.getId(), item); 
	  }
	  return bookItemMap; 
  }
  
  /**
   * Remove the blank barcodes.
   * @param item
   */
  private void refineItemBarcodes(List<BookItem>bookItemList){
	  if (bookItemList!=null) {
		  Iterator<BookItem> iterator = bookItemList.iterator(); 
		  while(iterator.hasNext()) {
			  String barcode = iterator.next().getBarcode(); 
			  if (StringUtils.isBlank(barcode)) {
				  iterator.remove(); 
			  }
		  }
	  }
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
