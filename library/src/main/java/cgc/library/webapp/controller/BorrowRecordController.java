package cgc.library.webapp.controller;

// Start of user code for import
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cgc.library.Constants;
import cgc.library.Globals;
import cgc.library.model.BorrowRecord;
import cgc.library.model.CheckinResponseInfo;
import cgc.library.model.Item;
import cgc.library.model.Reader;
import cgc.library.service.BorrowRecordManager;
import cgc.library.service.ItemManager;
import cgc.library.service.LoanPeriodManager;
import cgc.library.service.ReaderManager;
import flexjson.JSONSerializer;


// End of user code for import

/**
 * Simple class to deal with collection of data
 */
@Controller
@RequestMapping("/circulation")
public class BorrowRecordController {
   private transient final Log log = LogFactory.getLog(BorrowRecordController.class);
   private  BorrowRecordManager borrowRecordManager = null;
   private  ItemManager itemManager = null;
   private  ReaderManager readerManager = null;
   private  LoanPeriodManager loanPeriodManager = null; 
   
   @Autowired
   public void setBorrowRecordManager(BorrowRecordManager borrowRecordManager) {
     this.borrowRecordManager = borrowRecordManager;
   }

   @Autowired
   public void setItemManager(ItemManager itemManager) {
	   this.itemManager = itemManager;
   }
   
   @Autowired
   public void setLoanPeriodManager(LoanPeriodManager loanPeriodManager) {
	this.loanPeriodManager = loanPeriodManager;
}

@Autowired
   public void setReaderManager(ReaderManager readerManager) {
	   this.readerManager = readerManager;
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
	

	@RequestMapping(value="/checkin", method = RequestMethod.GET)
	public ModelAndView showCheckInForm() {
		BorrowRecord borrowRecord = new BorrowRecord(); 
		Model model = new ExtendedModelMap();
		model.addAttribute(Constants.BORROW_RECORD, borrowRecord); 
		return new ModelAndView("checkin", model.asMap());
	}
	
	@RequestMapping(value="/bookOverDueQuery", method = RequestMethod.GET)
	public ModelAndView showBookOverDueQueryForm() {
		List<BorrowRecord> overDueBorrowRecords = borrowRecordManager.findOverDueItemOfToday(); 
		Model model = new ExtendedModelMap();
		model.addAttribute("overDueRecordList", overDueBorrowRecords); 
		return new ModelAndView("bookOverDueQuery", model.asMap());
	}
	

	@RequestMapping(value="/scanCheckoutItem", method = RequestMethod.POST)
	public void scanCheckoutItem(String barcode, HttpServletResponse response) throws Exception {
		Map<String, Object> queryParams  = new HashMap<String, Object>(1); 
		queryParams.put("barcode", barcode); 
		List<Item> items = itemManager.findByNamedQuery("findItemsByBarcode", queryParams); 
		int numberFound = items.size();
		if (numberFound==1) { /* found the exact item */
			Item item = items.get(0);
			//Check the Status
			
			Integer itemStatus = item.getItemStatus(); 
			if (itemStatus!=null) {
				if (itemStatus.equals(Globals.ItemStatus_Shelf)) {
				JSONSerializer serializer = new JSONSerializer().include("bibliography.title","id","barcode").exclude("*"); 
				String feedback = serializer.serialize(item);
				response.getWriter().print(feedback);
				} else {
					response.setStatus(itemStatus); 
				}
			} else {
				response.setStatus(Globals.Error_Item_NotOnShelf); /* Item is not on the shelves */
			}

		} else if (numberFound==0) { /* found nothing */
			response.setStatus(Globals.Error_Item_FoundNothing);
		} else { /* more than one items found */
            response.setStatus(Globals.Error_Item_FoundMoreThanOne);			
		}
	}
	
	@RequestMapping(value="/scanCheckinItem", method = RequestMethod.POST)
	public void scanCheckinItem(String barcode, HttpServletResponse response) throws Exception {
		Map<String, Object> queryParams  = new HashMap<String, Object>(1); 
		queryParams.put("barcode", barcode); 
		List<BorrowRecord> borrowRecordList = borrowRecordManager.findByNamedQuery("findRecordsByItemBarcode", queryParams); 
		int numberFound = borrowRecordList.size();
		if (numberFound==1) { /* found the exact item */
			BorrowRecord borrowRecord = borrowRecordList.get(0);
			
			//TODO: get the information from here....
			Item item = borrowRecord.getItem(); 
			Integer itemStatus = item.getItemStatus(); 
			
			if (itemStatus!=null) {
				if (itemStatus.equals(Globals.ItemStatus_Borrowed)) {
					//Change Item status to be on the shelf 
			        item.setItemStatus(Globals.ItemStatus_Shelf); 		
					itemManager.save(item); 
					
					borrowRecord.setReturnedDate(Calendar.getInstance().getTime()); 
					borrowRecord.setReturnedFlag(true); 
					borrowRecordManager.save(borrowRecord); 
					
					//Get reader information
					Reader reader = borrowRecord.getReader();
					CheckinResponseInfo responseInfo = new CheckinResponseInfo(reader, item); 
					
					JSONSerializer serializer = new JSONSerializer(); 
					String feedback = serializer.serialize(responseInfo);
					response.getWriter().print(feedback);
				} else {
					response.setStatus(itemStatus); 
				}
			} else {
				response.setStatus(Globals.Error_Item_NotOnShelf); /* Item is not on the shelves */
			}
			
		} else if (numberFound==0) { /* found nothing */
			response.setStatus(Globals.Error_Item_FoundNothing);
		} else { /* more than one items found */
			response.setStatus(Globals.Error_Item_FoundMoreThanOne);			
		}
	}
	
	/**
	 * Get reader's info according to the library barcode. 
	 */
	@RequestMapping(value="/scanLibraryCard", method = RequestMethod.POST)
	public void scanLibraryCard(String barcode, HttpServletResponse response) throws Exception {
		Map<String, Object> queryParams = new HashMap<String, Object>(1);
		queryParams.put("cardId", "%"+barcode +"%"); 
		List<Reader> readerList = readerManager.findByNamedQuery("findReaderByCardId", queryParams); 
		int numberFound = readerList.size();
		if (numberFound==1) { /* found the exact item */
			Reader reader = readerList.get(0);
			//Check the Status
	
			JSONSerializer serializer = new JSONSerializer().include("cardId","id","name").exclude("*"); 
			String feedback = serializer.serialize(reader);
			response.getWriter().print(feedback);

		} else if (numberFound==0) { /* found nothing */
			response.setStatus(Globals.Error_Item_FoundNothing);
		} else { /* more than one items found */
            response.setStatus(Globals.Error_Item_FoundMoreThanOne);			
		}

	}
	

	
	/**
	 * Complete the checkout action. 
	 * @param libraryCardBarcode
	 * @param itemBarcodeScanned
	 * @throws Exception 
	 */
	//*
	@RequestMapping(value="/checkout", method = RequestMethod.POST)
	public ModelAndView submitCheckout(Long readerId,String[] itemBarcodeScanned) throws Exception {
		
		System.out.println(readerId);

		//Get the userId of the library card. 
		
		Reader reader = readerManager.get(readerId);
		Map<String, Object> queryParams = new HashMap<String, Object>(0); 
		
		for (String itemBarcode: itemBarcodeScanned) {
			queryParams.put("barcode", itemBarcode); 
			List<Item> itemList = itemManager.findByNamedQuery("findItemsByBarcode", queryParams); 
			if (itemList.size()!=1) {
				String message = String.format("Barcode %s does not exist or there are more than one items are using this barcode! ", itemBarcode); 
			   	throw new Exception(message); 
			}
			
			BorrowRecord record = new BorrowRecord(); 
		    Item item = itemList.get(0); 
		    
		   //Change Item status
		    item.setItemStatus(Globals.ItemStatus_Borrowed); 
			
			record.setReader(reader);
			record.setItem(item); 
			record.setBorrowDate(new Date()); 
			Integer dueDays = item.getBibliography().getDueDays(); 
			if ((dueDays==null)||(dueDays<=0)) {
				dueDays = loanPeriodManager.getDefaultDueDays(item); 
			}
			
			Date dueDate = new DateTime().plus(dueDays).toDate(); 
			record.setDueDate(dueDate); 
			
			//save the 
			borrowRecordManager.save(record); 
			itemManager.save(item); 
		}
		// Goto the checkout page again. 
		 return showCheckOutForm(); 
	}
        
	

	
		//*/

}
