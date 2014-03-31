package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.core.ItemType;

/**
 * @author ramon
 * 
 */
public class ItemTypeConverterTest
    extends
    ConverterTest<ItemType, net.rlviana.pricegrabber.domain.entity.core.ItemType> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.ItemType getDomainObject() {
    return getTestDomainItemType();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected ItemType getModelObject() {
    return getTestModelItemType();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.ItemType> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.ItemType.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<ItemType> getModelObjectClass() {
    return ItemType.class;
  }

}
