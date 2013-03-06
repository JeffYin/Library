package cgc.library.model;

// Start of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
// End of user code for imports
/**
 */

  @Entity
  @Table(name="tag")
public class Tag extends BaseObject implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = -3720239775777279L;


    /**
     * Automatic primary key.
     */
    private Long id;
      

    /**
     * Field name.
     */
    private String name;

    /**
     * Field bibliographies.
     */
    private List<Bibliography> bibliographies;



	/* To support bidirectional databinding */
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
}
	
    /**
     * Default constructor.
     */
    public Tag() {
        super();
        bibliographies = new ArrayList<Bibliography>();
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
     * @param someBibliographies
     *           
     */
    public Tag(String someName, List<Bibliography> someBibliographies) {
        name = someName;
        bibliographies = someBibliographies;
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
    
		 
	 @ManyToMany(mappedBy="tags")          
	public List<Bibliography> getBibliographies() {
	        
	        return bibliographies;
    }
    			
             
             
   /**
     * Sets a value to parameter bibliographies.
     * @param someBibliographies
     *            
     */
    public void setBibliographies(final List<Bibliography> someBibliographies) {
        bibliographies = someBibliographies;
    }
 
    
    

    /**
     * Adds a Bibliography to the bibliographies Collection.
     * Birectionnal association : add the current  instance to
     * the given bibliographies parameter.
     * @param bibliographiesElt Element to add
     */
    public void addBibliography(final Bibliography bibliographiesElt) {
        bibliographies.add(bibliographiesElt);
        bibliographiesElt.addTag(this);
    }

    /**
     * Removes a Bibliography from the bibliographies Collection.
     * Birectionnal association : remove the current  instance
     * from the given bibliographies parameter.
     * @param bibliographiesElt Element to remove
     */
    public void removeBibliography(final Bibliography bibliographiesElt) {
        bibliographies.remove(bibliographiesElt);
        bibliographiesElt.setTag(null);
    }





   
    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * Tag and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        final Tag castedOther = (Tag) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
        if ((name == null && castedOther.getName() != null) 
             || (name != null && !name.equals(
                castedOther.getName()))){
           return false;
        }
        if ((bibliographies == null && castedOther.getBibliographies() != null) 
             || (bibliographies != null && !bibliographies.equals(
                castedOther.getBibliographies()))){
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
     * Output the information of Tag
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

