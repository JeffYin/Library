package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.BookItemDao;
import cgc.library.model.BookItem;

// End of user code for import

/**
 * This class provides the data access layer to the BookDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class BookItemDaoHibernate extends PaginatedDaoHibernate<BookItem,Long> implements BookItemDao{
     private transient final Log log = LogFactory.getLog(BookItemDaoHibernate.class);
    /**
     * Constructor that sets the entity to Book.class.
     */
    public BookItemDaoHibernate() {
    	super(BookItem.class); 
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
    
}
