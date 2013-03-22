package cgc.library.model;

// Start of user code for imports
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
// End of user code for imports
/**
 */

  @Entity
  @Table(name="book")
public class Book extends Bibliography implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = 50884446015440912L;

    /**
     * Field Items.
     */
    private List<BookItem> items;

    private LinkedList<BookItem> tempItems;


     
	
    /**
     * Default constructor.
     */
    public Book() {
        super();
        items = new ArrayList<BookItem>();
        tempItems = new LinkedList<BookItem>();
    }


   
	 @OneToMany(mappedBy="book")          
	public List<BookItem> getItems() {
	        return items;
    }
    			
	 
	public void setTempItems(LinkedList<BookItem> tempItems) {
		this.tempItems = tempItems;
	}



	/**
     * Sets a value to parameter Items.
     * @param someItems
     *            
     */
    public void setItems(final List<BookItem> someItems) {
        items = someItems;
    }
 
    
    
    @Transient
    public LinkedList<BookItem> getTempItems() {
		return tempItems;
	}

   

	/**
     * Adds a BookItem to the Items Collection.
     * Birectionnal association : add the current  instance to
     * the given Items parameter.
     * @param ItemsElt Element to add
     */
    public void addBookItem(final BookItem ItemsElt) {
        items.add(ItemsElt);
        ItemsElt.setBook(this);
    }
    
    /**
     * Removes a BookItem from the Items Collection.
     * Birectionnal association : remove the current  instance
     * from the given Items parameter.
     * @param ItemsElt Element to remove
     */
    public void removeBookItem(final BookItem ItemsElt) {
        items.remove(ItemsElt);
        ItemsElt.setBook(null);
    }





   
    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * Book and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        final Book castedOther = (Book) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
      
        if ((items == null && castedOther.getItems() != null) 
             || (items != null && !items.equals(
                castedOther.getItems()))){
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
        } 
       
        return result;
        // End of user code for hashCode
    }
/**
     * Output the information of Book
     * @return Returns the information
     */
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                   .append(super.toString())   

             ;
        return sb.toString();         
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

