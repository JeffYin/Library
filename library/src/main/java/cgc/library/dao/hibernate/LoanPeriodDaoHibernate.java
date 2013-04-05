package cgc.library.dao.hibernate;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import cgc.library.dao.LoanPeriodDao;
import cgc.library.model.LoanPeriod;

// End of user code for import

/**
 * This class provides the data access layer to the LoanPeriodDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class LoanPeriodDaoHibernate extends PaginatedDaoHibernate<LoanPeriod,Long> implements LoanPeriodDao{
     private transient final Log log = LogFactory.getLog(LoanPeriodDaoHibernate.class);
    /**
     * Constructor that sets the entity to LoanPeriod.class.
     */
    public LoanPeriodDaoHibernate() {
    	super(LoanPeriod.class); 
         // Start of user code for customized constructor.

         // End of user code for consutuctor. 
    }
   
}
