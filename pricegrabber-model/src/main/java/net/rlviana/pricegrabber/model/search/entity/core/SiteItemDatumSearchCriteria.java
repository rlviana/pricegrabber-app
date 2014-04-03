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

import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.entity.common.Currency_;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum_;
import net.rlviana.pricegrabber.model.entity.core.SiteItem_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for SiteItemSerial entites
 * 
 * @author ramon
 */
public class SiteItemDatumSearchCriteria extends AbstractSearchCriteria<SiteItemDatum, Long> {

  private Long id;
  private SiteItem siteItem;
  private Long siteItemId;
  private Currency currency;
  private String currencyId;

  @Override
  public Class<SiteItemDatum> getEntityClass() {
    return SiteItemDatum.class;
  }

  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<SiteItemDatum> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Expression<SiteItemDatum>> getGrouping(final CriteriaBuilder builder, final Root<SiteItemDatum> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<SiteItemDatum> root) {
    final List<Predicate> predicates = new ArrayList<Predicate>();
    if (id != null) {
      predicates.add(builder.equal(root.get(SiteItemDatum_.id), id));
    }

    if (siteItem != null && siteItem.getId() != null) {
      Join<SiteItemDatum, SiteItem> join = root.join(SiteItemDatum_.siteItem);
      predicates.add(builder.equal(join.get(SiteItem_.id), siteItem.getId()));
    }

    if (siteItemId != null) {
      Join<SiteItemDatum, SiteItem> join = root.join(SiteItemDatum_.siteItem);
      predicates.add(builder.equal(join.get(SiteItem_.id), siteItemId));
    }

    if (currency != null && currency.getId() != null) {
      Join<SiteItemDatum, Currency> join = root.join(SiteItemDatum_.priceCurrency);
      predicates.add(builder.equal(join.get(Currency_.id), currency.getId()));
    }

    if (currencyId != null) {
      Join<SiteItemDatum, Currency> join = root.join(SiteItemDatum_.priceCurrency);
      predicates.add(builder.equal(join.get(Currency_.id), currencyId));
    }

    return predicates;
  }

  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<SiteItemDatum> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(SiteItemDatum_.id)));
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
   * @return the siteItem
   */
  public SiteItem getSiteItem() {
    return siteItem;
  }

  /**
   * @param siteItem the siteItem to set
   */
  public void setSiteItem(final SiteItem siteItem) {
    this.siteItem = siteItem;
  }

  /**
   * @return the siteItemId
   */
  public Long getSiteItemId() {
    return siteItemId;
  }

  /**
   * @param siteItemId the siteItemId to set
   */
  public void setSiteItemId(final Long siteItemId) {
    this.siteItemId = siteItemId;
  }

  /**
   * @return the currency
   */
  public Currency getCurrency() {
    return currency;
  }

  /**
   * @param currency the currency to set
   */
  public void setCurrency(final Currency currency) {
    this.currency = currency;
  }

  /**
   * @return the currencyId
   */
  public String getCurrencyId() {
    return currencyId;
  }

  /**
   * @param currencyId the currencyId to set
   */
  public void setCurrencyId(final String currencyId) {
    this.currencyId = currencyId;
  }

}
