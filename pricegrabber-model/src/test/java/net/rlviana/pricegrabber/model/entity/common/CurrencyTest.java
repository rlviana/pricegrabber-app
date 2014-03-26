/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity.common;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ramon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAPersistenceContext.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class CurrencyTest extends AbstractReadOnlyEntityTest<Currency, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyTest.class);

  @Test
  public void testFindAll() {

  }

  @Test
  public void testFindByCriteria() {
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindOK()
   */
  @Override
  protected String getEntityPKFindOK() {
    return "EU";
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindKO()
   */
  @Override
  protected String getEntityPKFindKO() {
    return "NEU";
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getTestClass()
   */
  @Override
  protected Class<Currency> getTestClass() {
    return Currency.class;
  }

}
