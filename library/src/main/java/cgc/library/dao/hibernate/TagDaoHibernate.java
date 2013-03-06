package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.TagDao;
import cgc.library.model.Tag;

// End of user code for import

/**
 * This class provides the data access layer to the TagDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class TagDaoHibernate extends GenericDaoHibernate<Tag,Long> implements TagDao{
     private transient final Log log = LogFactory.getLog(TagDaoHibernate.class);
    /**
     * Constructor that sets the entity to Tag.class.
     */
    public TagDaoHibernate() {
    	super(Tag.class); 
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
   
}
