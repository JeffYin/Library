package cgc.library.webapp.controller;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.service.ReaderManager;


// End of user code for import

/**
 * Simple class to deal with collection of data
 */
@Controller
@RequestMapping("/readers")
public class ReaderController {
   private transient final Log log = LogFactory.getLog(ReaderController.class);
   private  ReaderManager readerManager = null;
   
   @Autowired
   public void setBookManager(ReaderManager readerManager) {
     this.readerManager = readerManager;
   }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        return new ModelAndView().addObject(readerManager.getAll());
    }
    


}
