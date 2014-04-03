package net.rlviana.pricegrabber.model.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;
import net.rlviana.pricegrabber.model.search.SearchResult;

/**
 * Base abstract class implementation for JPA when working with repositories requiring read operations.
 * It's required to inject an EntityManager.
 * Implementing classes will have to provide the way to deal with the implementation selected. This can be done
 * through the criteria selected to implement it.
 * 
 * @author ramon
 * @param <T> Entity class
 * @param <K> Entity key class
 */
public abstract class AbstractBaseJpaReadOnlyObjectRepository<T extends IEntity<K>, K extends Serializable> implements
    ReadOnlyObjectRepository<T, K> {

  private EntityManager entityManager;

  private Class<T> instanceClass;

  /**
   * 
   * Constructor
   * 
   * @param instanceClass
   */
  public AbstractBaseJpaReadOnlyObjectRepository(final Class<T> instanceClass) {
    this.instanceClass = instanceClass;
  }

  /**
   * 
   * 
   * @see net.rlviana.pricegrabber.model.repository.ReadOnlyObjectRepository#findById(java.io.Serializable)
   */
  @Override
  public T findById(final K instanceId) {
    return getEntityManager().find(getInstanceClass(), instanceId);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<T> findByCriteria(final AbstractSearchCriteria<T, K> criteria) {
    return getCriteriaQuery(criteria).getResultList();
  }

  @Override
  public Long countAll() {
    return countByCriteria(getCriteriaAll());
  }

  @Override
  public Long countByCriteria(final AbstractSearchCriteria<T, K> criteria) {
    return (Long) getCountCriteriaQuery(criteria).getSingleResult();
  }

  @Override
  public SearchResult<T> searchByCriteria(final AbstractSearchCriteria<T, K> criteria) {
    SearchResult<T> result = new SearchResult<T>();
    result.setResults(findByCriteria(criteria));
    if (criteria != null) {
      result.setFirstResult(criteria.getFirstResult());
    }
    result.setTotal((Long) getCountCriteriaQuery(criteria).getSingleResult());
    return result;
  }

  /**
   * Uses an empty criteria
   * 
   * @see net.rlviana.pricegrabber.model.repository.ReadOnlyObjectRepository#findAll()
   */
  @Override
  public List<T> findAll() {
    return findByCriteria(getCriteriaAll());
  }

  /**
   * Method to implement in implementing classes.<br/>
   * The criteria may contain some condition, i.e. logic deletions
   * 
   * @return criteria for find all
   */
  protected abstract AbstractSearchCriteria<T, K> getCriteriaAll();

  /**
   * @return the em
   */
  public EntityManager getEntityManager() {
    return entityManager;
  }

  /**
   * @param entityManager the entityManager to set
   */
  @PersistenceContext
  public void setEntityManager(final EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  /**
   * @param instanceClass the instanceClass to set
   */
  public void setInstanceClass(final Class<T> instanceClass) {
    this.instanceClass = instanceClass;
  }

  /**
   * @return the instanceClass
   */
  public Class<T> getInstanceClass() {
    return instanceClass;
  }

  /**
   * Creates a query for the given searchCriteria.<br/>
   * Delegates the building on the search criteria object<br/>
   * If the given criteria is empty or null it will return a <code>SELECT * FROM <T></code> <br/>
   * 
   * @param criteria for searching
   * @return query created
   */
  protected abstract Query getCriteriaQuery(final AbstractSearchCriteria<T, K> criteria);

  /**
   * Creates a count query for the given searchCriteria.<br/>
   * Delegates the building on the search criteria object<br/>
   * If the given criteria is empty or null it will return a <code>SELECT * FROM <T></code> <br/>
   * 
   * @param criteria for searching
   * @return query created
   */
  protected abstract Query getCountCriteriaQuery(final AbstractSearchCriteria<T, K> criteria);

}
