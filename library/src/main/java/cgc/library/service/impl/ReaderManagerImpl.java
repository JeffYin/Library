package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.ReaderDao;
import cgc.library.model.Reader;
import cgc.library.service.ReaderManager;


// End of user code for import

/**
 * This class provides the data access layer to the BookManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("readerManager")
public class ReaderManagerImpl extends GenericManagerImpl<Reader,Long> implements ReaderManager {
    private transient final Log log = LogFactory.getLog(ReaderManagerImpl.class);
    ReaderDao readerDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public ReaderManagerImpl(ReaderDao bookDao ) {
        super(bookDao);
        this.readerDao=bookDao;
    }
}
