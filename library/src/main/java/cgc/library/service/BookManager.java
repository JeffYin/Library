package cgc.library.service;

// Start of user code for import
import cgc.library.model.Book;



// End of user code for import

/**
 * This class provides the data access layer to the BookManager entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
public interface BookManager extends GenericManager<Book,Long>{
	 /**
     * Load the lazylized Items.
     * @param bookId
     * @return
     */
	 public Book getBook(Long bookId);
}
