package cgc.library.webapp.controller;

// Start of user code for import
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.service.BookManager;


// End of user code for import

/**
 * Simple class to deal with collection of data
 */
@Controller
@RequestMapping("/books")
public class BookController {
   private transient final Log log = LogFactory.getLog(BookController.class);
   private  BookManager bookManager = null;
   
   @Autowired
   public void setBookManager(BookManager bookManager) {
     this.bookManager = bookManager;
   }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        return new ModelAndView().addObject(bookManager.getAll());
    }
    


}
