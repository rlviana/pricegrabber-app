package net.rlviana.pricegrabber.converter;

/**
 * Converts to and from two different models.
 * Typically used between a domain &amp; business model.
 * 
 * @author ramon
 * 
 * @param <T> persistence model.
 * @param <V> Domain model
 */
public interface Converter<T, V> {

  /**
   * Converts from a persistence model to the domain model.
   * 
   * @param source
   * @return
   */
  V convertTo(T source);

  /**
   * Converts from a domain model to the persistence model.
   * 
   * @param source
   * @return
   */
  T convertFrom(V source);

}
