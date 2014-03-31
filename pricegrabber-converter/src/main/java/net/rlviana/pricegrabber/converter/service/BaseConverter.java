package net.rlviana.pricegrabber.converter.service;

import net.rlviana.pricegrabber.converter.AbstractMapperConverter;
import net.rlviana.pricegrabber.domain.entity.EntityBase;
import net.rlviana.pricegrabber.model.entity.IEntity;

import org.dozer.Mapper;

/**
 * @author ramon
 * 
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
  protected BaseConverter(Mapper mapper, Class<T> tClazz, Class<V> vClazz) {
    super(mapper, tClazz, vClazz);
  }

}
