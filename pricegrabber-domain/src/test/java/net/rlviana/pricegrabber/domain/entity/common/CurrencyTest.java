/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.common;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class CurrencyTest extends AbstractEntityTest<Currency> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected Currency getEntityOK() {
    return getTestCurrency();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected Currency getEntityKO() {
    Currency currency = new Currency();
    return currency;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<Currency> getDomainEntityType() {
    return Currency.class;
  }

}
