package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.core.Item;

/**
 * @author ramon
 * 
 */
public class ItemConverterTest
    extends
    ConverterTest<Item, net.rlviana.pricegrabber.domain.entity.core.Item> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.Item getDomainObject() {
    return getTestDomainItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected Item getModelObject() {
    return getTestModelItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.Item> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.Item.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Item> getModelObjectClass() {
    return Item.class;
  }

}
