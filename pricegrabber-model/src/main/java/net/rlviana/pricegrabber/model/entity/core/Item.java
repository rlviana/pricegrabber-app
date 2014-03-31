package net.rlviana.pricegrabber.model.entity.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import net.rlviana.pricegrabber.model.entity.AbstractVersionedEntity;

/**
 * @author ramon
 */
@Entity
@Table(name = "PG_ITEM")
public class Item extends AbstractVersionedEntity<Long> {

  /** serialVersionUID */
  private static final long serialVersionUID = -7478979310379296029L;
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "PG_SEQ_ITEM")
  @TableGenerator(name = "PG_SEQ_ITEM", table = "PG_SEQ", pkColumnName = "SEQ_PG_TABLE",
      pkColumnValue = "SEQ_PG_ITEM", valueColumnName = "SEQ_PG_VALUE", initialValue = 10, allocationSize = 1)
  private Long id;
  @Column(name = "NAME", nullable = false, length = LONGNAME_LENGHT)
  private String name;
  @Column(name = "DESCRIPTION", nullable = true, length = DESCRIPTION_LENGHT)
  private String description;
  @ManyToOne(optional = false)
  @JoinColumn(name = "PG_ITEMTYPE_ID", referencedColumnName = "ID", nullable = false)
  private ItemType itemType;

  /**
   * Empty Constructor
   */
  public Item() {
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

  @Override
  public String toString() {
    StringBuffer buff = new StringBuffer();
    buff.append("Item [id=").append(id).append(", name=").append(name).append(", description=").append(description).
        append(", ItemType=").append(itemType).append("]");
    return buff.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (itemType == null ? 0 : itemType.hashCode());
    result = prime * result + (id == null ? 0 : id.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
    return result;
  }

  /**
   * @param obj
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractVersionedEntity#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Item other = (Item) obj;
    if (itemType == null) {
      if (other.itemType != null) {
        return false;
      }
    } else if (!itemType.equals(other.itemType)) {
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

}
