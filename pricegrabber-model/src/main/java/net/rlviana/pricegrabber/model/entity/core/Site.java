/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import net.rlviana.pricegrabber.model.entity.AbstractAuditableEntity;
import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.entity.common.Language;

/**
 * Persistence class to maintain site information
 * 
 * @author ramon
 */
@Entity
@Table(name = "PG_SITE")
public class Site extends AbstractAuditableEntity<Long> {

  /** serialVersionUID */
  private static final long serialVersionUID = 2110983544938061569L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "PG_SEQ_SITE")
  @TableGenerator(name = "PG_SEQ_SITE", table = "PG_SEQ", pkColumnName = "SEQ_PG_TABLE",
      pkColumnValue = "SEQ_PG_SITE", valueColumnName = "SEQ_PG_VALUE", initialValue = 10, allocationSize = 1)
  private Long id;
  @Column(name = "NAME", nullable = false, length = NAME_LENGHT)
  private String name;
  @Column(name = "DESCRIPTION", nullable = false, length = DESCRIPTION_LENGHT)
  private String description;
  @Column(name = "URL", nullable = false, length = URL_LENGHT)
  private String url;
  @OneToMany(mappedBy = "site", orphanRemoval = true, fetch = FetchType.EAGER)
  private List<Promotion> promotions;
  @OneToMany(mappedBy = "site", orphanRemoval = true, fetch = FetchType.EAGER)
  private List<SiteItem> siteItems;
  @ManyToOne
  @JoinColumn(name = "CO_COUNTRY_ID", referencedColumnName = "ID", nullable = false)
  private Country country;
  @ManyToOne
  @JoinColumn(name = "CO_LANGUAGE_ID", referencedColumnName = "ID", nullable = false)
  private Language language;
  @ManyToOne
  @JoinColumn(name = "CO_CURRENCY_ID", referencedColumnName = "ID", nullable = false)
  private Currency currency;

  /**
   * Constructor
   */
  public Site() {
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
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(final String description) {
    this.description = description;
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
      setPromotions(new ArrayList<Promotion>());
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
   * @param promotion the promotions to set
   */
  public void addPromotion(final Promotion promotion) {
    getPromotions().add(promotion);
    if (promotion.getSite() == null) {
      promotion.setSite(this);
    }

  }

  /**
   * @return the siteItems
   */
  public List<SiteItem> getSiteItems() {
    if (siteItems == null) {
      setSiteItems(new ArrayList<SiteItem>());
    }
    return siteItems;
  }

  /**
   * @param siteItems the siteItems to set
   */
  public void setSiteItems(final List<SiteItem> siteItems) {
    this.siteItems = siteItems;
  }

  /**
   * @param siteItem the siteItem to add
   */
  public void addSiteItem(final SiteItem siteItem) {
    getSiteItems().add(siteItem);
    if (siteItem.getSite() == null) {
      siteItem.setSite(this);
    }
  }

  /**
   * @return the country
   */
  public final Country getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public final void setCountry(final Country country) {
    this.country = country;
  }

  /**
   * @return the language
   */
  public final Language getLanguage() {
    return language;
  }

  /**
   * @param language the language to set
   */
  public final void setLanguage(final Language language) {
    this.language = language;
  }

  /**
   * @return the currency
   */
  public final Currency getCurrency() {
    return currency;
  }

  /**
   * @param currency the currency to set
   */
  public final void setCurrency(final Currency currency) {
    this.currency = currency;
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
    result = prime * result + (url == null ? 0 : url.hashCode());
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
    Site other = (Site) obj;
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
    if (url == null) {
      if (other.url != null) {
        return false;
      }
    } else if (!url.equals(other.url)) {
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
    builder.append("Site [id=").append(id).append(", name=").append(name).append(", description=").append(description)
        .append(", url=").append(url).append(", country=").append(country).append(", language=").append(language)
        .append(", currency=").append(currency).append("]");
    return builder.toString();
  }

}
