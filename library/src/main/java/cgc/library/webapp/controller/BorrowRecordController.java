package cgc.library.webapp.controller;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.Constants;
import cgc.library.model.BorrowRecord;
import cgc.library.service.BorrowRecordManager;


// End of user code for import

/**
 * Simple class to deal with collection of data
 */
@Controller
@RequestMapping("/circulation")
public class BorrowRecordController {
   private transient final Log log = LogFactory.getLog(BorrowRecordController.class);
   private  BorrowRecordManager borrowRecordManager = null;
   
   @Autowired
   public void setBorrowRecordManager(BorrowRecordManager borrowRecordManager) {
     this.borrowRecordManager = borrowRecordManager;
   }
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest() throws Exception {
        return new ModelAndView().addObject(borrowRecordManager.getAll());
    }
    
	
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public ModelAndView showCheckOutForm() {
		BorrowRecord borrowRecord = new BorrowRecord(); 
		Model model = new ExtendedModelMap();
		model.addAttribute(Constants.BORROW_RECORD, borrowRecord); 
	     return new ModelAndView("checkout", model.asMap());
	}
	
	

}
