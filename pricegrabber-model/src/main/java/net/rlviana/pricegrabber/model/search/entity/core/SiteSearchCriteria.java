/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.search.entity.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.entity.core.Site_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for Site entites
 * 
 * @author ramon
 */
public class SiteSearchCriteria extends AbstractSearchCriteria<Site, Long> {

  private String name = null;
  private String nameLike = null;
  private String country;
  private Boolean promotionsActive;
  private Date promotionDate;

  @Override
  public Class<Site> getEntityClass() {
    return Site.class;
  }

  @Override
  protected List<Expression<Site>> getGrouping(final CriteriaBuilder builder, final Root<Site> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<Site> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<Site> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<Site> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(Site_.id)));
    return orderBy;
  }

  /**
   * @return the name
   */
  public final String getName() {
    return name;
  }

  /**
   * @return the nameLike
   */
  public final String getNameLike() {
    return nameLike;
  }

  /**
   * @param name the name to set
   */
  public final void setName(final String name) {
    this.name = name;
  }

  /**
   * @param nameLike the nameLike to set
   */
  public final void setNameLike(final String nameLike) {
    this.nameLike = nameLike;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(final String country) {
    this.country = country;
  }

  /**
   * @return the promotionDate
   */
  public Date getPromotionDate() {
    return promotionDate;
  }

  /**
   * @param promotionDate the promotionDate to set
   */
  public void setPromotionDate(final Date promotionDate) {
    this.promotionDate = promotionDate;
  }

  /**
   * @return the promotionsActive value
   */
  public Boolean getActivePromotions() {
    return promotionsActive;
  }

  /**
   * @param promotionsActive the activePromotions to set
   */
  public void setPromotionsActive(final Boolean promotionsActive) {
    this.promotionsActive = promotionsActive;
  }

}
