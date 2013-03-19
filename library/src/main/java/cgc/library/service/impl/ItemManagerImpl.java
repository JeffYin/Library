package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.ItemDao;
import cgc.library.model.Item;
import cgc.library.service.ItemManager;


// End of user code for import

/**
 * This class provides the data access layer to the BookManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("itemManager")
public class ItemManagerImpl extends GenericManagerImpl<Item,Long> implements ItemManager {
    private transient final Log log = LogFactory.getLog(ItemManagerImpl.class);
    ItemDao itemDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public ItemManagerImpl(ItemDao itemDao ) {
        super(itemDao);
        this.itemDao=itemDao;
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
}
