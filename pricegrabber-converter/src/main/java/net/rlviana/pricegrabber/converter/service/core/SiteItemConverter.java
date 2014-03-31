package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;

import org.dozer.Mapper;

/**
 * Converter for SiteItem
 * 
 * @author ramon
 * 
 */
public class SiteItemConverter extends BaseConverter<SiteItem, net.rlviana.pricegrabber.domain.entity.core.SiteItem> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected SiteItemConverter(final Mapper mapper) {
    super(mapper, SiteItem.class, net.rlviana.pricegrabber.domain.entity.core.SiteItem.class);
  }

}
