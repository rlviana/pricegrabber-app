package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.core.Item;

import org.dozer.Mapper;

/**
 * @author ramon
 * 
 */
public class ItemConverter extends BaseConverter<Item, net.rlviana.pricegrabber.domain.entity.core.Item> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected ItemConverter(final Mapper mapper) {
    super(mapper, Item.class, net.rlviana.pricegrabber.domain.entity.core.Item.class);
  }

}
