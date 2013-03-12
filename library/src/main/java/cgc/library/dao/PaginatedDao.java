package cgc.library.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import cgc.library.model.PaginatedList;

 
/**
/** <code>PaginatedDao</code> provides basic methods for pagination.
 * @author jgarcia
 *
 * @param <T>
 * @param <PK>
 */
public interface PaginatedDao<T, PK extends Serializable> extends GenericDao<T, PK> {

    /**
     * Get all objects of a type in a paginated way. Pagination params extracted from thePage
     * @param thePage
     * @return the asked page
     */
    PaginatedList<T> getAllPaginated(PaginatedList<T> thePage);
 
    /** 
     * Get the Rows based on the Query with a Map of Params, key is the Param Name.
     * @param thePage <code>PaginatedList<T></code> instance containing the desired page parameters.
     * @param queryString the HQL Query String.
     * @param params the Named Parameters.
     * @return <code>PaginatedList<T></code> instance.
     */
    PaginatedList<T> getPaginatedListByQuery(PaginatedList<T> thePage, String queryString, LinkedHashMap<String, String> qryParams);
    
    /** 
     * Get the Total number of Rows by executing a count query.
     * @param countQueryString the HQL count Query String.
     * @param params the Named parameters
     * @return the total number rows fetched by the query.
     */
    long getTotalCountOfRowsByQuery(String countQueryString, LinkedHashMap<String, String> params);
 
    /** Get the Rows based on the Query with a list of Params.
     * @param thePage <code>PaginatedList<T></code> instance containing the desired page parameters.
     * @param queryString the HQL Query String.
     * @param params the positional query parameters.
     * @return <code>PaginatedList<T></code> instance.
     */
    PaginatedList<T> getPaginatedListByQuery(PaginatedList<T> thePage, String queryString, List<Object> params);

    /** 
     * Get the Total number of Rows by executing a count query.
     * @param countQueryString the HQL count Query String.
     * @param params the positional parameters
     * @return the total number rows fetched by the query.
     */
    long getTotalCountOfRowsByQuery(String countQueryString, List<Object> params);

}
