package cgc.library.service;

import java.util.List;

import cgc.library.model.BookItem;
// Start of user code for import


public interface BookItemManager extends GenericManager<BookItem,Long>{
	/**
	 * Get all items of a book with the given id. 
	 * @param bookId The book Id of the book.
	 * @return list of the BookItem
	 */
	public List<BookItem> getBookItemList(Long bookId); 
}
