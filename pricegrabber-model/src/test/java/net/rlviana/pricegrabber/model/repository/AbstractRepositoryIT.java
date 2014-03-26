/**
 * 
 */
package net.rlviana.pricegrabber.model.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.Serializable;

import javax.persistence.PersistenceException;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.AbstractEntityTest;
import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.entity.common.Language;
import net.rlviana.pricegrabber.model.repository.common.CountryRepository;
import net.rlviana.pricegrabber.model.repository.common.CurrencyRepository;
import net.rlviana.pricegrabber.model.repository.common.LanguageRepository;
import net.rlviana.pricegrabber.model.repository.core.ItemRepository;
import net.rlviana.pricegrabber.model.repository.core.ItemTypeRepository;
import net.rlviana.pricegrabber.model.repository.core.PromotionRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteItemDatumRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteItemRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author ramon
 * 
 * @param <T>
 * @param <K>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public abstract class AbstractRepositoryIT<T extends IEntity<K>, K extends Serializable>
    extends
    AbstractReadOnlyRepositoryIT<T, K> {

  private CurrencyRepository currencyRepository;
  private LanguageRepository languageRepository;
  private CountryRepository countryRepository;
  private ItemRepository itemRepository;
  private ItemTypeRepository itemTypeRepository;
  private PromotionRepository promotionRepository;
  private SiteItemDatumRepository siteItemDatumRepository;
  private SiteItemRepository siteItemRepository;
  private SiteRepository siteRepository;

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

  /**
   * @return
   */
  protected CountryRepository getCountryRepository() {
    return countryRepository;
  }

  /**
   * @return
   */
  protected CurrencyRepository getCurrencyRepository() {

    return currencyRepository;
  }

  /**
   * @return
   */
  protected LanguageRepository getLanguageRepository() {
    return languageRepository;
  }

  /**
   * @return
   */
  protected ItemRepository getItemRepository() {
    return itemRepository;
  }

  /**
   * @return
   */
  protected ItemTypeRepository getItemTypeRepository() {
    return itemTypeRepository;
  }

  /**
   * @return
   */
  protected PromotionRepository getPromotionRepository() {
    return promotionRepository;
  }

  /**
   * @return
   */
  protected SiteItemDatumRepository getSiteItemDatumRepository() {
    return siteItemDatumRepository;
  }

  /**
   * @return
   */
  protected SiteItemRepository getSiteItemRepository() {
    return siteItemRepository;
  }

  /**
   * @return
   */
  protected SiteRepository getSiteRepository() {
    return siteRepository;
  }

  @Override
  protected abstract ObjectRepository<T, K> getRepository();

  /**
   * @param currencyRepository the currencyRepository to set
   */
  @Autowired
  public void setCurrencyRepository(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  /**
   * @param languageRepository the languageRepository to set
   */
  @Autowired
  public void setLanguageRepository(LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  /**
   * @param countryRepository the countryRepository to set
   */
  @Autowired
  public void setCountryRepository(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  /**
   * @param itemRepository the itemRepository to set
   */
  @Autowired
  public void setItemRepository(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  /**
   * @param itemTypeRepository the itemTypeRepository to set
   */
  @Autowired
  public void setItemTypeRepository(ItemTypeRepository itemTypeRepository) {
    this.itemTypeRepository = itemTypeRepository;
  }

  /**
   * @param promotionRepository the promotionRepository to set
   */
  @Autowired
  public void setPromotionRepository(PromotionRepository promotionRepository) {
    this.promotionRepository = promotionRepository;
  }

  /**
   * @param siteItemDatumRepository the siteItemDatumRepository to set
   */
  @Autowired
  public void setSiteItemDatumRepository(SiteItemDatumRepository siteItemDatumRepository) {
    this.siteItemDatumRepository = siteItemDatumRepository;
  }

  /**
   * @param siteItemRepository the siteItemRepository to set
   */
  @Autowired
  public void setSiteItemRepository(SiteItemRepository siteItemRepository) {
    this.siteItemRepository = siteItemRepository;
  }

  /**
   * @param siteRepository the siteRepository to set
   */
  @Autowired
  public void setSiteRepository(SiteRepository siteRepository) {
    this.siteRepository = siteRepository;
  }
}
