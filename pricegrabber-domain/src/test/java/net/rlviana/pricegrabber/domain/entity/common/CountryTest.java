/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.common;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class CountryTest extends AbstractEntityTest<Country> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected Country getEntityOK() {
    return getTestCountry();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected Country getEntityKO() {
    Country country = new Country();
    return country;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<Country> getDomainEntityType() {
    return Country.class;
  }

}
