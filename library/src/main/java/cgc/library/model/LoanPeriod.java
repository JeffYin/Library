package cgc.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="loan_period")
public class LoanPeriod extends BaseObject {

	private static final long serialVersionUID = 1947451125241039188L;
	
	private Long id; 
	private Integer bookLoanPeriod;
	private Integer movieLoanPeriod;
	
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getBookLoanPeriod() {
		return bookLoanPeriod;
	}
	public void setBookLoanPeriod(Integer bookLoanPeriod) {
		this.bookLoanPeriod = bookLoanPeriod;
	}
	public Integer getMovieLoanPeriod() {
		return movieLoanPeriod;
	}
	public void setMovieLoanPeriod(Integer movieLoanPeriod) {
		this.movieLoanPeriod = movieLoanPeriod;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookLoanPeriod == null) ? 0 : bookLoanPeriod.hashCode());
		result = prime * result
				+ ((movieLoanPeriod == null) ? 0 : movieLoanPeriod.hashCode());
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
		LoanPeriod other = (LoanPeriod) obj;
		if (bookLoanPeriod == null) {
			if (other.bookLoanPeriod != null)
				return false;
		} else if (!bookLoanPeriod.equals(other.bookLoanPeriod))
			return false;
		if (movieLoanPeriod == null) {
			if (other.movieLoanPeriod != null)
				return false;
		} else if (!movieLoanPeriod.equals(other.movieLoanPeriod))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ApplicationConfig [bookLoanPeriod=" + bookLoanPeriod
				+ ", movieLoanPeriod=" + movieLoanPeriod + "]";
	}
	
	
	
}
