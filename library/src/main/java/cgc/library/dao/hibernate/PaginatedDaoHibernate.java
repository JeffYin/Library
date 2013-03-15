package cgc.library.dao.hibernate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import cgc.library.dao.PaginatedDao;
import cgc.library.model.PaginatedList;
import cgc.library.model.PaginatedList.SortOrder;



public class PaginatedDaoHibernate<T, PK extends Serializable> extends GenericDaoHibernate<T, PK> implements PaginatedDao<T, PK> {

    public PaginatedDaoHibernate(Class<T> persistentClass) {
		super(persistentClass);
	}

    public PaginatedList<T> getAllPaginated(PaginatedList<T> thePage) {
        Session session = getSession();
        // obtain all instances of a class:
        Criteria criteria = session.createCriteria(super.persistentClass);
        // let's see how many instances are in total:
    	criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        thePage.setTotalListSize(count.intValue());
        // set criteria back to obtaining entities
        criteria.setProjection(null);
        criteria.setResultTransformer(Criteria.ROOT_ENTITY);

        if (thePage.getSortCriterion() != null) {
	    	Order order;
	    	if (thePage.getSortDir() == SortOrder.ASCENDING) {
	    		order = Order.asc(thePage.getSortCriterion());
	    	} else {
	    		order = Order.desc(thePage.getSortCriterion());
	    	}
	    	criteria.addOrder(order);
    	}
    	criteria.setFirstResult(thePage.getFirstRecordIndex());
    	criteria.setMaxResults(thePage.getPageSize());
    	thePage.setList(criteria.list());
    	return thePage;
    }

    public PaginatedList<T> getPaginatedListByQuery(
            PaginatedList<T> thePage, String qryString,
            LinkedHashMap<String, String> qryParams) {
        Session session = getSession();
        Query query = session.createQuery(qryString).setFirstResult(thePage.getFirstRecordIndex()).setMaxResults(thePage.getPageSize());
        query.setProperties(qryParams);
        thePage.setList(query.list());
        return thePage;
    }

    public PaginatedList<T> getPaginatedListByQuery(
            PaginatedList<T> thePage, String queryString,
            List<Object> params) {
        Session session = getSession();
        if (thePage.getSortCriterion() != null){
            if (thePage.getSortDir().equals(SortOrder.ASCENDING)){
                queryString = queryString.concat(" order by " + Order.asc(thePage.getSortCriterion()).toString());
            }
            if (thePage.getSortDir().equals(SortOrder.DESCENDING)){
                queryString = queryString.concat(" order by " + Order.desc(thePage.getSortCriterion()).toString());
            }
        }
        Query query = session.createQuery(queryString)
                .setFirstResult(thePage.getFirstRecordIndex()).setMaxResults(thePage.getPageSize());
        setParameters(query, params);
        thePage.setList(query.list());
        return thePage;
    }
    
    public long getTotalCountOfRowsByQuery(String countQueryString, List<Object> params) {
        Session session = getSession();
        Query query = session.createQuery(countQueryString);
        setParameters(query, params);
        Long longValue = (Long) query.uniqueResult();
        return longValue;
    }

    public long getTotalCountOfRowsByQuery(String countQueryString, LinkedHashMap<String, String> params) {
        Session session = getSession();
        Query query = session.createQuery(countQueryString);
        setParameters(query, params);
        Long longValue = (Long) query.uniqueResult();
        return longValue;
    }

    private void setParameters(Query query, LinkedHashMap<String, String> params) {
    	if (params != null) {
    		Iterator<Entry<String, String>> it = params.entrySet().iterator();
    		while (it.hasNext()) {
    			Entry<String, String> pair = it.next();
    			query.setParameter(pair.getKey(), pair.getValue());
    		}
    	}
	}

	/**
     * Setting parameters from a list.
     * @param query the <code>org.hibernate.Query</code> instance.
     * @param params the Params.
     * @return the <code>org.hibernate.Query</code> instance with parameters bounded.
     */
    private Query setParameters(Query query, List<Object> params) {
    	if (params != null) {
	        Iterator<Object> iter = params.iterator();
	        int position = 0;
	        while (iter.hasNext()) {
	            Object param = iter.next();
	            query.setParameter(position, param);
	            position++;
	        }
    	}
        return query;
    }
    
}
