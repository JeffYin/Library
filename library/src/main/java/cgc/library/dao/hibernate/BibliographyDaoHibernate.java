package cgc.library.dao.hibernate;

// Start of user code for import
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cgc.library.dao.BibliographyDao;
import cgc.library.model.Bibliography;

// End of user code for import

/**
 * This class provides the data access layer to the BookDaoHibernate entity class.<br/>
 * This is the interface which represents the contract of the DAO access.
 */
 @Repository
public class  BibliographyDaoHibernate extends GenericDaoHibernate<Bibliography,Long> implements BibliographyDao{
	 
     public BibliographyDaoHibernate() {
		super(Bibliography.class);
	}


	private transient final Log log = LogFactory.getLog(BookDaoHibernate.class);
     
    
    /**
     * Get the cover image. 
     * @param bookId
     * @return
     */
    @Override
	public byte[] getCoverImg(Long biblioGraphyId) {
    	  Query qry = getSession().createQuery("select cover from Bibliography b where b.id = :id");
    	  qry.setLong("id", biblioGraphyId);
          List<byte[]> coverList = qry.list();
          if (coverList!=null && coverList.size()>0) {
        	  return coverList.get(0); 
          } 
          
          return null; 
          
    }
 
   
}
