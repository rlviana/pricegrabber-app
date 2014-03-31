package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.core.Promotion;

/**
 * @author ramon
 * 
 */
public class PromotionConverterTest
    extends
    ConverterTest<Promotion, net.rlviana.pricegrabber.domain.entity.core.Promotion> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.Promotion getDomainObject() {
    return getTestDomainPromotion();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected Promotion getModelObject() {
    return getTestModelPromotion();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.Promotion> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.Promotion.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Promotion> getModelObjectClass() {
    return Promotion.class;
  }

}
