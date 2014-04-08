package net.rlviana.pricegrabber.converter;

import org.dozer.Mapper;

/**
 * Abstract mapper converter based on Dozer.
 * 
 * @author ramon
 * 
 * @param <T> Source class
 * @param <V> Destianation Class
 */
public abstract class AbstractMapperConverter<T, V> extends AbstractListConverter<T, V> {

  private final Mapper mapper;
  private final Class<T> tClazz;
  private final Class<V> vClazz;

  /**
   * 
   * Constructor
   * 
   * @param mapper
   * @param destinationClass
   * @param sourceClass
   */
  public AbstractMapperConverter(final Mapper mapper,
      final Class<T> sourceClass, final Class<V> destinationClass) {
    this.mapper = mapper;
    this.tClazz = sourceClass;
    this.vClazz = destinationClass;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.Converter#convertTo(java.lang.Object)
   */
  @Override
  public V convertTo(final T source) {
    return mapper.map(source, vClazz);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.Converter#convertFrom(java.lang.Object)
   */
  @Override
  public T convertFrom(final V source) {
    return mapper.map(source, tClazz);
  }

}
