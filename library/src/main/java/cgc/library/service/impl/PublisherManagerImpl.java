package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.PublisherDao;
import cgc.library.model.Publisher;
import cgc.library.service.PublisherManager;


// End of user code for import

/**
 * This class provides the data access layer to the PublisherManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("publisherManager")
public class PublisherManagerImpl extends GenericManagerImpl<Publisher,Long> implements PublisherManager {
    private transient final Log log = LogFactory.getLog(PublisherManagerImpl.class);
    private PublisherDao publisherDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public PublisherManagerImpl(PublisherDao publisherDao ) {
        super(publisherDao);
        this.publisherDao=publisherDao;
    }
   
}
