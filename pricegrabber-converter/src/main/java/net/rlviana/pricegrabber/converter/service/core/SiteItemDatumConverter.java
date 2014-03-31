package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;

import org.dozer.Mapper;

/**
 * Converter for SiteItemDatum
 * 
 * @author ramon
 * 
 */
public class SiteItemDatumConverter
    extends
    BaseConverter<SiteItemDatum, net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected SiteItemDatumConverter(final Mapper mapper) {
    super(mapper, SiteItemDatum.class, net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum.class);
  }

}
