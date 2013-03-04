package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.BookDao;
import cgc.library.model.Book;
import cgc.library.service.BookManager;


// End of user code for import

/**
 * This class provides the data access layer to the BookManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("bookManager")
public class BookManagerImpl extends GenericManagerImpl<Book,Long> implements BookManager {
    private transient final Log log = LogFactory.getLog(BookManagerImpl.class);
    BookDao bookDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public BookManagerImpl(BookDao bookDao ) {
        super(bookDao);
        this.bookDao=bookDao;
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
    

    /**
     * Load the lazylized Items.
     * @param bookId
     * @return
     */
    @Override
	public Book getBook(Long bookId) {
       Book book = bookDao.get(bookId);
       if (book!=null) {
    	   Hibernate.initialize(book.getItems()); 
       }
       return book; 
    }
 
    /* Implementation of interface BookManager: start */

    /* Implementation of interface BookManager: end */

   
   // Start of user code for private methods
   // TODO Remove this line and add your private methods here
   // End of user code for private methods
   
}
