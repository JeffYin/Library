package cgc.library.service;

// Start of user code for import
import java.util.Date;
import java.util.List;

import cgc.library.model.BorrowRecord;



// End of user code for import

/**
 * This class provides the data access layer to the BorrowRecordManager entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
public interface BorrowRecordManager extends GenericManager<BorrowRecord,Long>{
	/**
	 * Find the overdue book as of today. 
	 * @param date
	 * @return
	 */
	List<BorrowRecord> findOverDueItemOfToday(); 
	/**
	 * Find the overdue book. 
	 * @param date
	 * @return
	 */
	List<BorrowRecord> findOverDueItemByDate(Date date); 
	
	
}
