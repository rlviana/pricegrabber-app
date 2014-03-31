package net.rlviana.pricegrabber.model.entity.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import net.rlviana.pricegrabber.model.entity.AbstractVersionedEntity;
import net.rlviana.pricegrabber.model.entity.common.Currency;

/**
 * Entity for items in a site
 * 
 * @author ramon
 * 
 */
@Entity
@Table(name = "PG_SITEITEM")
public class SiteItem extends AbstractVersionedEntity<Long> {

  /** serialVersionUID */
  private static final long serialVersionUID = 7030975924444719093L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "PG_SEQ_SITEITEM")
  @TableGenerator(name = "PG_SEQ_SITEITEM", table = "PG_SEQ", pkColumnName = "SEQ_PG_TABLE",
      pkColumnValue = "SEQ_PG_SITEITEM", valueColumnName = "SEQ_PG_VALUE", initialValue = 10, allocationSize = 1)
  private Long id;
  @Column(name = "NAME", nullable = false, length = NAME_LENGHT)
  private String name;
  @Column(name = "URL", nullable = false, length = URL_LENGHT)
  private String url;
  @Column(name = "SITECOD", nullable = false, length = CODE_20_LENGHT)
  private String siteCod;

  @ManyToMany(mappedBy = "siteItems", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Promotion> promotions;

  @ManyToOne(optional = false)
  @JoinColumn(name = "PG_SITE_ID", referencedColumnName = "ID", nullable = false)
  private Site site;

  @ManyToOne(optional = true)
  @JoinColumn(name = "PG_ITEM_ID", referencedColumnName = "ID", nullable = true)
  private Item item;

  @OneToMany(mappedBy = "siteItem", orphanRemoval = true, fetch = FetchType.LAZY)
  @OrderBy("priceDate DESC")
  private List<SiteItemDatum> siteItemData;

  /**
   * Constructor
   */
  public SiteItem() {
    super();
  }

  /**
   * @return the id
   */
  @Override
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  @Override
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
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(final String url) {
    this.url = url;
  }

  /**
   * @return the promotions
   */
  public List<Promotion> getPromotions() {
    if (promotions == null) {
      promotions = new ArrayList<Promotion>();
    }
    return promotions;
  }

  /**
   * @param promotions the promotions to set
   */
  public void setPromotions(final List<Promotion> promotions) {
    this.promotions = promotions;
  }

  /**
   * @param promotion the promotion to add
   */
  public void addPromotion(final Promotion promotion) {
    getPromotions().add(promotion);
    if (!promotion.getSiteItems().contains(this)) {
      promotion.addSiteItem(this);
    }
  }

  /**
   * @param promotion the promotion to remove
   */
  public void removePromotion(final Promotion promotion) {
    Promotion prom = null;
    if (getPromotions().indexOf(promotion) >= 0) {
      prom = getPromotions().remove(getPromotions().indexOf(promotion));
      prom.getSiteItems().remove(this);
    }
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
   * @return the siteItemSerials
   */
  public List<SiteItemDatum> getSiteItemData() {
    if (siteItemData == null) {
      setSiteItemData(new ArrayList<SiteItemDatum>());
    }
    return siteItemData;
  }

  /**
   * @param siteItemData the siteItemData to set
   */
  public void setSiteItemData(final List<SiteItemDatum> siteItemData) {
    this.siteItemData = siteItemData;
  }

  /**
   * @param siteItemDatum the siteItemDatum to add
   */
  public void addSiteItemDatum(final SiteItemDatum siteItemDatum) {
    getSiteItemData().add(siteItemDatum);
    if (siteItemDatum.getSiteItem() == null) {
      siteItemDatum.setSiteItem(this);
    }
  }

  /**
   * @return the siteId
   */
  public String getSiteCod() {
    return siteCod;
  }

  /**
   * @param siteCod the siteCod to set
   */
  public void setSiteCod(final String siteCod) {
    this.siteCod = siteCod;
  }

  /**
   * Returns value from first datum in serie
   * 
   * @return the pricePrice
   */
  @Transient
  public PriceType getCurrentPriceType() {
    if (getSiteItemData().size() > 0) {
      return getSiteItemData().get(0).getPriceType();
    }
    return null;
  }

  /**
   * Returns value from first datum in serie
   * 
   * @return the priceDate
   */
  @Transient
  public Calendar getCurrentPriceDate() {
    if (getSiteItemData().size() > 0) {
      return getSiteItemData().get(0).getPriceDate();
    }
    return null;

  }

  /**
   * Returns value from first datum in serie
   * 
   * @return the priceValue
   */
  @Transient
  public BigDecimal getCurrentPriceValue() {
    if (getSiteItemData().size() > 0) {
      return getSiteItemData().get(0).getPriceValue();
    }
    return null;

  }

  /**
   * Returns value from first datum in serie
   * 
   * @return the priceCurrency
   */
  public Currency getPriceCurrency() {
    if (getSiteItemData().size() > 0) {
      return getSiteItemData().get(0).getPriceCurrency();
    }
    return null;
  }

  /**
   * Returns value from first datum in serial
   * 
   * @return the availability
   */
  @Transient
  public String getAvailability() {
    if (getSiteItemData().size() > 0) {
      return getSiteItemData().get(0).getAvailability();
    }
    return null;
  }

  /**
   * @return
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (id == null ? 0 : id.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
    result = prime * result + (siteCod == null ? 0 : siteCod.hashCode());
    return result;
  }

  /**
   * @param obj
   * @return
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    SiteItem other = (SiteItem) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (siteCod == null) {
      if (other.siteCod != null) {
        return false;
      }
    } else if (!siteCod.equals(other.siteCod)) {
      return false;
    }
    return true;
  }

  /**
   * @return
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SiteItem [id=").append(id).append(", name=").append(name).append(", url=").append(url)
        .append(", siteCod=").append(siteCod).append("]");
    return builder.toString();
  }

}
