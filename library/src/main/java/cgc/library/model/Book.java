package cgc.library.model;

// Start of user code for imports
import java.io.Serializable;
import java.util.LinkedList;

import javax.persistence.Entity;
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

    private LinkedList<BookItem> tempItems;


     
	
    /**
     * Default constructor.
     */
    public Book() {
        super();
        tempItems = new LinkedList<BookItem>();
    }


	public void setTempItems(LinkedList<BookItem> tempItems) {
		this.tempItems = tempItems;
	}

    @Transient
    public LinkedList<BookItem> getTempItems() {
		return tempItems;
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

