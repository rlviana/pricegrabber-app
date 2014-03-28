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
  int getMaxResults();

  /**
   * @param maxResults the maxResults to set
   */
  void setMaxResults(int maxResults);

  /**
   * @return the firstResult
   */
  int getFirstResult();

  /**
   * @param firstResult the firstResult to set
   */
  void setFirstResult(int firstResult);

}
