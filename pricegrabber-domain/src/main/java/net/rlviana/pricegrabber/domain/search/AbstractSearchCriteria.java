/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.domain.search;

/**
 * Abstract class to implement for entity search capabilities.<br/>
 * It contains the parameters of the desired query
 * 
 * @author ramon
 */
public abstract class AbstractSearchCriteria implements ISearchCriteria {

  /** maxResults to return. */
  private int maxResults = 0;

  /** First result to return. */
  private int firstResult = 0;

  /**
   * @return the maxResults
   */
  @Override
  public final int getMaxResults() {
    return maxResults;
  }

  /**
   * @param maxResults the maxResults to set
   */
  @Override
  public final void setMaxResults(final int maxResults) {
    this.maxResults = maxResults;
  }

  /**
   * @return the firstResult
   */
  @Override
  public final int getFirstResult() {
    return firstResult;
  }

  /**
   * @param firstResult the firstResult to set
   */
  @Override
  public final void setFirstResult(final int firstResult) {
    this.firstResult = firstResult;
  }

}
