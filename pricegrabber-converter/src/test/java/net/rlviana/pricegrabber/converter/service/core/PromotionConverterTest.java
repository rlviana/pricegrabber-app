package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.core.Promotion;

/**
 * @author ramon
 * 
 */
public class PromotionConverterTest
    extends
    AbstractConverterTest<Promotion, net.rlviana.pricegrabber.domain.entity.core.Promotion> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.Promotion getDomainObject() {
    return getTestDomainPromotion();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected Promotion getModelObject() {
    return getTestModelPromotion();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.Promotion> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.Promotion.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Promotion> getModelObjectClass() {
    return Promotion.class;
  }

}
