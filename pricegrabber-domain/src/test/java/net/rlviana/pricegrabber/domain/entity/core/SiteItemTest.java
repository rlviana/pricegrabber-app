/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.core;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class SiteItemTest extends AbstractEntityTest<SiteItem> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected SiteItem getEntityOK() {
    return getTestSiteItem();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected SiteItem getEntityKO() {
    SiteItem siteItem = new SiteItem();
    return siteItem;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<SiteItem> getDomainEntityType() {
    return SiteItem.class;
  }

}
