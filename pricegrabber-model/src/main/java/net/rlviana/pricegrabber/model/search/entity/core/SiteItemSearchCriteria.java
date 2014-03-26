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
import net.rlviana.pricegrabber.model.entity.core.Item_;
import net.rlviana.pricegrabber.model.entity.core.Promotion;
import net.rlviana.pricegrabber.model.entity.core.Promotion_;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.entity.core.SiteItem_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for SiteItem entites
 * 
 * @author ramon
 */
public class SiteItemSearchCriteria extends AbstractSearchCriteria<SiteItem, Long> {

  private Long id;
  private String name;
  private String nameLike;
  private Item item;
  private Integer itemId;
  private Promotion promotion;
  private Integer promotionId;
  private ItemType itemType;
  private Integer itemTypeId;

  @Override
  public Class<SiteItem> getEntityClass() {
    return SiteItem.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getGrouping(javax.persistence.criteria.CriteriaBuilder,
   *      javax.persistence.criteria.Root)
   */
  @Override
  protected List<Expression<SiteItem>> getGrouping(final CriteriaBuilder builder, final Root<SiteItem> root) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getHaving(javax.persistence.criteria.CriteriaBuilder,
   *      javax.persistence.criteria.Root)
   */
  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<SiteItem> root) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getRestrictions(javax.persistence.criteria.CriteriaBuilder,
   *      javax.persistence.criteria.Root)
   */
  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<SiteItem> root) {
    final List<Predicate> predicates = new ArrayList<Predicate>();
    if (id != null) {
      predicates.add(builder.equal(root.get(SiteItem_.id), id));
    }
    if (name != null) {
      predicates.add(builder.equal(root.get(SiteItem_.name), name));
    }
    if (nameLike != null) {
      predicates.add(builder.like(root.get(SiteItem_.name), nameLike));
    }

    if (itemType != null && itemType.getId() != null) {
      throw new UnsupportedOperationException("Not implemented yet");
    }

    if (item != null && item.getId() != null) {
      Join<SiteItem, Item> join = root.join(SiteItem_.item);
      predicates.add(builder.equal(join.get(Item_.id), item.getId()));
    }

    if (promotion != null && promotion.getId() != null) {
      Join<SiteItem, Promotion> join = root.join(SiteItem_.promotions);
      predicates.add(builder.equal(join.get(Promotion_.id), promotion.getId()));
    }

    if (itemId != null) {
      Join<SiteItem, Item> join = root.join(SiteItem_.item);
      predicates.add(builder.equal(join.get(Item_.id), itemId));
    }

    if (promotionId != null) {
      Join<SiteItem, Promotion> join = root.join(SiteItem_.promotions);
      predicates.add(builder.equal(join.get(Promotion_.id), promotionId));
    }

    return predicates;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.search.AbstractSearchCriteria#getOrdering(javax.persistence.criteria.CriteriaBuilder)
   */
  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<SiteItem> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(SiteItem_.id)));
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
   * @return the item
   */
  public Item getItem() {
    return item;
  }

  /**
   * @param item the item to set
   */
  public void setItem(final Item item) {
    this.item = item;
  }

  /**
   * @return the itemId
   */
  public Integer getItemId() {
    return itemId;
  }

  /**
   * @param itemId the itemId to set
   */
  public void setItemId(final Integer itemId) {
    this.itemId = itemId;
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
   * @return the promotion
   */
  public Promotion getPromotion() {
    return promotion;
  }

  /**
   * @param promotion the promotion to set
   */
  public void setPromotion(final Promotion promotion) {
    this.promotion = promotion;
  }

  /**
   * @return the promotionId
   */
  public Integer getPromotionId() {
    return promotionId;
  }

  /**
   * @param promotionId the promotionId to set
   */
  public void setPromotionId(final Integer promotionId) {
    this.promotionId = promotionId;
  }

}
