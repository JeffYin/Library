package cgc.library.data;

import java.io.Serializable;
import java.util.Date;

public class BookRecordQueryForm implements Serializable {
	private static final long serialVersionUID = 1858816816974819173L;
	private Date borrowDateStart;

	public Date getBorrowDateStart() {
		return borrowDateStart;
	}

	public void setBorrowDateStart(Date borrowDateStart) {
		this.borrowDateStart = borrowDateStart;
	} 
	
	
}
