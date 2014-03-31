package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;

/**
 * @author ramon
 * 
 */
public class SiteItemConverterTest
    extends
    ConverterTest<SiteItem, net.rlviana.pricegrabber.domain.entity.core.SiteItem> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.SiteItem getDomainObject() {
    return getTestDomainSiteItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected SiteItem getModelObject() {
    return getTestModelSiteItem();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.SiteItem> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.SiteItem.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<SiteItem> getModelObjectClass() {
    return SiteItem.class;
  }

}
