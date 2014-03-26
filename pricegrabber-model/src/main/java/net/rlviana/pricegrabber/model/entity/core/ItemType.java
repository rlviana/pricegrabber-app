/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import net.rlviana.pricegrabber.model.entity.AbstractVersionedEntity;

/**
 * @author ramon
 */
@Entity
@Table(name = "PG_ITEMTYPE")
public class ItemType extends AbstractVersionedEntity<Integer> {

  /** serialVersionUID */
  private static final long serialVersionUID = -7478979310379296029L;
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "ITEMTYPE_SEQ_GEN")
  @SequenceGenerator(name = "ITEMTYPE_SEQ_GEN", sequenceName = "PG_ITEMTYPE_SEQ", initialValue = 10, allocationSize = 1)
  private Integer id;
  @Column(name = "NAME", nullable = false, length = SHORTNAME_LENGHT)
  private String name;
  @Column(name = "DESCRIPTION", length = SHORTDESCRIPTION_LENGHT)
  private String description;
  @ManyToOne
  @JoinColumn(name = "PG_ITEMTYPE_ID", referencedColumnName = "ID")
  private ItemType parent;
  @OneToMany(mappedBy = "parent", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<ItemType> children;

  /**
   * Constructor
   */
  public ItemType() {
    super();
  }

  /**
   * @return the id
   */
  @Override
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  @Override
  public void setId(final Integer id) {
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
  public final String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public final void setDescription(final String description) {
    this.description = description;
  }

  /**
   * @return the parent
   */
  public final ItemType getParent() {
    return parent;
  }

  /**
   * @param parent the parent to set
   */
  public final void setParent(final ItemType parent) {
    this.parent = parent;
    parent.addChildren(this);
  }

  /**
   * @return the children
   */
  public final List<ItemType> getChildren() {
    if (children == null) {
      setChildren(new ArrayList<ItemType>());
    }
    return children;
  }

  /**
   * @param children the children to set
   */
  public final void setChildren(final List<ItemType> children) {
    this.children = children;
  }

  /**
   * @param child the child to add
   */
  public final void addChildren(final ItemType child) {
    getChildren().add(child);
    if (child.getParent() == null) {
      child.setParent(this);
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
    result = prime * result + (id == null ? 0 : id.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
    result = prime * result + (parent == null ? 0 : parent.hashCode());
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
    ItemType other = (ItemType) obj;
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
    if (parent == null) {
      if (other.parent != null) {
        return false;
      }
    } else if (!parent.equals(other.parent)) {
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
    builder.append("ItemType [id=").append(id).append(", name=").append(name).append(", parent=").append(parent)
        .append("]");
    return builder.toString();
  }

}
