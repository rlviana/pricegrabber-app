package net.rlviana.pricegrabber.model.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * MappedSuperclass for entities. Abstract optimistic lock enabled entity.
 * 
 * @param <T> Entity key class
 * @author ramon
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractVersionedEntity<T extends Serializable> implements IEntity<T>, Serializable {

  @Version
  private int lockVersion;

  /**
   * Gets lock version, used for optimistic locking.
   */
  public int getLockVersion() {
    return lockVersion;
  }

  /**
   * Sets lock version, used for optimistic locking. <br/>
   * <strong>Note</strong>: Shouldn't be set except by JPA, setter needed for
   * matching getter/setter for conversion
   * between entities and JAXB beans.
   * 
   * @param lockVersion the entity revision number
   */
  public void setLockVersion(final int lockVersion) {
    this.lockVersion = lockVersion;
  }

  /**
   * @return
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + lockVersion;
    return result;
  }

  /**
   * @param obj
   * @return
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings("rawtypes")
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
    AbstractVersionedEntity other = (AbstractVersionedEntity) obj;
    if (lockVersion != other.lockVersion) {
      return false;
    }
    return true;
  }
}
