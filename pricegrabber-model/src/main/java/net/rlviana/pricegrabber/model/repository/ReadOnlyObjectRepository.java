package net.rlviana.pricegrabber.model.repository;

import java.io.Serializable;
import java.util.List;

import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;
import net.rlviana.pricegrabber.model.search.SearchResult;

/**
 * Interface to implement when only reading is required
 * 
 * @author ramon
 * @param <T> Entity class
 * @param <K> Primary Key class for entity
 */
public interface ReadOnlyObjectRepository<T extends IEntity<K>, K extends Serializable> {

  /**
   * Finds entity by instance key
   * 
   * @param instanceKey of the entity to find
   * @return the found instance or null
   */
  T findById(K instanceKey);

  /**
   * Returns all entities
   * 
   * @return list containing all entities
   */
  List<T> findAll();

  /**
   * Total number of entities
   * 
   * @return number of entities
   */
  Long countAll();

  /**
   * Return entities fulfilling given criteria
   * 
   * @param criteria to match
   * @return list of entities matching criteria
   */
  List<T> findByCriteria(AbstractSearchCriteria<T, K> criteria);

  /**
   * Return result object containing entities fulfilling given criteria
   * 
   * @see {SearchResult}
   * @param criteria to match
   * @return result objetct with entities matching criteria
   */
  SearchResult<T> searchByCriteria(AbstractSearchCriteria<T, K> criteria);

  /**
   * Return count of entities matching given criteria
   * 
   * @param criteria to match
   * @return number of entities
   */
  Long countByCriteria(AbstractSearchCriteria<T, K> criteria);
}
