package net.rlviana.pricegrabber.model.repository;

import java.io.Serializable;

import net.rlviana.pricegrabber.model.entity.IEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base JPA implementation for repositories requiring persist operations based
 * on JPA.
 * 
 * @author ramon
 * @param <T> Entity class
 * @param <K> Entity key class
 */
public abstract class AbstractJpaObjectRepository<T extends IEntity<K>, K extends Serializable> extends
    AbstractJpaReadOnlyObjectRepository<T, K> implements ObjectRepository<T, K> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJpaObjectRepository.class);

  /**
   * Constructor
   * 
   * @param instanceClass
   */
  public AbstractJpaObjectRepository(final Class<T> instanceClass) {
    super(instanceClass);
  }

  @Override
  public T create(T newInstance) { // CHECKSTYLE NON-FINAL
    LOGGER.trace("Persisting entity:{}", newInstance);
    getEntityManager().persist(newInstance);
    getEntityManager().flush();
    return newInstance;
  }

  @Override
  public T update(T instance) { // CHECKSTYLE NON-FINAL
    LOGGER.trace("Updatating entity:{}", instance);
    getEntityManager().merge(instance);
    getEntityManager().flush();
    return instance;
  }

  @Override
  public boolean delete(final Long instanceKey) {
    LOGGER.trace("Deleting entity:{},{}", getInstanceClass(), instanceKey);
    boolean result = true;
    getEntityManager().remove(getEntityManager().find(getInstanceClass(), instanceKey));
    return result;
  }

}
