package cgc.library.webapp.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.Constants;
import cgc.library.model.Reader;
import cgc.library.service.ReaderManager;



@Transactional
@Controller
@RequestMapping("/reader")
public class ReaderFormController extends BaseFormController {
  private ReaderManager readerManager = null;

  @Autowired
  public void setReaderManager(ReaderManager readerManager) {
		this.readerManager = readerManager;
  }

  public ReaderFormController() {
	  setCancelView("redirect:readers"); 
	  setSuccessView("redirect:readers"); 
  }
  
  
  
  @RequestMapping(method=RequestMethod.GET)
  @Transactional
  protected ModelAndView showForm(HttpServletRequest request) throws Exception {
	  String id = request.getParameter("id"); 
	  Model model = new ExtendedModelMap();
	  Reader reader = null; 
	  if (!StringUtils.isBlank(id)) {
		  Long readerId = Long.parseLong(id); 
		  reader = readerManager.get(readerId); 
	  } else {
	      reader = new Reader(); 
	  }
	  
	  model.addAttribute(Constants.READER, reader); 
	  return new ModelAndView(Constants.READER, model.asMap());
  }
  
  
  @RequestMapping(method = RequestMethod.POST)
  public String onSubmit(Reader reader, BindingResult errors, 
		     HttpServletRequest request, HttpServletResponse response)
  throws Exception {
      if (request.getParameter("cancel") != null) {
          return getCancelView();
      }

      if (validator != null) { // validator is null during testing
          validator.validate(reader, errors);

          if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
              return "reader";
          }
      }

      log.debug("entering 'onSubmit' method...");

      boolean isNew = (reader.getId() == null);
      String success = getSuccessView();
      Locale locale = request.getLocale();

      if (request.getParameter("delete") != null) {
          readerManager.remove(reader.getId());
          saveMessage(request, getText("reader.deleted", locale));
      } else {
    	
    	  saveReader(reader, request); 
          String key = (isNew) ? "reader.added" : "reader.updated";
          saveMessage(request, getText(key, locale));

          if (!isNew) {
              success = "redirect:reader?id=" + reader.getId();
          }
      }

      return success;
  }
  
  /**
   * Save the Reader. 
   * @param reader
   * @param request
   * @return
   * @throws SerialException
   * @throws SQLException
   */
  private Reader saveReader(Reader reader, HttpServletRequest request) throws SerialException, SQLException {
	 //TODO: save the reader info. 
	  readerManager.save(reader); 
      return reader; 
      
  }
  
  
}
