package cgc.library.dao.hibernate;

// Start of user code for import
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.BorrowRecordDao;
import cgc.library.model.BorrowRecord;

// End of user code for import

/**
 * This class provides the data access layer to the BorrowRecordDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class BorrowRecordDaoHibernate extends PaginatedDaoHibernate<BorrowRecord,Long> implements BorrowRecordDao{
     private transient final Log log = LogFactory.getLog(BorrowRecordDaoHibernate.class);
    /**
     * Constructor that sets the entity to BorrowRecord.class.
     */
    public BorrowRecordDaoHibernate() {
    	super(BorrowRecord.class); 
    }
	@Override
	public List<BorrowRecord> findOverDueItemByDate(Date date) {
//		String hql = "select item from BorrowRecord r join r.item item where r.returnedFlag = false and r.dueDate <= :date"; 
//		Date today = new DateTime().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).toDate(); 

		Map<String,Object>paraMap = new HashMap<String, Object>(1); 
		paraMap.put("date", date); 
		List<BorrowRecord> overDueRecords = findByNamedQuery("findUnReturnedRecordsByDate", paraMap); 
		return overDueRecords;
	}
   
}
