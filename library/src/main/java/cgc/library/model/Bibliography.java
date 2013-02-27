package cgc.library.model;

// Start of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
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
     * Field price.
     */
    private BigDecimal price;

    /**
     * Field publisher.
     */
    private Publisher publisher;

    /**
     * Field tag.
     */
    private Tag tag;



    /**
     * Field cover.
     */
  
    private Blob cover;


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
     * Constructor with all parameters initialized.
     * @param someTitle
     *           
     * @param somePublishedDate
     *           
     * @param somePublishedVersion
     *           
     * @param someBriefIntroduction
     *           
     * @param someCallNumber
     *           
     * @param someAuthor
     *           
     * @param someAuthorAlias
     *           
     * @param somePrice
     *           
     * @param somePublisher
     *           
     * @param someTag
     *           
     */
    public Bibliography(String someTitle, Date somePublishedDate, Integer somePublishedVersion, String someBriefIntroduction, String someCallNumber, String someAuthor, String someAuthorAlias, BigDecimal somePrice, Publisher somePublisher, Tag someTag) {
        title = someTitle;
        publishedDate = somePublishedDate;
        publishedVersion = somePublishedVersion;
        briefIntroduction = someBriefIntroduction;
        callNumber = someCallNumber;
        author = someAuthor;
        authorAlias = someAuthorAlias;
        price = somePrice;
        publisher = somePublisher;
        tag = someTag;
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
    
 
 
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  	@JoinTable(
  	    name="bibliography_publisher",
        joinColumns=@JoinColumn(name="BIBLIOGRAPHY_ID"),
        inverseJoinColumns=@JoinColumn(name="PUBLISHER_ID")          		
        )
                	public Publisher getPublisher() {
	        
	        return publisher;
    }
    			
             
             
                  /**
     * Sets a value to parameter publisher.
     * @param somePublisher
     *            
     */
    public void setPublisher(final Publisher somePublisher) {
        publisher = somePublisher;
    }
 
    
    

 
 
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  	@JoinTable(
  	    name="bibliography_tag",
        joinColumns=@JoinColumn(name="BIBLIOGRAPHY_ID"),
        inverseJoinColumns=@JoinColumn(name="TAG_ID")          		
        )
                	public Tag getTag() {
	        
	        return tag;
    }
    			
             
             
                  /**
     * Sets a value to parameter tag.
     * @param someTag
     *            
     */
    public void setTag(final Tag someTag) {
        tag = someTag;
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

    /**
     * Equality test based on attributes values.
     * @param other Value to compare
     * @return Returns true if and only if given object is an instance of
     * Bibliography and the given object has the same PK as this
     * if the PK is not null or their fields are equal.
     */
    @Override
    public boolean equals(final Object other) {
        // Start of user code for equals
        if (this == other) {
            return true;
        }
        if (!(other instanceof Bibliography)) {
            return false;
        }
        final Bibliography castedOther = (Bibliography) other;
        Long id=getId();
        if (id != null && castedOther.getId() != null) {
            return id.equals(castedOther.getId());
        }
        if ((title == null && castedOther.getTitle() != null) 
             || (title != null && !title.equals(
                castedOther.getTitle()))){
           return false;
        }
        if ((publishedDate == null && castedOther.getPublishedDate() != null) 
             || (publishedDate != null && !publishedDate.equals(
                castedOther.getPublishedDate()))){
           return false;
        }
        if ((publishedVersion == null && castedOther.getPublishedVersion() != null) 
             || (publishedVersion != null && !publishedVersion.equals(
                castedOther.getPublishedVersion()))){
           return false;
        }
        if ((briefIntroduction == null && castedOther.getBriefIntroduction() != null) 
             || (briefIntroduction != null && !briefIntroduction.equals(
                castedOther.getBriefIntroduction()))){
           return false;
        }
        if ((callNumber == null && castedOther.getCallNumber() != null) 
             || (callNumber != null && !callNumber.equals(
                castedOther.getCallNumber()))){
           return false;
        }
        if ((author == null && castedOther.getAuthor() != null) 
             || (author != null && !author.equals(
                castedOther.getAuthor()))){
           return false;
        }
        if ((authorAlias == null && castedOther.getAuthorAlias() != null) 
             || (authorAlias != null && !authorAlias.equals(
                castedOther.getAuthorAlias()))){
           return false;
        }
        if ((publisher == null && castedOther.getPublisher() != null) 
             || (publisher != null && !publisher.equals(
                castedOther.getPublisher()))){
           return false;
        }
        if ((tag == null && castedOther.getTag() != null) 
             || (tag != null && !tag.equals(
                castedOther.getTag()))){
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
            if (title != null) {
                result = 29 * result + title.hashCode();
            }
            if (publishedDate != null) {
                result = 29 * result + publishedDate.hashCode();
            }
            result = 29 * result + publishedVersion;
            if (briefIntroduction != null) {
                result = 29 * result + briefIntroduction.hashCode();
            }
            if (callNumber != null) {
                result = 29 * result + callNumber.hashCode();
            }
            if (author != null) {
                result = 29 * result + author.hashCode();
            }
            if (authorAlias != null) {
                result = 29 * result + authorAlias.hashCode();
            }
         }
       
        return result;
        // End of user code for hashCode
    }
/**
     * Output the information of Bibliography
     * @return Returns the information
     */
    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                   .append("title", this.title)    
             .append("publishedDate", this.publishedDate)    
             .append("publishedVersion", this.publishedVersion)    
             .append("briefIntroduction", this.briefIntroduction)    
             .append("callNumber", this.callNumber)    
             .append("author", this.author)    
             .append("authorAlias", this.authorAlias)    
             .append("price", this.price)    

             ;
        return sb.toString();         
    }
    // Start of user code for private methods
    // TODO Remove this line and add your private methods here
    // End of user code for private methods

}

