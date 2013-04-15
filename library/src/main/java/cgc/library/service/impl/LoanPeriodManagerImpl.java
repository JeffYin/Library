package cgc.library.service.impl;

// Start of user code for import
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.Globals;
import cgc.library.dao.LoanPeriodDao;
import cgc.library.model.BookItem;
import cgc.library.model.Item;
import cgc.library.model.LoanPeriod;
import cgc.library.service.LoanPeriodManager;


// End of user code for import

/**
 * This class provides the data access layer to the LoanPeriodManagerImpl entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Service("loanPeriodManager")
public class LoanPeriodManagerImpl extends GenericManagerImpl<LoanPeriod,Long> implements LoanPeriodManager {
    private transient final Log log = LogFactory.getLog(LoanPeriodManagerImpl.class);
    LoanPeriodDao loanPeriodDao ;
    
    /**
     * Constructor that sets the dao to .class.
     */
    @Autowired
    public LoanPeriodManagerImpl(LoanPeriodDao loanPeriodDao ) {
        super(loanPeriodDao);
        this.loanPeriodDao=loanPeriodDao;
    }
    
    /**
     * Return the default loan peroid of an item. 
     * @param item
     * @return
     */
    public Integer getDefaultDueDays(Item item) {
    	Integer dueDays = null; 
    	List<LoanPeriod> loanPeriodList = loanPeriodDao.getAll();
    	if (loanPeriodList.size()>0) {
    		LoanPeriod loanPeriod = loanPeriodList.get(0); 			
    		if (item instanceof BookItem) {
    			dueDays = loanPeriod.getBookLoanPeriod(); 
    		} 
    	}
		
		if ((dueDays==null)||(dueDays<=0)) {
			dueDays = Globals.Default_Loan_Period; 
		}
		return dueDays; 
    }
}
