/**
 * 
 */
package net.rlviana.pricegrabber.model.search;

import java.io.Serializable;

import net.rlviana.pricegrabber.model.entity.IEntity;

/**
 * Interface to implement search criteria applied to defined persistence entity
 * 
 * @author ramon
 * 
 * @param <T> Entity class
 * @param <K> Entity Key class
 */
public interface ISearchCriteria<T extends IEntity<K>, K extends Serializable> {

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
