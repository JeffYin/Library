package cgc.library.service.impl;

// Start of user code for import
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cgc.library.dao.LoanPeriodDao;
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
}
