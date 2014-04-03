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

import net.rlviana.pricegrabber.model.entity.core.Item;
import net.rlviana.pricegrabber.model.entity.core.ItemType;
import net.rlviana.pricegrabber.model.entity.core.ItemType_;
import net.rlviana.pricegrabber.model.entity.core.Item_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for Item entites
 * 
 * @author ramon
 */
public class ItemSearchCriteria extends AbstractSearchCriteria<Item, Long> {

  private Long id;
  private String name;
  private String nameLike;
  private ItemType itemType;
  private Integer itemTypeId;

  @Override
  public Class<Item> getEntityClass() {
    return Item.class;
  }

  @Override
  protected List<Expression<Item>> getGrouping(final CriteriaBuilder builder, final Root<Item> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<Item> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<Item> root) {
    final List<Predicate> predicates = new ArrayList<Predicate>();
    if (id != null) {
      predicates.add(builder.equal(root.get(Item_.id), id));
    }
    if (name != null) {
      predicates.add(builder.equal(root.get(Item_.name), name));
    }
    if (nameLike != null) {
      predicates.add(builder.like(root.get(Item_.name), nameLike));
    }

    if (itemType != null && itemType.getId() != null) {
      Join<Item, ItemType> join = root.join(Item_.itemType);
      predicates.add(builder.equal(join.get(ItemType_.id), itemType.getId()));
    }

    if (itemTypeId != null) {
      Join<Item, ItemType> join = root.join(Item_.itemType);
      predicates.add(builder.equal(join.get(ItemType_.id), itemTypeId));
    }
    return predicates;
  }

  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<Item> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(Item_.id)));
    return orderBy;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
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
   * @return the itemType
   */
  public ItemType getItemType() {
    return itemType;
  }

  /**
   * @param itemType the itemType to set
   */
  public void setItemType(final ItemType itemType) {
    this.itemType = itemType;
  }

  /**
   * @return the itemTypeId
   */
  public Integer getItemTypeId() {
    return itemTypeId;
  }

  /**
   * @param itemTypeId the itemTypeId to set
   */
  public void setItemTypeId(final Integer itemTypeId) {
    this.itemTypeId = itemTypeId;
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

}
