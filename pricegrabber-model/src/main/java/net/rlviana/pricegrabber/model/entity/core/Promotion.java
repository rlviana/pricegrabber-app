package net.rlviana.pricegrabber.model.entity.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.rlviana.pricegrabber.model.entity.AbstractVersionedEntity;

/**
 * Entity for Promotions
 * 
 * @author ramon
 */
@Entity
@Table(name = "PG_PROMOTION")
public class Promotion extends AbstractVersionedEntity<Long> {

  /** serialVersionUID */
  private static final long serialVersionUID = -1186090635828304635L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "PG_SEQ_PROMOTION")
  @TableGenerator(name = "PG_SEQ_PROMOTION", table = "PG_SEQ", pkColumnName = "SEQ_PG_TABLE",
      pkColumnValue = "SEQ_PG_PROMOTION", valueColumnName = "SEQ_PG_VALUE", initialValue = 10, allocationSize = 1)
  private Long id;
  @Column(name = "NAME", nullable = false, length = LONGNAME_LENGHT)
  private String name;
  @Column(name = "DESCRIPTION", nullable = false, length = DESCRIPTION_LENGHT)
  private String description;
  @Column(name = "URL", nullable = false, length = URL_LENGHT)
  private String url;

  @ManyToOne(optional = false)
  @JoinColumn(name = "PG_SITE_ID", referencedColumnName = "ID", nullable = false)
  private Site site;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "BEGINDATE")
  private Calendar beginDate;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "ENDDATE")
  private Calendar endDate;
  @Column(name = "ACTIVE")
  private Boolean active;

  @ManyToMany
  @JoinTable(name = "PG_PROMOTION_SITEITEM", joinColumns = { @JoinColumn(name = "PG_PROMOTION_ID") },
      inverseJoinColumns = { @JoinColumn(name = "PG_SITEITEM_ID") })
  private List<SiteItem> siteItems;

  /**
   * Constructor
   */
  public Promotion() {
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
   * @return the beginDate
   */
  public Calendar getBeginDate() {
    return beginDate;
  }

  /**
   * @param beginDate the beginDate to set
   */
  public void setBeginDate(final Calendar beginDate) {
    this.beginDate = beginDate;
  }

  /**
   * @return the endDate
   */
  public Calendar getEndDate() {
    return endDate;
  }

  /**
   * @param endDate the endDate to set
   */
  public void setEndDate(final Calendar endDate) {
    this.endDate = endDate;
  }

  /**
   * @return the active
   */
  public Boolean isActive() {
    return active;
  }

  /**
   * @param active the active to set
   */
  public void setActive(final Boolean active) {
    this.active = active;
  }

  /**
   * @return the item
   */
  public List<SiteItem> getSiteItems() {
    if (siteItems == null) {
      setSiteItems(new ArrayList<SiteItem>());
    }
    return siteItems;
  }

  /**
   * @param siteItems the items to set
   */
  public void setSiteItems(final List<SiteItem> siteItems) {
    this.siteItems = siteItems;
  }

  /**
   * @param siteItem the item to add
   */
  public void addSiteItem(final SiteItem siteItem) {
    getSiteItems().add(siteItem);
  }

  /**
   * @param siteItem the item to remove
   */
  public void removeSiteItem(final SiteItem siteItem) {
    SiteItem item = null;
    if (getSiteItems().indexOf(siteItem) >= 0) {
      item = getSiteItems().remove(getSiteItems().indexOf(siteItem));
      item.getPromotions().remove(this);
    }
  }

  /**
   * @return
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (beginDate == null ? 0 : beginDate.hashCode());
    result = prime * result + (endDate == null ? 0 : endDate.hashCode());
    result = prime * result + (id == null ? 0 : id.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
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
    Promotion other = (Promotion) obj;
    if (beginDate == null) {
      if (other.beginDate != null) {
        return false;
      }
    } else if (!beginDate.equals(other.beginDate)) {
      return false;
    }
    if (endDate == null) {
      if (other.endDate != null) {
        return false;
      }
    } else if (!endDate.equals(other.endDate)) {
      return false;
    }
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
    return true;
  }

  /**
   * @return
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Promotion [id=").append(id).append(", name=").append(name).append(", description=")
        .append(description).append(", url=").append(url).append(", site=").append(site).append(", beginDate=")
        .append(beginDate).append(", endDate=").append(endDate).append(", active=").append(active).append("]");
    return builder.toString();
  }

}
