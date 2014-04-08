package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.core.Item;

/**
 * @author ramon
 * 
 */
public class ItemConverterTest
    extends
    AbstractConverterTest<Item, net.rlviana.pricegrabber.domain.entity.core.Item> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.Item getDomainObject() {
    return getTestDomainItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected Item getModelObject() {
    return getTestModelItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.Item> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.Item.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Item> getModelObjectClass() {
    return Item.class;
  }

}
