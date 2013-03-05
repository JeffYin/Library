package cgc.library.model;

// Start of user code for imports
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
// End of user code for imports
/**
 */

  @Entity
  @Table(name="book_item")
public class BookItem extends Item implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = 54003148170080640L;


    /**
     * Field book.
     */
    private Book book;



	
    /**
     * Default constructor.
     */
    public BookItem() {
        super();
    }


    /**
     * Constructor with all parameters initialized.
     * @param someBook
     *           
     */
    public BookItem(Book someBook) {
        book = someBook;
    }

    
 
 
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "BOOK_ID", nullable = false)
     public Book getBook() {
	        return book;
    }
    			
             
             
                  /**
     * Sets a value to parameter book.
     * @param someBook
     *            
     */
    public void setBook(final Book someBook) {
        book = someBook;
    }
 
    
    






   
    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * BookItem and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookItem)) {
            return false;
        }
        final BookItem castedOther = (BookItem) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
        if ((book == null && castedOther.getBook() != null) 
             || (book != null && !book.equals(
                castedOther.getBook()))){
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
         }
       
        return result;
        // End of user code for hashCode
    }
/**
     * Output the information of BookItem
     * @return Returns the information
     */
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
      
             ;
        return sb.toString();         
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

