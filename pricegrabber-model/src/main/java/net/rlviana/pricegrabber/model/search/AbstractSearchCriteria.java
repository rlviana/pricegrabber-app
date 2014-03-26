/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.search;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.rlviana.pricegrabber.model.entity.IEntity;

/**
 * Abstract class to implement for entity search capabilities. It contains the
 * parameters of the query and it's responsible of creating the query for JPA based on canonical model
 * 
 * @author ramon
 * @param <T> IEntityClass
 * @param <K> Primary Key for IEntity class
 */
public abstract class AbstractSearchCriteria<T extends IEntity<K>, K extends Serializable>
    implements
    ISearchCriteria<T, K> {

  /** maxResults to return. */
  private int maxResults = 0;

  /** First result to return. */
  private int firstResult = 0;

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.ISearchCriteria#getMaxResults()
   */
  @Override
  public final int getMaxResults() {
    return maxResults;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.ISearchCriteria#setMaxResults(int)
   */
  @Override
  public final void setMaxResults(final int maxResults) {
    this.maxResults = maxResults;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.ISearchCriteria#getFirstResult()
   */
  @Override
  public final int getFirstResult() {
    return firstResult;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.ISearchCriteria#setFirstResult(int)
   */
  @Override
  public final void setFirstResult(final int firstResult) {
    this.firstResult = firstResult;
  }

  /**
   * Builds a query using the stated parameters
   * 
   * @param entityManager to use
   * @return the created query
   */
  public CriteriaQuery<T> buildQuery(final EntityManager entityManager) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<T> query = builder.createQuery(getEntityClass());
    Root<T> root = null;
    List<Predicate> restrictions = null;
    List<Order> ordering = null;
    List<Expression<T>> grouping = null;
    List<Predicate> having = null;
    root = query.from(getEntityClass());
    query.select(root);
    restrictions = getRestrictions(builder, root);
    ordering = getOrdering(builder, root);
    grouping = getGrouping(builder, root);
    having = getHaving(builder, root);
    if (restrictions != null) {
      query.where(builder.and(restrictions.toArray(new Predicate[restrictions.size()])));
    }
    if (ordering != null) {
      query.orderBy(ordering);
    }
    if (grouping != null) {
      query.groupBy(grouping.toArray(new Expression[grouping.size()]));
    }
    if (having != null) {
      query.having(having.toArray(new Predicate[having.size()]));
    }
    return query;
  }

  /**
   * Builds a query using the stated parameters
   * 
   * @param entityManager to use
   * @return the created count query
   */
  public CriteriaQuery<Long> buildCountQuery(final EntityManager entityManager) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
    Root<T> root = null;
    List<Predicate> restrictions = null;
    List<Expression<T>> grouping = null;
    root = countQuery.from(getEntityClass());
    countQuery.select(builder.count(root));
    restrictions = getRestrictions(builder, root);
    grouping = getGrouping(builder, root);
    if (restrictions != null) {
      countQuery.where(builder.and(restrictions.toArray(new Predicate[restrictions.size()])));
    }
    if (grouping != null) {
      countQuery.groupBy(grouping.toArray(new Expression[grouping.size()]));
    }
    return countQuery;
  }

  /**
   * The entity class assigned
   * 
   * @return class assigned
   */
  protected abstract Class<T> getEntityClass();

  /**
   * @param builder
   * @return
   */
  protected abstract List<Expression<T>> getGrouping(CriteriaBuilder builder, Root<T> root);

  /**
   * @param builder
   * @param root
   * @return
   */
  protected abstract List<Predicate> getHaving(CriteriaBuilder builder, Root<T> root);

  /**
   * 
   * @param builder
   * @param root
   * @return
   */
  protected abstract List<Predicate> getRestrictions(CriteriaBuilder builder, Root<T> root);

  /**
   * 
   * @param builder
   * @param root
   * @return
   */
  protected abstract List<Order> getOrdering(CriteriaBuilder builder, Root<T> root);

}
