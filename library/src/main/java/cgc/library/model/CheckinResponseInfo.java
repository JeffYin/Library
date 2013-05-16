package cgc.library.model;

/**
 * 
 * @author Developer
 *
 */
public class CheckinResponseInfo {
  private Reader reader; 
  private Item  item;
  
  
  
  public CheckinResponseInfo() {
	  super();
  }
	public CheckinResponseInfo(Reader reader, Item item) {
	super();
	this.reader = reader;
	this.item = item;
}
	public Reader getReader() {
		return reader;
	}
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
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
		CheckinResponseInfo other = (CheckinResponseInfo) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (reader == null) {
			if (other.reader != null)
				return false;
		} else if (!reader.equals(other.reader))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CheckinResponseInfo [reader=" + reader + ", item=" + item + "]";
	} 
  

	
}
