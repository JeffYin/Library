package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.ItemDao;
import cgc.library.model.Item;

// End of user code for import

/**
 * This class provides the data access layer to the BookDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class ItemDaoHibernate extends PaginatedDaoHibernate<Item,Long> implements ItemDao{
     private transient final Log log = LogFactory.getLog(ItemDaoHibernate.class);
    /**
     * Constructor that sets the entity to Book.class.
     */
    public ItemDaoHibernate() {
    	super(Item.class); 
    }
   
}
