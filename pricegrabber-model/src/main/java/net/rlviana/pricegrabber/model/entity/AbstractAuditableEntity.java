package net.rlviana.pricegrabber.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MappedSupperclass for Entities requiring audit info. <br/>
 * Will include data regarding user and date of creation and modification.<br/>
 * Note: It's required to implement the mechanism to include the audit information <br/>
 * 
 * @param <T> Entity key class
 * @author ramon
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractAuditableEntity<T extends Serializable> extends AbstractVersionedEntity<T> {

  @Temporal(TemporalType.TIMESTAMP)
  private Calendar lastUpdated;
  private String lastUpdateUser;
  @Temporal(TemporalType.TIMESTAMP)
  private Calendar created;
  private String createUser;

  /**
   * @return the lastUpdated
   */
  public final Calendar getLastUpdated() {
    return lastUpdated;
  }

  /**
   * @param lastUpdated the lastUpdated to set
   */
  public final void setLastUpdated(final Calendar lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  /**
   * @return the lastUpdateUser
   */
  public final String getLastUpdateUser() {
    return lastUpdateUser;
  }

  /**
   * @param lastUpdateUser the lastUpdateUser to set
   */
  public final void setLastUpdateUser(final String lastUpdateUser) {
    this.lastUpdateUser = lastUpdateUser;
  }

  /**
   * @return the created
   */
  public final Calendar getCreated() {
    return created;
  }

  /**
   * @param created the created to set
   */
  public final void setCreated(final Calendar created) {
    this.created = created;
  }

  /**
   * @return the createUser
   */
  public final String getCreateUser() {
    return createUser;
  }

  /**
   * @param createUser the createUser to set
   */
  public final void setCreateUser(final String createUser) {
    this.createUser = createUser;
  }

  /**
   * @return
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("AbstractAuditableEntity [lastUpdated=");
    builder.append(lastUpdated);
    builder.append(", lastUpdateUser=");
    builder.append(lastUpdateUser);
    builder.append(", created=");
    builder.append(created);
    builder.append(", createUser=");
    builder.append(createUser);
    builder.append("]");
    return builder.toString();
  }

}
