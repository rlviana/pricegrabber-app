package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.core.ItemType;

/**
 * @author ramon
 * 
 */
public class ItemTypeConverterTest
    extends
    AbstractConverterTest<ItemType, net.rlviana.pricegrabber.domain.entity.core.ItemType> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.ItemType getDomainObject() {
    return getTestDomainItemType();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected ItemType getModelObject() {
    return getTestModelItemType();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.ItemType> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.ItemType.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<ItemType> getModelObjectClass() {
    return ItemType.class;
  }

}
