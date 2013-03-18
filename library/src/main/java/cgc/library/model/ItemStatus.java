package cgc.library.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item_status")
public class ItemStatus extends BaseObject {
	
	private static final long serialVersionUID = -4032542360353073605L;

	/**
     * Automatic primary key.
     */
    private Long id;
      
	
	
	private String code;

	
	
    private String name;
	
	private List<Item> itemList = new LinkedList<Item>();

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=16)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(length=64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	 @OneToMany(mappedBy="itemStatus")          
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemList == null) ? 0 : itemList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ItemStatus other = (ItemStatus) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemStatus [id=" + id + ", code=" + code + ", name=" + name
				+ ", itemList=" + itemList + "]";
	} 
	
	
	
	
}
