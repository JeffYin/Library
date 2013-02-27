package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.PublisherDao;
import cgc.library.model.Publisher;

// End of user code for import

/**
 * This class provides the data access layer to the PublisherDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class PublisherDaoHibernate extends GenericDaoHibernate<Publisher,Long> implements PublisherDao{
     private transient final Log log = LogFactory.getLog(PublisherDaoHibernate.class);
    /**
     * Constructor that sets the entity to Publisher.class.
     */
    public PublisherDaoHibernate() {
    	super(Publisher.class); 
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
   
}
