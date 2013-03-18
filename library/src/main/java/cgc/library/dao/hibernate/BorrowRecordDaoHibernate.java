package cgc.library.dao.hibernate;

// Start of user code for import
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
   
}
