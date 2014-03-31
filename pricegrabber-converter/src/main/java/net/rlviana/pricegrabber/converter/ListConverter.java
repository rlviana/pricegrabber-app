package net.rlviana.pricegrabber.converter;

import java.util.Collection;
import java.util.List;

/**
 * Converts to and from lists with two different models.
 * 
 * @author ramon
 * 
 * @param <T> entity model bean.
 * @param <V> domain model.
 */
public interface ListConverter<T, V> extends Converter<T, V> {

  /**
   * Converts from a entity model list to a domain model list.
   * 
   * @param list to convert
   * @return converted list
   */
  public List<V> convertListTo(Collection<T> list);

  /**
   * Converts from a domain model list to a entity model list.
   * 
   * @param list to convert
   * @return converted list
   */
  public List<T> convertListFrom(Collection<V> list);

}
