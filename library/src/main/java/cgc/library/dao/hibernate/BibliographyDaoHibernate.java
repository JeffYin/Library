package cgc.library.dao.hibernate;

// Start of user code for import
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
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
          List<Blob> coverList = qry.list();
          if (coverList!=null && coverList.size()>0) {
        	  Blob cover = coverList.get(0); 
        	  byte buf[] = new byte[1024*16];
        	  InputStream is=null; 
        	  ByteArrayOutputStream baos = null;
        	  try {
				is = cover.getBinaryStream();
				baos = new ByteArrayOutputStream();
				int dataSize;
				while((dataSize = is.read(buf)) != -1) {
				        baos.write(buf, 0, dataSize);
				}
				byte[]coverByte = baos.toByteArray();
				return coverByte;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
			   if (is!=null) {
				   try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			   }
			   
			   if (baos!=null) {
				   try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
			}
        	  
          } 
          
          return null; 
          
    }
 
    
    
   
}
