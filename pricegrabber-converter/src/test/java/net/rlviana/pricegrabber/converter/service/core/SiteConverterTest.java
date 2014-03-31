package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.core.Site;

/**
 * @author ramon
 * 
 */
public class SiteConverterTest
    extends
    ConverterTest<Site, net.rlviana.pricegrabber.domain.entity.core.Site> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.Site getDomainObject() {
    return getTestDomainSite();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected Site getModelObject() {
    return getTestModelSite();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.Site> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.Site.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Site> getModelObjectClass() {
    return Site.class;
  }

}
