package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.common.Country;

/**
 * @author ramon
 * 
 */
public class CountryConverterTest extends AbstractConverterTest<Country, net.rlviana.pricegrabber.domain.entity.common.Country> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.common.Country getDomainObject() {
    return getTestDomainCountry();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected Country getModelObject() {
    return getTestModelCountry();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.common.Country> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.common.Country.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Country> getModelObjectClass() {
    return Country.class;
  }

}
