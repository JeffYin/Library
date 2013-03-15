package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.ReaderDao;
import cgc.library.model.Reader;

// End of user code for import

/**
 * This class provides the data access layer to the BookDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class ReaderDaoHibernate extends PaginatedDaoHibernate<Reader,Long> implements ReaderDao{
     private transient final Log log = LogFactory.getLog(ReaderDaoHibernate.class);
    /**
     * Constructor that sets the entity to Book.class.
     */
    public ReaderDaoHibernate() {
    	super(Reader.class); 
    }
   
}
