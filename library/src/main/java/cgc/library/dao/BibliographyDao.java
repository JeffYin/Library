package cgc.library.dao;

import cgc.library.model.Bibliography;

public interface BibliographyDao extends GenericDao<Bibliography, Long>{
	 /**
     * Get the cover image. 
     * @param bookId
     * @return
     */
    public byte[] getCoverImg(Long biblioGraphyId);
}
