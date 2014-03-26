/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity.common;

import net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ramon
 */
public class CountryTest extends AbstractReadOnlyEntityTest<Country, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(CountryTest.class);

  @Test
  public void testFindByCriteria() {
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindOK()
   */
  @Override
  protected String getEntityPKFindOK() {
    return "ES";
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindKO()
   */
  @Override
  protected String getEntityPKFindKO() {
    return "NES";
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getTestClass()
   */
  @Override
  protected Class<Country> getTestClass() {
    return Country.class;
  }

}
