package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;

/**
 * @author ramon
 * 
 */
public class SiteItemDatumConverterTest
    extends
    AbstractConverterTest<SiteItemDatum, net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum getDomainObject() {
    return getTestDomainSiteItemDatum();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected SiteItemDatum getModelObject() {
    return getTestModelSiteItemDatum();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<SiteItemDatum> getModelObjectClass() {
    return SiteItemDatum.class;
  }

}
