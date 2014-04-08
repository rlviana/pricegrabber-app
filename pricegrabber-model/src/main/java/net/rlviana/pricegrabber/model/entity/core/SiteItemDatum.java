package net.rlviana.pricegrabber.model.entity.core;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.rlviana.pricegrabber.model.entity.AbstractVersionedEntity;
import net.rlviana.pricegrabber.model.entity.common.Currency;

/**
 * Entity to store data for a item in a site
 * 
 * @author ramon
 * 
 */
@Entity
@Table(name = "PG_SITEITEMDATUM")
public class SiteItemDatum extends AbstractVersionedEntity<Long> {

  /** serialVersionUID */
  private static final long serialVersionUID = 7030975924444719093L;

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "PG_SEQ_SITEITEMDATUM")
  @TableGenerator(name = "PG_SEQ_SITEITEMDATUM", table = "PG_SEQ", pkColumnName = "SEQ_PG_TABLE",
      pkColumnValue = "SEQ_PG_SITEITEMDATUM", valueColumnName = "SEQ_PG_VALUE", initialValue = 10, allocationSize = 1)
  private Long id;
  @Column(name = "PRICETYPE")
  @Enumerated(EnumType.ORDINAL)
  private PriceType priceType;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "PRICEDATE")
  private Calendar priceDate;
  @Column(name = "PRICEVALUE")
  private BigDecimal priceValue;
  @ManyToOne(optional = false)
  @JoinColumn(name = "CO_CURRENCY_ID", referencedColumnName = "ID", nullable = false)
  private Currency priceCurrency;
  @Column(name = "AVAILABILITY")
  private String availability;
  @ManyToOne(optional = false)
  @JoinColumn(name = "PG_SITEITEM_ID", referencedColumnName = "ID", nullable = false)
  private SiteItem siteItem;

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
   * @return the priceDate
   */
  public Calendar getPriceDate() {
    return priceDate;
  }

  /**
   * @param priceDate the priceDate to set
   */
  public void setPriceDate(final Calendar priceDate) {
    this.priceDate = priceDate;
  }

  /**
   * @return the priceValue
   */
  public BigDecimal getPriceValue() {
    return priceValue;
  }

  /**
   * @param priceValue the priceValue to set
   */
  public void setPriceValue(final BigDecimal priceValue) {
    this.priceValue = priceValue;
  }

  /**
   * @return the priceCurrency
   */
  public Currency getPriceCurrency() {
    return priceCurrency;
  }

  /**
   * @param priceCurrency the priceCurrency to set
   */
  public void setPriceCurrency(final Currency priceCurrency) {
    this.priceCurrency = priceCurrency;
  }

  /**
   * @return the priceType
   */
  public PriceType getPriceType() {
    return priceType;
  }

  /**
   * @param priceType the priceType to set
   */
  public void setPriceType(final PriceType priceType) {
    this.priceType = priceType;
  }

  /**
   * @return the item
   */
  public SiteItem getSiteItem() {
    return siteItem;
  }

  /**
   * @param siteItem the item to set
   */
  public void setSiteItem(final SiteItem siteItem) {
    this.siteItem = siteItem;
  }

  /**
   * @return the availability
   */
  public String getAvailability() {
    return availability;
  }

  /**
   * @param availability the availability to set
   */
  public void setAvailability(final String availability) {
    this.availability = availability;
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
    result = prime * result + (priceCurrency == null ? 0 : priceCurrency.hashCode());
    result = prime * result + (priceDate == null ? 0 : priceDate.hashCode());
    result = prime * result + (priceType == null ? 0 : priceType.hashCode());
    result = prime * result + (priceValue == null ? 0 : priceValue.hashCode());
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
    SiteItemDatum other = (SiteItemDatum) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (priceCurrency == null) {
      if (other.priceCurrency != null) {
        return false;
      }
    } else if (!priceCurrency.equals(other.priceCurrency)) {
      return false;
    }
    if (priceDate == null) {
      if (other.priceDate != null) {
        return false;
      }
    } else if (!priceDate.equals(other.priceDate)) {
      return false;
    }
    if (priceType != other.priceType) {
      return false;
    }
    if (priceValue == null) {
      if (other.priceValue != null) {
        return false;
      }
    } else if (!priceValue.equals(other.priceValue)) {
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
    builder.append("SiteItemDatum [id=")
        .append(id)
        .append(", priceType=")
        .append(priceType)
        .append(", priceDate=")
        .append(priceDate != null ? priceDate.getTime() : "null")
        .append(", priceValue=")
        .append(priceValue)
        .append(", priceCurrency=")
        .append(priceCurrency)
        .append(", availability=")
        .append(availability)
        .append(", siteItem=")
        .append(siteItem)
        .append("]");
    return builder.toString();
  }

}
