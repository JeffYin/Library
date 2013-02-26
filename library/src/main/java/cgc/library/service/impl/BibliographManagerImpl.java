package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.BibliographyDao;
import cgc.library.model.Bibliography;
import cgc.library.service.BibliographyManager;


// End of user code for import

/**
 * This class provides the data access layer to the BookManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("bibliographyManager")
public class BibliographManagerImpl extends GenericManagerImpl<Bibliography,Long> implements BibliographyManager {
    private transient final Log log = LogFactory.getLog(BookManagerImpl.class);
    BibliographyDao bibliographyDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public BibliographManagerImpl(BibliographyDao bibliographyDao ) {
        super(bibliographyDao);
        this.bibliographyDao=bibliographyDao;
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }

	@Override
	public byte[] getCoverImg(Long bibliographyId) {
		return bibliographyDao.getCoverImg(bibliographyId);
	}
    

 
    /* Implementation of interface BookManager: start */

    /* Implementation of interface BookManager: end */

   
   // Start of user code for private methods
   // TODO Remove this line and add your private methods here
   // End of user code for private methods
   
}
