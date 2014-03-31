/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.core;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class SiteItemDatumTest extends AbstractEntityTest<SiteItemDatum> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected SiteItemDatum getEntityOK() {
    return getTestSiteItemDatum();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected SiteItemDatum getEntityKO() {
    SiteItemDatum siteItemDatum = new SiteItemDatum();
    return siteItemDatum;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<SiteItemDatum> getDomainEntityType() {
    return SiteItemDatum.class;
  }

}
