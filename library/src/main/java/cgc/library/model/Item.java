package cgc.library.model;

// Start of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@NamedQueries ({
	   @NamedQuery(
		 name = "findItemsByBarcode",
		 query = "from Item item where item.barcode = :barcode"
	    )	
	})

  @Entity
  @Table(name="item")
@Inheritance(strategy=InheritanceType.JOINED)
public class Item extends BaseObject implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = 89618392816164768L;


    /**
     * Automatic primary key.
     */
    private Long id;
      

    /**
     * Field barcode.
     */
    private String barcode;

    /**
     * Field library.
     */
    private Library library;

    private List<BorrowRecord> borrowRecords; 
    
    
    private Integer itemStatus; 

	/* To support bidirectional databinding */
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
}
	
    /**
     * Default constructor.
     */
    public Item() {
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
     * @param someBarcode
     *           
     * @param someLibrary
     *           
     */
    public Item(String someBarcode, Library someLibrary) {
        barcode = someBarcode;
        library = someLibrary;
    }

    /**
     * Returns String barcode.
     */
     
     
    
     
	 @Column (name="barcode")
    public String getBarcode() {
        return barcode;
    }

    /**
     * Sets a value to parameter barcode.
     * @param someBarcode
     *            
     */
    public void setBarcode(final String someBarcode) {
       propertyChangeSupport.firePropertyChange("barcode", this.barcode, this.barcode=someBarcode);
    }
    
 
 
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "LIBRARY_ID", nullable = false)
      public Library getLibrary() {
	        return library;
    }
    			
             
             
    /**
     * Sets a value to parameter library.
     * @param someLibrary
     *            
     */
    public void setLibrary(final Library someLibrary) {
        library = someLibrary;
    }
 

	 @OneToMany(mappedBy="item")          
	public List<BorrowRecord> getBorrowRecords() {
	        return borrowRecords;
     }
  			
	 
	public Integer getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Integer itemStatus) {
		this.itemStatus = itemStatus;
	}

	/**
   * Sets a value to parameter Items.
   * @param someBorrowRecords
   *            
   */
  public void setBorrowRecords(final List<BorrowRecord> someBorrowRecords) {
      borrowRecords = someBorrowRecords;
  }

    
    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * Item and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof Item)) {
            return false;
        }
        final Item castedOther = (Item) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
        if ((barcode == null && castedOther.getBarcode() != null) 
             || (barcode != null && !barcode.equals(
                castedOther.getBarcode()))){
           return false;
        }
        if ((library == null && castedOther.getLibrary() != null) 
             || (library != null && !library.equals(
                castedOther.getLibrary()))){
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
            if (barcode != null) {
                result = 29 * result + barcode.hashCode();
            }
         }
       
        return result;
        // End of user code for hashCode
    }
/**
     * Output the information of Item
     * @return Returns the information
     */
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                   .append("barcode", this.barcode)    

             ;
        return sb.toString();         
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

