package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.common.Country;

import org.dozer.Mapper;

/**
 * @author ramon
 * 
 */
public class CountryConverter extends BaseConverter<Country, net.rlviana.pricegrabber.domain.entity.common.Country> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected CountryConverter(final Mapper mapper) {
    super(mapper, Country.class, net.rlviana.pricegrabber.domain.entity.common.Country.class);
  }

}
