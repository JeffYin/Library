package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Repository;
 
import cgc.library.dao.BookDao;
import cgc.library.model.Book;

// End of user code for import

/**
 * This class provides the data access layer to the BookDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class BookDaoHibernate extends GenericDaoHibernate<Book,Long> implements BookDao {
     private transient final Log log = LogFactory.getLog(BookDaoHibernate.class);
    /**
     * Constructor that sets the entity to Book.class.
     */
    public BookDaoHibernate() {
        super(Book.class);
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
    

 
    /* Implementation of interface BookDao: start */

    /* Implementation of interface BookDao: end */

   
   // Start of user code for private methods
   // TODO Remove this line and add your private methods here
   // End of user code for private methods
   
}
