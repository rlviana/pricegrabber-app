package net.rlviana.pricegrabber.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * Abstract list converter.
 * 
 * @author ramon
 * 
 * @param <T> source element class in collection
 * @param <V> result element class in collection
 */
public abstract class AbstractListConverter<T, V> implements ListConverter<T, V> {

  @Override
  public List<V> convertListTo(Collection<T> sourceList) {
    List<V> results = new ArrayList<V>();

    for (T item : sourceList) {
      results.add(convertTo(item));
    }

    return results;
  }

  @Override
  public List<T> convertListFrom(Collection<V> sourceList) {
    List<T> results = new ArrayList<T>();

    for (V item : sourceList) {
      results.add(convertFrom(item));
    }

    return results;
  }

}
