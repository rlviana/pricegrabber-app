package net.rlviana.pricegrabber.converter.service;

import net.rlviana.pricegrabber.converter.AbstractMapperConverter;
import net.rlviana.pricegrabber.domain.entity.EntityBase;
import net.rlviana.pricegrabber.model.entity.IEntity;

import org.dozer.Mapper;

/**
 * 
 * @author ramon
 * 
 * @param <T> Source Class
 * @param <V> Destination Class
 */
@SuppressWarnings("rawtypes")
public class BaseConverter<T extends IEntity, V extends EntityBase> extends AbstractMapperConverter<T, V> {

  /**
   * Constructor
   * 
   * @param mapper
   * @param tClazz
   * @param vClazz
   */
  protected BaseConverter(final Mapper mapper, final Class<T> tClazz, final Class<V> vClazz) {
    super(mapper, tClazz, vClazz);
  }

}
