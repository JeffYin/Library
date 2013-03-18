package cgc.library.webapp.controller;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.service.BibliographyManager;


// End of user code for import

/**
 * Simple class to deal with collection of data
 */
@Controller
@RequestMapping("/bibliographies")
public class BibliographyController {
   private transient final Log log = LogFactory.getLog(BibliographyController.class);
   private  BibliographyManager bibliographyManager = null;
   
   @Autowired
   public void setBookManager(BibliographyManager bookManager) {
     this.bibliographyManager = bookManager;
   }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        return new ModelAndView().addObject(bibliographyManager.getAll());
    }

}
