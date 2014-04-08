package net.rlviana.pricegrabber.converter.custom;

import org.dozer.DozerConverter;

/**
 * Abstract class to implement for custom converters based on Dozer
 * 
 * @author ramon
 * 
 * @param <T> Source class
 * @param <V> Destination Class
 */
public abstract class AbstractConverter<T, V> extends DozerConverter<T, V> {

  /**
   * Constructor
   * 
   * @param sourceClass
   * @param destinationClass
   */
  public AbstractConverter(final Class<T> sourceClass, final Class<V> destinationClass) {
    super(sourceClass, destinationClass);
  }

}
