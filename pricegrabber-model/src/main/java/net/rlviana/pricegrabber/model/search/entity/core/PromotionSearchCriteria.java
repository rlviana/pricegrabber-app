package net.rlviana.pricegrabber.model.search.entity.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import net.rlviana.pricegrabber.model.entity.core.Promotion;
import net.rlviana.pricegrabber.model.entity.core.Promotion_;
import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.entity.core.Site_;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

/**
 * Search criteria for Promotion entites
 * 
 * @author ramon
 */
public class PromotionSearchCriteria extends AbstractSearchCriteria<Promotion, Long> {

  private String name = null;
  private String nameLike = null;
  private Site site = null;
  private String siteName = null;
  private Boolean activePromotions;
  private Boolean activeOrNull;
  private Calendar promotionDate;
  private Calendar promotionEndDate;
  private Calendar promotionBeginDate;

  @Override
  public Class<Promotion> getEntityClass() {
    return Promotion.class;
  }

  @Override
  protected List<Predicate> getHaving(final CriteriaBuilder builder, final Root<Promotion> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Expression<Promotion>> getGrouping(final CriteriaBuilder builder, final Root<Promotion> root) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected List<Predicate> getRestrictions(final CriteriaBuilder builder, final Root<Promotion> root) {
    final List<Predicate> predicates = new ArrayList<Predicate>();
    if (null != name) {
      predicates.add(builder.equal(root.get(Promotion_.name), name));
    }
    if (null != nameLike) {
      predicates.add(builder.like(root.get(Promotion_.name), nameLike));
    }
    if (null != promotionBeginDate) {
      predicates.add(builder.lessThanOrEqualTo(root.get(Promotion_.beginDate), promotionBeginDate));
    }
    if (null != promotionEndDate) {
      predicates.add(builder.lessThanOrEqualTo(root.get(Promotion_.endDate), promotionEndDate));
    }
    if (activePromotions != null) {
      predicates.add(builder.equal(root.get(Promotion_.active), activePromotions));
    }
    if (activeOrNull != null) {
      predicates.add(builder.or(builder.equal(root.get(Promotion_.active), activeOrNull),
          builder.isNull(root.get(Promotion_.active))));
    }
    if (promotionDate != null) {
      predicates.add(builder.and(
          builder.or(builder.greaterThanOrEqualTo(root.get(Promotion_.beginDate), promotionDate),
              builder.isNull(root.get(Promotion_.beginDate))),
          builder.or(builder.or(builder.lessThanOrEqualTo(root.get(Promotion_.endDate), promotionDate)),
              builder.isNull(root.get(Promotion_.endDate)))));
    }
    if (site != null && site.getId() != null) {
      Join<Promotion, Site> join = root.join(Promotion_.site);
      predicates.add(builder.equal(join.get(Site_.id), site.getId()));
    }
    if (siteName != null) {
      Join<Promotion, Site> join = root.join(Promotion_.site);
      predicates.add(builder.equal(join.get(Site_.name), siteName));
    }
    return predicates;
  }

  @Override
  protected List<Order> getOrdering(final CriteriaBuilder builder, final Root<Promotion> root) {
    List<Order> orderBy = new ArrayList<Order>();
    orderBy.add(builder.desc(root.get(Promotion_.id)));
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
   * @return the promotionDate
   */
  public Calendar getPromotionDate() {
    return promotionDate;
  }

  /**
   * @param promotionDate the promotionDate to set
   */
  public void setPromotionDate(final Calendar promotionDate) {
    this.promotionDate = promotionDate;
  }

  /**
   * @return the activePromotions
   */
  public Boolean getActivePromotions() {
    return activePromotions;
  }

  /**
   * @param activePromotions the activePromotions to set
   */
  public void setActivePromotions(final Boolean activePromotions) {
    this.activePromotions = activePromotions;
  }

  /**
   * @return the site
   */
  public Site getSite() {
    return site;
  }

  /**
   * @param site the site to set
   */
  public void setSite(final Site site) {
    this.site = site;
  }

  /**
   * @return the site
   */
  public String getSiteName() {
    return siteName;
  }

  /**
   * @param siteName the name to set
   */
  public void setSiteName(final String siteName) {
    this.siteName = siteName;
  }

  /**
   * @return the promotionEndDate
   */
  public Calendar getPromotionEndDate() {
    return promotionEndDate;
  }

  /**
   * @param promotionEndDate the promotionEndDate to set
   */
  public void setPromotionEndDate(final Calendar promotionEndDate) {
    this.promotionEndDate = promotionEndDate;
  }

  /**
   * @return the promotionBeginDate
   */
  public Calendar getPromotionBeginDate() {
    return promotionBeginDate;
  }

  /**
   * @param promotionBeginDate the promotionBeginDate to set
   */
  public void setPromotionBeginDate(final Calendar promotionBeginDate) {
    this.promotionBeginDate = promotionBeginDate;
  }

  /**
   * @return the activeOrNull
   */
  public Boolean getActiveOrNull() {
    return activeOrNull;
  }

  /**
   * @param activeOrNull the activeOrNull to set
   */
  public void setActiveOrNull(final Boolean activeOrNull) {
    this.activeOrNull = activeOrNull;
  }

}
