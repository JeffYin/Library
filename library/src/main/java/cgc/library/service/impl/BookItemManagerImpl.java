package cgc.library.service.impl;

// Start of user code for import
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.BookItemDao;
import cgc.library.model.BookItem;
import cgc.library.service.BookItemManager;


// End of user code for import

/**
 * This class provides the data access layer to the BookManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("bookItemManager")
public class BookItemManagerImpl extends GenericManagerImpl<BookItem,Long> implements BookItemManager {
    private transient final Log log = LogFactory.getLog(BookItemManagerImpl.class);
    BookItemDao bookDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public BookItemManagerImpl(BookItemDao bookItemDao ) {
        super(bookItemDao);
        this.bookDao=bookItemDao;
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }

	@Override
	public List<BookItem> getBookItemList(Long bookId) {
		Map<String, Object> queryParams = new HashMap<String, Object>(1); 
		queryParams.put("bookId", bookId); 
		List<BookItem> bookItemList = bookDao.findByNamedQuery("findItemsOfBook", queryParams);
		return bookItemList;
	}
    
}
