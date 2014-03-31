package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.core.ItemType;

import org.dozer.Mapper;

/**
 * Converter for ItemType items
 * 
 * @author ramon
 * 
 */
public class ItemTypeConverter extends BaseConverter<ItemType, net.rlviana.pricegrabber.domain.entity.core.ItemType> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected ItemTypeConverter(final Mapper mapper) {
    super(mapper, ItemType.class, net.rlviana.pricegrabber.domain.entity.core.ItemType.class);
  }

}
