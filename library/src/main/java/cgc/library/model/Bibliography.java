package cgc.library.model;

// Start of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// End of user code for imports
/**
 */
  @Entity
  @Table(name="bibliography")
@Inheritance(strategy=InheritanceType.JOINED)
public class Bibliography extends BaseObject implements Serializable {

    /**
     * serialVersionUID is used for serialization.
     */
    private static final long serialVersionUID = -29818174150898112L;


    /**
     * Automatic primary key.
     */
    private Long id;
      

    /**
     * Field title.
     */
    private String title;

    /**
     * Field publishedDate.
     */
    private Date publishedDate;

    /**
     * Field publishedVersion.
     */
    private Integer publishedVersion;

    /**
     * Field briefIntroduction.
     */
    private String briefIntroduction;

    /**
     * Field callNumber.
     */
    private String callNumber;

    /**
     * Field author.
     */
    private String author;

    /**
     * Field authorAlias.
     */
    private String authorAlias;

    /**
     * The maximum dueDays. 
     */
    private Integer dueDays;
    /**
     * Field price.
     */
    private BigDecimal price;

    /**
     * Field publisher.
     */
    private String publisher;

    /**
     * Field tag.
     */
    private List<Tag>  tags = new LinkedList<Tag>();
    
    
    /**
     * Field Items.
     */
    private List<Item> items = new LinkedList<Item>();;
    
    
    /**
     * Field cover.
     */
  
    private Blob cover;
    
    
    /**
     * 
     */
    private Date purchedDate;
    
    
    
     
	/* To support bidirectional databinding */
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
}
	
    /**
     * Default constructor.
     */
    public Bibliography() {
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
     * Returns String title.
     */
     
	 @Column (name="title")
    public String getTitle() {
        return title;
    }

    /**
     * Sets a value to parameter title.
     * @param someTitle
     *            
     */
    public void setTitle(final String someTitle) {
       propertyChangeSupport.firePropertyChange("title", this.title, this.title=someTitle);
    }
    /**
     * Returns EDate publishedDate.
     */
     
     
    
     
	 @Column (name="published_date")
    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets a value to parameter publishedDate.
     * @param somePublishedDate
     *            
     */
    public void setPublishedDate(final Date somePublishedDate) {
       propertyChangeSupport.firePropertyChange("publishedDate", this.publishedDate, this.publishedDate=somePublishedDate);
    }
    /**
     * Returns Integer publishedVersion.
     */
    
     
	 @Column (name="published_version")
    public Integer getPublishedVersion() {
        return publishedVersion;
    }

    /**
     * Sets a value to parameter publishedVersion.
     * @param somePublishedVersion
     *            
     */
    public void setPublishedVersion(final Integer somePublishedVersion) {
       propertyChangeSupport.firePropertyChange("publishedVersion", this.publishedVersion, this.publishedVersion=somePublishedVersion);
    }
    /**
     * Returns String briefIntroduction.
     */
     
     
    
     
	 @Column (name="brief_introduction", length=4096)
    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    /**
     * Sets a value to parameter briefIntroduction.
     * @param someBriefIntroduction
     *            
     */
    public void setBriefIntroduction(final String someBriefIntroduction) {
       propertyChangeSupport.firePropertyChange("briefIntroduction", this.briefIntroduction, this.briefIntroduction=someBriefIntroduction);
    }
    /**
     * Returns String callNumber.
     */
     
     
    
     
	 @Column (name="call_number")
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * Sets a value to parameter callNumber.
     * @param someCallNumber
     *            
     */
    public void setCallNumber(final String someCallNumber) {
       propertyChangeSupport.firePropertyChange("callNumber", this.callNumber, this.callNumber=someCallNumber);
    }
    /**
     * Returns String author.
     */
     
     
    
     
	 @Column (name="author")
    public String getAuthor() {
        return author;
    }

    /**
     * Sets a value to parameter author.
     * @param someAuthor
     *            
     */
    public void setAuthor(final String someAuthor) {
       propertyChangeSupport.firePropertyChange("author", this.author, this.author=someAuthor);
    }
    /**
     * Returns String authorAlias.
     */
     
     
    
     
	 @Column (name="author_alias")
    public String getAuthorAlias() {
        return authorAlias;
    }

    /**
     * Sets a value to parameter authorAlias.
     * @param someAuthorAlias
     *            
     */
    public void setAuthorAlias(final String someAuthorAlias) {
       propertyChangeSupport.firePropertyChange("authorAlias", this.authorAlias, this.authorAlias=someAuthorAlias);
    }
    /**
     * Returns BigDecimal price.
     */
     
     
    
     
	 @Column (name="price")
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets a value to parameter price.
     * @param somePrice
     *            
     */
    public void setPrice(final BigDecimal somePrice) {
       propertyChangeSupport.firePropertyChange("price", this.price, this.price=somePrice);
    }
    
    public String getPublisher() {
    	return publisher; 
    }
    
   /**
     * Sets a value to parameter publisher.
     * @param somePublisher
     *            
     */
    public void setPublisher(final String somePublisher) {
        publisher = somePublisher;
    }
 
 
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
  		   name = "bibliography_tag", 
  	       joinColumns = {@JoinColumn(name = "BIBLIOGRAPHY_ID", nullable = false, updatable = false)}, 
		   inverseJoinColumns = {@JoinColumn(name = "TAG_ID",nullable = false, updatable = false)}
  		   )
  	    
    public List<Tag> getTags() {
       return tags;
    }
    			
             
             
                  /**
     * Sets a value to parameter tag.
     * @param someTags
     *            
     */
    public void setTags(List<Tag> someTags) {
        tags = someTags;
    }
    
    
    /**
     * Adds a Tag to the bibliographies Collection.
     * Birectionnal association : add the current  instance to
     * the given bibliographies parameter.
     * @param bibliographiesElt Element to add
     */
    public void addTag(Tag someTag) {
        tags.add(someTag);
    }

    /**
     * Removes a Bibliography from the bibliographies Collection.
     * Birectionnal association : remove the current  instance
     * from the given bibliographies parameter.
     * @param someTag Element to remove
     */
    public void removeTag(Tag someTag) {
        tags.remove(someTag);
        someTag.removeBibliography(this);
    }
    
    @Lob
    @Basic(fetch=FetchType.LAZY)
    public Blob getCover() {
        return cover;
    }
    
    /**
     * Sets a value to parameter cover.
     * @param someCover
     *            
     */
    public void setCover(final Blob someCover) {
       propertyChangeSupport.firePropertyChange("cover", this.cover, this.cover=someCover);
    }

    
	public Date getPurchedDate() {
		return purchedDate;
	}

	public void setPurchedDate(Date purchedDate) {
		this.purchedDate = purchedDate;
	}

	
	public Integer getDueDays() {
		return dueDays;
	}

	public void setDueDays(Integer dueDays) {
		this.dueDays = dueDays;
	}

	

	 @OneToMany(mappedBy="bibliography")          
	public List<Item> getItems() {
	        return items;
   }
   			
   public void setItems(final List<Item> someItems) {
       items = someItems;
   }
	  

	/**
     * Adds a BookItem to the Items Collection.
     * Birectionnal association : add the current  instance to
     * the given Items parameter.
     * @param ItemsElt Element to add
     */
    public void addBookItem(final Item ItemsElt) {
        items.add(ItemsElt);
        ItemsElt.setBibliography(this);
    }
    
    /**
     * Removes a BookItem from the Items Collection.
     * Birectionnal association : remove the current  instance
     * from the given Items parameter.
     * @param ItemsElt Element to remove
     */
    public void removeBookItem(final BookItem ItemsElt) {
        items.remove(ItemsElt);
        ItemsElt.setBibliography(null);
    }

    
	/**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * Bibliography and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
   

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((authorAlias == null) ? 0 : authorAlias.hashCode());
		result = prime
				* result
				+ ((briefIntroduction == null) ? 0 : briefIntroduction
						.hashCode());
		result = prime * result
				+ ((callNumber == null) ? 0 : callNumber.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((dueDays == null) ? 0 : dueDays.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime
				* result
				+ ((propertyChangeSupport == null) ? 0 : propertyChangeSupport
						.hashCode());
		result = prime * result
				+ ((publishedDate == null) ? 0 : publishedDate.hashCode());
		result = prime
				* result
				+ ((publishedVersion == null) ? 0 : publishedVersion.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result
				+ ((purchedDate == null) ? 0 : purchedDate.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bibliography other = (Bibliography) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (authorAlias == null) {
			if (other.authorAlias != null)
				return false;
		} else if (!authorAlias.equals(other.authorAlias))
			return false;
		if (briefIntroduction == null) {
			if (other.briefIntroduction != null)
				return false;
		} else if (!briefIntroduction.equals(other.briefIntroduction))
			return false;
		if (callNumber == null) {
			if (other.callNumber != null)
				return false;
		} else if (!callNumber.equals(other.callNumber))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (dueDays == null) {
			if (other.dueDays != null)
				return false;
		} else if (!dueDays.equals(other.dueDays))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (propertyChangeSupport == null) {
			if (other.propertyChangeSupport != null)
				return false;
		} else if (!propertyChangeSupport.equals(other.propertyChangeSupport))
			return false;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		if (publishedVersion == null) {
			if (other.publishedVersion != null)
				return false;
		} else if (!publishedVersion.equals(other.publishedVersion))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (purchedDate == null) {
			if (other.purchedDate != null)
				return false;
		} else if (!purchedDate.equals(other.purchedDate))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

/**
     * Output the information of Bibliography
     * @return Returns the information
     */
    @Override
    public String toString() {
    	return "Bibliography [id=" + id + ", title=" + title + ", publishedDate="
    			+ publishedDate + ", publishedVersion=" + publishedVersion
    			+ ", briefIntroduction=" + briefIntroduction + ", callNumber="
    			+ callNumber + ", author=" + author + ", authorAlias="
    			+ authorAlias + ", dueDays=" + dueDays + ", price=" + price
    			+ ", publisher=" + publisher + ", tags=" + tags + ", cover="
    			+ cover + ", purchedDate=" + purchedDate
    			+ ", propertyChangeSupport=" + propertyChangeSupport + "]";
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

