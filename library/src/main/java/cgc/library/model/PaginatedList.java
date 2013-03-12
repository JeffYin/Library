package cgc.library.model;

import java.util.List;

public class PaginatedList<T> {

    public interface Parameters {
        String SORT = "sort";
        String PAGE = "page";
        String ASC = "asc";
        String DESC = "desc";
        String DIRECTION = "dir";
        String PAGE_LENGTH = "plen";
    }

    static public enum SortOrder { ASCENDING, DESCENDING };

    /** Set the default page size **/
    static public int DEFAULT_PAGE_SIZE = 25;


    /** current page index, starts at 0 */
    private int index;

    /** number of results per page (number of rows per page to be displayed )  */
    private int pageSize;

    /** total number of results (the total number of rows  ) */
    private long totalListSize;

    /** list of results (rows found ) in the current page */
    private List<T> list;

    /** default sorting order */
    private SortOrder sortDirection = SortOrder.ASCENDING;

    /** sort criteria (sorting property name) */
    private String sortCriterion;

    /**  default constructor **/
    public PaginatedList() {
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.index = 0;
    }


    /**Create <code>PaginatedListImpl</code> instance using the <code>HttpServletRequest</code> object.
     * @param pageSize the page size - the total number of rows per page.
     */
    public PaginatedList(int pageSize) {
        this.pageSize = pageSize != 0 ? pageSize : DEFAULT_PAGE_SIZE ;
        index = 0;
    }

    public int getFirstRecordIndex() {
        return index * pageSize;
    }

    /** return the index.
     * @return the index.
     */
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> results) {
        this.list = results;
    }

    public long getTotalListSize() {
        return totalListSize;
    }

    public void setTotalListSize(long total) {
        this.totalListSize = total;
    }

    /** return the total number of pages for the total number of rows.
     * @return the total.
     */
    public int getTotalPages() {
        return (int)Math.ceil(((double)totalListSize )/ pageSize);
    }

    public int getPageNumber() {
        return index + 1;
    }

    public String getSortCriterion() {
        return sortCriterion;
    }

    public SortOrder getSortDir() {
        return sortDirection;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    public void setSortDir(SortOrder sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setSortCriterion(String tableId, String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

}
