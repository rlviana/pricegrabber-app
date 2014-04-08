package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.common.Currency;

/**
 * @author ramon
 * 
 */
public class CurrencyConverterTest
    extends
    AbstractConverterTest<Currency, net.rlviana.pricegrabber.domain.entity.common.Currency> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.common.Currency getDomainObject() {
    return getTestDomainCurrency();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected Currency getModelObject() {
    return getTestModelCurrency();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.common.Currency> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.common.Currency.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Currency> getModelObjectClass() {
    return Currency.class;
  }

}
