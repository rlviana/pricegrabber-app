package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.core.Site;

import org.dozer.Mapper;

/**
 * Converter for Site
 * 
 * @author ramon
 * 
 */
public class SiteConverter extends BaseConverter<Site, net.rlviana.pricegrabber.domain.entity.core.Site> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected SiteConverter(final Mapper mapper) {
    super(mapper, Site.class, net.rlviana.pricegrabber.domain.entity.core.Site.class);
  }

}
