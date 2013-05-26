package cgc.library.service.impl;

// Start of user code for import
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.BorrowRecordDao;
import cgc.library.model.BorrowRecord;
import cgc.library.service.BorrowRecordManager;


// End of user code for import

/**
 * This class provides the data access layer to the BorrowRecordManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("borrowRecordManager")
public class BorrowRecordManagerImpl extends GenericManagerImpl<BorrowRecord,Long> implements BorrowRecordManager {
    private transient final Log log = LogFactory.getLog(BorrowRecordManagerImpl.class);
    BorrowRecordDao borrowRecordDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public BorrowRecordManagerImpl(BorrowRecordDao borrowRecordDao ) {
        super(borrowRecordDao);
        this.borrowRecordDao=borrowRecordDao;
    }

	@Override
	public List<BorrowRecord> findOverDueItemByDate(Date date) {
		List<BorrowRecord> itemList = borrowRecordDao.findOverDueItemByDate(date); 
		return itemList;
	}

	@Override
	public List<BorrowRecord> findOverDueItemOfToday() {
		DateTime today = new DateTime().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59); 
		return findOverDueItemByDate(today.toDate());
	}
    

}
