package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.core.Site;

/**
 * @author ramon
 * 
 */
public class SiteConverterTest
    extends
    AbstractConverterTest<Site, net.rlviana.pricegrabber.domain.entity.core.Site> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.Site getDomainObject() {
    return getTestDomainSite();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected Site getModelObject() {
    return getTestModelSite();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.Site> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.Site.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Site> getModelObjectClass() {
    return Site.class;
  }

}
