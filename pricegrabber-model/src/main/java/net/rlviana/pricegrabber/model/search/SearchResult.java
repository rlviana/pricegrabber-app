package net.rlviana.pricegrabber.model.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * It's an utility class used to wrap responses, paged or not.
 * 
 * @param <T> Entity class result type
 * @author ramon
 * 
 */
public class SearchResult<T> implements Serializable {

  /** serialVersionUID */
  private static final long serialVersionUID = 1L;

  /** firstResult according to list */
  private long firstResult;

  /** total number of results for the given query */
  private long total;

  /** last page element */
  private boolean last;

  /** Returned results */
  private List<T> results = null;

  /**
   * Constructor
   */
  public SearchResult() {
    results = new ArrayList<T>();
  }

  /**
   * @return the firstResult
   */
  public final long getFirstResult() {
    return firstResult;
  }

  /**
   * @param firstResult the firstResult to set
   */
  public final void setFirstResult(final long firstResult) {
    this.firstResult = firstResult;
  }

  /**
   * @return the total
   */
  public final long getTotal() {
    return total;
  }

  /**
   * @param total the total to set
   */
  public final void setTotal(final long total) {
    this.total = total;
  }

  /**
   * @return the results
   */
  public final List<T> getResults() {
    return results;
  }

  /**
   * @param results the results to set
   */
  public final void setResults(final List<T> results) {
    this.results = results;
  }

  /**
   * @param result to add
   */
  public final void addResult(final T result) {
    results.add(result);
  }

  public final int getResultSize() {
    return results.size();
  }

  /**
   * @param last the values of last to set
   */
  public final void setLast(final boolean last) {
    this.last = last;
  }

  /**
   * Utility Method to indicate if it's the last page
   * 
   * @return <code>true</code> if contains last element
   */
  public final boolean isLast() {
    return last;
  }

  /**
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SearchResult [firstResult=")
        .append(firstResult)
        .append(", total=")
        .append(total)
        .append(", results=")
        .append(results)
        .append("]");
    return builder.toString();
  }

}
