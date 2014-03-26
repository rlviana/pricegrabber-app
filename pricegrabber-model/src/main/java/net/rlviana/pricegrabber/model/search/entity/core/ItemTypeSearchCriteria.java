/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.search.entity.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.rlviana.pricegrabber.model.entity.core.ItemType;
import net.rlviana.pricegrabber.model.entity.core.ItemType_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for ItemType entites
 * 
 * @author ramon
 */
public class ItemTypeSearchCriteria extends AbstractSearchCriteria<ItemType, Integer> {

  private Integer id;
  private String name;
  private String nameLike;
  private Integer parentId;
  private Integer childId;

  @Override
  public Class<ItemType> getEntityClass() {
    return ItemType.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getGrouping(javax.persistence.criteria.CriteriaBuilder,
   *      javax.persistence.criteria.Root)
   */
  @Override
  protected List<Expression<ItemType>> getGrouping(final CriteriaBuilder builder, final Root<ItemType> root) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getHaving(javax.persistence.criteria.CriteriaBuilder,
   *      javax.persistence.criteria.Root)
   */
  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<ItemType> root) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getRestrictions(javax.persistence.criteria.CriteriaBuilder,
   *      javax.persistence.criteria.Root)
   */
  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<ItemType> root) {
    final List<Predicate> predicates = new ArrayList<Predicate>();
    if (id != null) {
      predicates.add(builder.equal(root.get(ItemType_.id), id));
    }
    if (name != null) {
      predicates.add(builder.equal(root.get(ItemType_.name), name));
    }
    if (nameLike != null) {
      predicates.add(builder.like(root.get(ItemType_.name), nameLike));
    }

    if (parentId != null) {
      Join<ItemType, ItemType> join = root.join(ItemType_.parent);
      predicates.add(builder.equal(join.get(ItemType_.id), parentId));
    }
    if (childId != null) {
      Join<ItemType, ItemType> join = root.join(ItemType_.children);
      predicates.add(builder.equal(join.get(ItemType_.id), childId));
    }
    return predicates;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getOrdering(javax.persistence.criteria.CriteriaBuilder)
   */
  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<ItemType> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(ItemType_.id)));
    return orderBy;
  }

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Integer id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * @return the nameLike
   */
  public String getNameLike() {
    return nameLike;
  }

  /**
   * @param nameLike the nameLike to set
   */
  public void setNameLike(final String nameLike) {
    this.nameLike = nameLike;
  }

  /**
   * @return the parentId
   */
  public Integer getParentId() {
    return parentId;
  }

  /**
   * @param parentId the parentId to set
   */
  public void setParentId(final Integer parentId) {
    this.parentId = parentId;
  }

  /**
   * @return the childenId
   */
  public Integer getChildId() {
    return childId;
  }

  /**
   * @param childId the childenId to set
   */
  public void setChildId(final Integer childId) {
    this.childId = childId;
  }

}
