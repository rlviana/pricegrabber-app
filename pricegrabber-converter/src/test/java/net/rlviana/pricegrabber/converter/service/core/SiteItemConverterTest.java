package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;

/**
 * @author ramon
 * 
 */
public class SiteItemConverterTest
    extends
    AbstractConverterTest<SiteItem, net.rlviana.pricegrabber.domain.entity.core.SiteItem> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.SiteItem getDomainObject() {
    return getTestDomainSiteItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected SiteItem getModelObject() {
    return getTestModelSiteItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.SiteItem> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.SiteItem.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<SiteItem> getModelObjectClass() {
    return SiteItem.class;
  }

}
