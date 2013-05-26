package cgc.library.dao;

import java.util.Date;
import java.util.List;

import cgc.library.model.BorrowRecord;


// End of user code for import

/**
 * This class provides the data access layer to the BookDao entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
public interface BorrowRecordDao extends PaginatedDao<BorrowRecord,Long>{
	/**
	 * Find the overdue book. 
	 * @param date
	 * @return
	 */
	List<BorrowRecord> findOverDueItemByDate(Date date); 
}
