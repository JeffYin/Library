package cgc.library.service;

import cgc.library.model.Item;
import cgc.library.model.LoanPeriod;
// Start of user code for import



// End of user code for import

/**
 * This class provides the data access layer to the LoanPeriodManager entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
public interface LoanPeriodManager extends GenericManager<LoanPeriod,Long>{
	 /**
     * Return the default loan peroid of an item. 
     * @param item
     * @return
     */
	 public Integer getDefaultDueDays(Item item); 
}
