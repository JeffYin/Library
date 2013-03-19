package cgc.library.model;

// Start of user code for imports
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

// End of user code for imports
/**
 */
@NamedQueries(
   @NamedQuery(
		name = "findReaderByCardId", 
		query = "from Reader r where r.cardId like :cardId"
		   )	
		
		)


@Entity
@Table(name = "reader")
public class Reader extends BaseObject implements Serializable {

	/**
	 * serialVersionUID is used for serialization.
	 */
	private static final long serialVersionUID = 99481172535209264L;

	/**
	 * Automatic primary key.
	 */
	private Long id;

	/**
	 * Field cardId.
	 */
	private String cardId;

	/**
	 * Field name.
	 */
	private String name;

	/**
	 * Field mainPhone.
	 */
	private String mainPhone;

	/**
	 * Field alterPhone.
	 */
	private String alterPhone;

	/**
	 * Field email.
	 */
	private String email;
	
	private List<BorrowRecord> borrowRecords; 

	/* To support bidirectional databinding */
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	/**
	 * Default constructor.
	 */
	public Reader() {
		super();
	}

	/**
	 * Returns the identifier.
	 * 
	 * @return Returns id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * Sets a value to parameter Id.
	 * 
	 * @param someId
	 *            Value of the identifier.
	 */
	public void setId(final Long someId) {
		id = someId;
	}

	/**
	 * Returns EString cardId.
	 */
	@Column(name = "card_id")
	public String getCardId() {
		return cardId;
	}

	/**
	 * Sets a value to parameter cardId.
	 * 
	 * @param someCardId
	 * 
	 */
	public void setCardId(final String someCardId) {
		propertyChangeSupport.firePropertyChange("cardId", this.cardId,
				this.cardId = someCardId);
	}

	/**
	 * Returns EString name.
	 */

	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Sets a value to parameter name.
	 * 
	 * @param someName
	 * 
	 */
	public void setName(final String someName) {
		propertyChangeSupport.firePropertyChange("name", this.name,
				this.name = someName);
	}

	/**
	 * Returns EString mainPhone.
	 */
	@Column(name = "main_phone")
	public String getMainPhone() {
		return mainPhone;
	}

	/**
	 * Sets a value to parameter mainPhone.
	 * 
	 * @param someMainPhone
	 * 
	 */
	public void setMainPhone(final String someMainPhone) {
		propertyChangeSupport.firePropertyChange("mainPhone", this.mainPhone,
				this.mainPhone = someMainPhone);
	}

	/**
	 * Returns EString alterPhone.
	 */

	@Column(name = "alter_phone")
	public String getAlterPhone() {
		return alterPhone;
	}

	/**
	 * Sets a value to parameter alterPhone.
	 * 
	 * @param someAlterPhone
	 * 
	 */
	public void setAlterPhone(final String someAlterPhone) {
		propertyChangeSupport.firePropertyChange("alterPhone", this.alterPhone,
				this.alterPhone = someAlterPhone);
	}

	/**
	 * Returns EString email.
	 */

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	/**
	 * Sets a value to parameter email.
	 * 
	 * @param someEmail
	 * 
	 */
	public void setEmail(final String someEmail) {
		propertyChangeSupport.firePropertyChange("email", this.email,
				this.email = someEmail);
	}
	
	

	 @OneToMany(mappedBy="reader")          
	public List<BorrowRecord> getBorrowRecords() {
	        return borrowRecords;
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
	 * 
	 * @param other
	 *            Value to compare
	 * @return Returns true if and only if given object is an instance of Reader
	 *         and the given object has the same PK as this if the PK is not
	 *         null or their fields are equal.
	 */
	@Override
	public boolean equals(final Object other) {
		// Start of user code for equals
		if (this == other) {
			return true;
		}
		if (!(other instanceof Reader)) {
			return false;
		}
		final Reader castedOther = (Reader) other;
		Long id = getId();
		if (id != null && castedOther.getId() != null) {
			return id.equals(castedOther.getId());
		}
		if ((cardId == null && castedOther.getCardId() != null)
				|| (cardId != null && !cardId.equals(castedOther.getCardId()))) {
			return false;
		}
		if ((name == null && castedOther.getName() != null)
				|| (name != null && !name.equals(castedOther.getName()))) {
			return false;
		}
		if ((mainPhone == null && castedOther.getMainPhone() != null)
				|| (mainPhone != null && !mainPhone.equals(castedOther
						.getMainPhone()))) {
			return false;
		}
		if ((alterPhone == null && castedOther.getAlterPhone() != null)
				|| (alterPhone != null && !alterPhone.equals(castedOther
						.getAlterPhone()))) {
			return false;
		}
		if ((email == null && castedOther.getEmail() != null)
				|| (email != null && !email.equals(castedOther.getEmail()))) {
			return false;
		}
		return true;
		// End of user code for equals
	}

	/**
	 * HashTable code based on attributes hashcodes.
	 * 
	 * @return Returns hash value
	 */
	@Override
	public int hashCode() {
		// Start of user code for hashCode
		int result = 0;
		Long id = getId();
		if (id != null) {
			result = id.hashCode();
		} else {
			if (cardId != null) {
				result = 29 * result + cardId.hashCode();
			}
			if (name != null) {
				result = 29 * result + name.hashCode();
			}
			if (mainPhone != null) {
				result = 29 * result + mainPhone.hashCode();
			}
			if (alterPhone != null) {
				result = 29 * result + alterPhone.hashCode();
			}
			if (email != null) {
				result = 29 * result + email.hashCode();
			}
		}

		return result;
		// End of user code for hashCode
	}

	/**
	 * Output the information of Reader
	 * 
	 * @return Returns the information
	 */
	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this,
				ToStringStyle.DEFAULT_STYLE).append("cardId", this.cardId)
				.append("name", this.name).append("mainPhone", this.mainPhone)
				.append("alterPhone", this.alterPhone)
				.append("email", this.email)

		;
		return sb.toString();
	}
}
