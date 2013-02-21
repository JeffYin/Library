package cgc.library.model;

// Start of user code for imports
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cgc.library.model.BaseObject;

// End of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 */
 
import javax.persistence.*;

  @Entity
  @Table(name="library")
public class Library extends BaseObject implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = 54262477651613696L;


    /**
     * Automatic primary key.
     */
    private Long id;
      

    /**
     * Field name.
     */
    private String name;

    /**
     * Field items.
     */
    private List<Item> items;



	/* To support bidirectional databinding */
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
}
	
    /**
     * Default constructor.
     */
    public Library() {
        super();
        items = new ArrayList<Item>();
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
     * @param someName
     *           
     * @param someItems
     *           
     */
    public Library(String someName, List<Item> someItems) {
        name = someName;
        items = someItems;
    }

    /**
     * Returns String name.
     */
     
     
    
     
	 @Column (name="name")
    public String getName() {
        return name;
    }

    /**
     * Sets a value to parameter name.
     * @param someName
     *            
     */
    public void setName(final String someName) {
       propertyChangeSupport.firePropertyChange("name", this.name, this.name=someName);
    }
    
		 
	 @OneToMany(mappedBy="library")          
	public List<Item> getItems() {
	        
	        return items;
    }
    			
             
             
                  /**
     * Sets a value to parameter items.
     * @param someItems
     *            
     */
    public void setItems(final List<Item> someItems) {
        items = someItems;
    }
 
    
    

    /**
     * Adds a Item to the items Collection.
     * Birectionnal association : add the current  instance to
     * the given items parameter.
     * @param itemsElt Element to add
     */
    public void addItem(final Item itemsElt) {
        items.add(itemsElt);
        itemsElt.setLibrary(this);
    }

    /**
     * Removes a Item from the items Collection.
     * Birectionnal association : remove the current  instance
     * from the given items parameter.
     * @param itemsElt Element to remove
     */
    public void removeItem(final Item itemsElt) {
        items.remove(itemsElt);
        itemsElt.setLibrary(null);
    }





   
    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * Library and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof Library)) {
            return false;
        }
        final Library castedOther = (Library) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
        if ((name == null && castedOther.getName() != null) 
             || (name != null && !name.equals(
                castedOther.getName()))){
           return false;
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
        } else {
            if (name != null) {
                result = 29 * result + name.hashCode();
            }
         }
       
        return result;
        // End of user code for hashCode
    }
/**
     * Output the information of Library
     * @return Returns the information
     */
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                   .append("name", this.name)    

             ;
        return sb.toString();         
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

