package net.rlviana.pricegrabber.model.repository;

import java.io.Serializable;
import net.rlviana.pricegrabber.model.entity.IEntity;

/**
 * Interface to implement when is required to persist the entity
 * 
 * @param <T> Entity class extending IEntity so the key is Long type
 * @param <K> Primary Key class for IEntity
 * @author ramon
 */
public interface ObjectRepository<T extends IEntity<K>, K extends Serializable> extends ReadOnlyObjectRepository<T, K> {

  /**
   * @param newInstance
   * @return the created instance
   */
  T create(T newInstance);

  /**
   * @param instance to update
   * @return modified instance
   */
  T update(T instance);

  /**
   * @param instanceKey of the instance to delete
   * @return <code>true</code> if deleted
   */
  boolean delete(Long instanceKey);

}
