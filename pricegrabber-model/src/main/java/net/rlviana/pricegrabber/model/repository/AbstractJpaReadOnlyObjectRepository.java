package net.rlviana.pricegrabber.model.repository;

import java.io.Serializable;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base JPA implementation for repositories requiring read operations based on JPA.<br/>
 * It's required to inject an EntityManager.
 * 
 * @author ramon
 * @param <T> Entity class
 * @param <K> Entity key class
 */
public abstract class AbstractJpaReadOnlyObjectRepository<T extends IEntity<K>, K extends Serializable> extends
    AbstractBaseJpaReadOnlyObjectRepository<T, K> {

  /**
   * Constructor
   * 
   * @param instanceClass
   */
  public AbstractJpaReadOnlyObjectRepository(final Class<T> instanceClass) {
    super(instanceClass);
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJpaReadOnlyObjectRepository.class);

  /**
   * Creates a JPA criteria query for the given searchCriteria.<br/>
   * Delegates the building on the search criteria object<br/>
   * If the given criteria is empty it will return a <code>SELECT * FROM <T></code> <br/>
   * If the given criteria is null will throw an {@see java.lang.IllegalArgumentException}
   * 
   * @param criteria to apply
   * @return the builded criteria
   */
  private CriteriaQuery<T> getQuery(final AbstractSearchCriteria<T, K> criteria) {
    CriteriaQuery<T> query = null;
    if (criteria == null) {
      throw new IllegalArgumentException("Criteria = null");
    } else {
      query = criteria.buildQuery(getEntityManager());
    }
    return query;
  }

  /**
   * Creates a JPA count criteria query for the given searchCriteria.<br/>
   * Delegates the building on the search criteria object<br/>
   * If the given criteria is empty it will return a <code>SELECT * FROM <T></code><br/>
   * If the given criteria is null will throw an {@see java.lang.IllegalArgumentException}
   * 
   * @param criteria to apply
   * @return the builded criteria
   */
  private CriteriaQuery<Long> getCountQuery(final AbstractSearchCriteria<T, K> criteria) {
    CriteriaQuery<Long> query = null;
    if (criteria == null) {
      throw new IllegalArgumentException("Criteria = null");
    } else {
      query = criteria.buildCountQuery(getEntityManager());
    }

    return query;
  }

  /**
   * Creates a JPA Query for the given searchCriteria
   * 
   * @param criteria for searching
   * @return created query
   */
  @Override
  protected Query getCriteriaQuery(final AbstractSearchCriteria<T, K> criteria) {
    LOGGER.debug("Obtaining query for criteria: {}", criteria);
    Query query = getEntityManager().createQuery(getQuery(criteria));
    query.setFirstResult(criteria == null ? 0 : criteria.getFirstResult());
    query.setMaxResults(criteria == null ? 0 : criteria.getMaxResults());
    LOGGER.debug("Query: {}", query);
    return query;
  }

  /**
   * Creates a count query for the given searchCriteria
   * 
   * @param criteria for searching
   * @return query created
   */
  @Override
  protected Query getCountCriteriaQuery(final AbstractSearchCriteria<T, K> criteria) {
    LOGGER.debug("Obtaining Count query for criteria: {}", criteria);
    Query query = getEntityManager().createQuery(getCountQuery(criteria));
    LOGGER.debug("Count query: {}", query);
    return query;
  }

}
