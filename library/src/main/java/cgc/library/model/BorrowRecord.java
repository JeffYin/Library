package cgc.library.model;

// Start of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
// End of user code for imports
/**
 */

  @Entity
  @Table(name="borrow_record")
public class BorrowRecord extends BaseObject implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = -30240657181388984L;


    /**
     * Automatic primary key.
     */
    private Long id;
      
    private Reader reader;

    /**
     * Field borrowDate.
     */
    private Date borrowDate;

    /**
     * Field dueDate.
     */
    private Date dueDate;

    /**
     * Field returnedDate.
     */
    private Date returnedDate;

    
    private Item item; 


	/* To support bidirectional databinding */
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
}
	
    /**
     * Default constructor.
     */
    public BorrowRecord() {
        super();
    }

    /**
     * Returns the identifier.
     * @return Returns id.
     */
      @Id @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Sets a value to parameter Id.
     * @param someId Value of the identifier.
     */
    public void setId(final Long someId) {
        id = someId;
    }

    
    /**
     * Constructor with all parameters initialized.
     * @param someBorrowDate
     *           
     * @param someDueDate
     *           
     * @param someReturnedDate
     *           
     */
    public BorrowRecord(Date someBorrowDate, Date someDueDate, Date someReturnedDate) {
        borrowDate = someBorrowDate;
        dueDate = someDueDate;
        returnedDate = someReturnedDate;
    }
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "READER_ID", nullable = false)
     public Reader getReader() {
	        return reader;
    }
    			
    /**
     * Sets a value to parameter book.
     * @param someReader
     *            
     */
    public void setReader(final Reader someReader) {
        reader = someReader;
    }
    
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ITEM_ID", nullable = false)
    public Item getItem() {
    	return item;
    }
    
    /**
     * Sets a value to parameter book.
     * @param someItem
     *            
     */
    public void setItem(final Item someItem) {
    	item = someItem;
    }
 

    /**
     * Returns EDate borrowDate.
     */
	 @Column (name="borrow_date")
    public Date getBorrowDate() {
        return borrowDate;
    }

    /**
     * Sets a value to parameter borrowDate.
     * @param someBorrowDate
     *            
     */
    public void setBorrowDate(final Date someBorrowDate) {
       propertyChangeSupport.firePropertyChange("borrowDate", this.borrowDate, this.borrowDate=someBorrowDate);
    }
    /**
     * Returns EDate dueDate.
     */
	 @Column (name="due_date")
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets a value to parameter dueDate.
     * @param someDueDate
     *            
     */
    public void setDueDate(final Date someDueDate) {
       propertyChangeSupport.firePropertyChange("dueDate", this.dueDate, this.dueDate=someDueDate);
    }
    /**
     * Returns EDate returnedDate.
     */
     
     
    
     
	 @Column (name="returned_date")
    public Date getReturnedDate() {
        return returnedDate;
    }

    /**
     * Sets a value to parameter returnedDate.
     * @param someReturnedDate
     *            
     */
    public void setReturnedDate(final Date someReturnedDate) {
       propertyChangeSupport.firePropertyChange("returnedDate", this.returnedDate, this.returnedDate=someReturnedDate);
    }
    





   
    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * BorrowRecord and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorrowRecord)) {
            return false;
        }
        final BorrowRecord castedOther = (BorrowRecord) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
        if ((borrowDate == null && castedOther.getBorrowDate() != null) 
             || (borrowDate != null && !borrowDate.equals(
                castedOther.getBorrowDate()))){
           return false;
        }
        if ((dueDate == null && castedOther.getDueDate() != null) 
             || (dueDate != null && !dueDate.equals(
                castedOther.getDueDate()))){
           return false;
        }
        if ((returnedDate == null && castedOther.getReturnedDate() != null) 
             || (returnedDate != null && !returnedDate.equals(
                castedOther.getReturnedDate()))){
           return false;
        }
        return true;
        // End of user code for equals
    }

    /**
     * HashTable code based on attributes hashcodes.
     * @return Returns hash value
     */
    @Override
    public int hashCode() {
        // Start of user code for hashCode
        int result = 0;
        Long id=getId();
        if (id != null) {
            result = id.hashCode();
        } else {
            if (borrowDate != null) {
                result = 29 * result + borrowDate.hashCode();
            }
            if (dueDate != null) {
                result = 29 * result + dueDate.hashCode();
            }
            if (returnedDate != null) {
                result = 29 * result + returnedDate.hashCode();
            }
         }
       
        return result;
        // End of user code for hashCode
    }
/**
     * Output the information of BorrowRecord
     * @return Returns the information
     */
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                   .append("borrowDate", this.borrowDate)    
             .append("dueDate", this.dueDate)    
             .append("returnedDate", this.returnedDate)    

             ;
        return sb.toString();         
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

