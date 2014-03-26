/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.entity.common;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.rlviana.pricegrabber.model.entity.IEntity;

/**
 * Persistence class for currency. Uses ISO 4217
 * 
 * @author ramon
 */
@Entity
@Cacheable(true)
@Table(name = "CO_CURRENCY", uniqueConstraints = @UniqueConstraint(columnNames = "COD"))
public class Currency implements IEntity<String> {

  /** serialVersionUID */
  private static final long serialVersionUID = -7478979310379296029L;

  @Id
  @Column(name = "ID", length = CODE_2_LENGHT)
  /** Three letters code*/
  private String id;

  @Column(name = "COD", nullable = false, length = CODE_3_LENGHT, insertable = false, updatable = false)
  /** Three numbers code */
  private Integer cod;

  @Column(name = "NAME", nullable = true, length = NAME_LENGHT, insertable = false, updatable = false)
  /** Currency name */
  private String name;

  /**
   * Constructor
   */
  public Currency() {
    super();
  }

  /**
   * @return the id
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  @Override
  public void setId(final String id) {
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
  public Integer getCod() {
    return cod;
  }

  /**
   * @param cod the description to set
   */
  public void setCod(final Integer cod) {
    this.cod = cod;
  }

  /**
   * @return
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cod == null) ? 0 : cod.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Currency other = (Currency) obj;
    if (cod == null) {
      if (other.cod != null) {
        return false;
      }
    } else if (!cod.equals(other.cod)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
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
    builder.append("Currency [id=");
    builder.append(id);
    builder.append(", cod=");
    builder.append(cod);
    builder.append(", name=");
    builder.append(name);
    builder.append("]");
    return builder.toString();
  }

}
