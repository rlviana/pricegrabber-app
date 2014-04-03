/**
 * 
 */
package net.rlviana.pricegrabber.model.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.Serializable;

import javax.persistence.PersistenceException;

import net.rlviana.pricegrabber.model.entity.AbstractEntityTest;
import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.entity.common.Language;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;

/**
 * @author ramon
 * 
 * @param <T>
 * @param <K>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionDbUnitTestExecutionListener.class })
@Transactional
public abstract class AbstractRepositoryIT<T extends IEntity<K>, K extends Serializable>
    extends
    AbstractReadOnlyRepositoryIT<T, K> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEntityTest.class);

  protected static final String NAME_TAG = "name";
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
    entity = getRepository().create(entity);
    LOGGER.debug("Pesisted with id:{}", entity.getId());
    getEntityManager().flush();
    assertNotNull(getRepository().findById(entity.getId()));
  }

  @Test(expected = PersistenceException.class)
  public void testInsertKO() {
    LOGGER.debug("testInsertKO()");
    T entity = getEntityCreateKO();
    entity = getRepository().create(entity);
    LOGGER.debug("Pesisted with id:{}", entity.getId());
    getEntityManager().flush();
    assertNull(getRepository().findById(entity.getId()));
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
    return getRepository().findById(getEntityPKUpdateOK());
  }

  protected T getEntityUpdateKO() {
    return getRepository().findById(getEntityPKUpdateOK());
  }

  protected Country getTestCountry() {
    return getCountryRepository().findById(COUNTRY_ID);
  }

  protected Currency getTestCurrency() {
    return getCurrencyRepository().findById(CURRENCY_ID);
  }

  protected Language getTestLanguage() {
    return getLanguageRepository().findById(LANGUAGE_ID);
  }

  @Override
  protected abstract ObjectRepository<T, K> getRepository();

}
