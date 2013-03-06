package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.TagDao;
import cgc.library.model.Tag;
import cgc.library.service.TagManager;


// End of user code for import

/**
 * This class provides the data access layer to the BookManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("tagManager")
public class TagManagerImpl extends GenericManagerImpl<Tag,Long> implements TagManager {
    private transient final Log log = LogFactory.getLog(TagManagerImpl.class);
    TagDao bookDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public TagManagerImpl(TagDao tagDao ) {
        super(tagDao);
        this.bookDao=tagDao;
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
    
}
