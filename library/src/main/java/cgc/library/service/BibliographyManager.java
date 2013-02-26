package cgc.library.service;

// Start of user code for import
import cgc.library.model.Bibliography;



// End of user code for import

/**
 * This class provides the data access layer to the BookManager entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
public interface BibliographyManager extends GenericManager<Bibliography,Long>{
	
	 /**
     * Get the cover image. 
     * @param bookId
     * @return
     */
	public byte[] getCoverImg(Long bibliographyId);

}
