package net.rlviana.pricegrabber.converter;

import org.dozer.Mapper;

/**
 * Abstract mapper converter based on Dozer.
 * 
 * @author ramon
 */
public abstract class AbstractMapperConverter<T, V> extends AbstractListConverter<T, V> {

  private final Mapper mapper;
  private final Class<T> tClazz;
  private final Class<V> vClazz;

  public AbstractMapperConverter(Mapper mapper,
      Class<T> tClazz2, Class<V> vClazz2) {
    this.mapper = mapper;
    this.tClazz = tClazz2;
    this.vClazz = vClazz2;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.Converter#convertTo(java.lang.Object)
   */
  @Override
  public V convertTo(T source) {
    return mapper.map(source, vClazz);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.Converter#convertFrom(java.lang.Object)
   */
  @Override
  public T convertFrom(V source) {
    return mapper.map(source, tClazz);
  }

}
