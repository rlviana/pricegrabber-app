/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.Serializable;

import javax.persistence.PersistenceException;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.entity.common.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;

/**
 * @author ramon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionDbUnitTestExecutionListener.class })
@Transactional
public abstract class AbstractEntityTest<T extends IEntity<K>, K extends Serializable>
    extends AbstractReadOnlyEntityTest<T, K> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEntityTest.class);

  protected final static String NAME_TAG = "name";
  protected static final String MOD_TAG = "mod";
  protected static final String URL_TAG = "url";
  protected static final String DESCRIPTION_TAG = "desc";

  protected static final String COUNTRY_ID = "ES";
  protected static final String CURRENCY_ID = "US";
  protected static final String LANGUAGE_ID = "ES";

  @Test
  public void testInsertOK() {
    LOGGER.debug("testInsertOK()");
    T entity = getEntityCreateOK();
    getEntityManager().persist(entity);
    LOGGER.debug("Pesisted with id:{}", entity.getId());
    getEntityManager().flush();
    assertNotNull(getEntityManager().find(getTestClass(), entity.getId()));
  }

  @Test(expected = PersistenceException.class)
  public void testInsertKO() {
    LOGGER.debug("testInsertKO()");
    T entity = getEntityCreateKO();
    getEntityManager().persist(entity);
    getEntityManager().flush();
    LOGGER.debug("Pesisted with id:{}", entity.getId());

    assertNull(getEntityManager().find(getTestClass(), entity.getId()));
  }

  @Test
  public abstract void testUpdateOK();

  @Test(expected = PersistenceException.class)
  public abstract void testUpdateKO();

  protected abstract K getEntityPKDeleteOK();

  protected abstract K getEntityPKDeleteKO();

  protected abstract K getEntityPKUpdateOK();

  protected abstract K getEntityPKUpdateKO();

  protected abstract T getEntityCreateOK();

  protected abstract T getEntityCreateKO();

  protected T getEntityUpdateOK() {
    return getEntityManager().find(getTestClass(), getEntityPKUpdateOK());
  }

  protected T getEntityUpdateKO() {
    return getEntityManager().find(getTestClass(), getEntityPKUpdateOK());
  }

  protected Country getTestCountry() {
    return getEntityManager().find(Country.class, COUNTRY_ID);
  }

  protected Currency getTestCurrency() {
    return getEntityManager().find(Currency.class, CURRENCY_ID);
  }

  protected Language getTestLanguage() {
    return getEntityManager().find(Language.class, LANGUAGE_ID);
  }

}
