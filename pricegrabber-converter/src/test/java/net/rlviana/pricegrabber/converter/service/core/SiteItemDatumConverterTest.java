package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;

/**
 * @author ramon
 * 
 */
public class SiteItemDatumConverterTest
    extends
    ConverterTest<SiteItemDatum, net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum getDomainObject() {
    return getTestDomainSiteItemDatum();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected SiteItemDatum getModelObject() {
    return getTestModelSiteItemDatum();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<SiteItemDatum> getModelObjectClass() {
    return SiteItemDatum.class;
  }

}
