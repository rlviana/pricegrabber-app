package net.rlviana.pricegrabber.domain.search;

/**
 * Interface to implement by searchcriteria objects
 * 
 * @author ramon
 */
public interface ISearchCriteria {

  /**
   * @return the maxResults
   */
  public int getMaxResults();

  /**
   * @param maxResults the maxResults to set
   */
  public void setMaxResults(int maxResults);

  /**
   * @return the firstResult
   */
  public int getFirstResult();

  /**
   * @param firstResult the firstResult to set
   */
  public void setFirstResult(int firstResult);

}