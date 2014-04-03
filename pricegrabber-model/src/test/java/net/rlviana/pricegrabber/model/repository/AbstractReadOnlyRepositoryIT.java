/**
 * 
 */
package net.rlviana.pricegrabber.model.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.context.RepositoryContext;
import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.repository.common.CountryRepository;
import net.rlviana.pricegrabber.model.repository.common.CurrencyRepository;
import net.rlviana.pricegrabber.model.repository.common.LanguageRepository;
import net.rlviana.pricegrabber.model.repository.core.ItemRepository;
import net.rlviana.pricegrabber.model.repository.core.ItemTypeRepository;
import net.rlviana.pricegrabber.model.repository.core.PromotionRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteItemDatumRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteItemRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteRepository;
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author ramon
 * 
 * @param <T>
 * @param <K>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class, RepositoryContext.class })
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:/dbunit/test-Dataset.xml")
public abstract class AbstractReadOnlyRepositoryIT<T extends IEntity<K>, K extends Serializable> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReadOnlyRepositoryIT.class);

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private DataSource dataSource;

  private CurrencyRepository currencyRepository;
  private LanguageRepository languageRepository;
  private CountryRepository countryRepository;
  private ItemRepository itemRepository;
  private ItemTypeRepository itemTypeRepository;
  private PromotionRepository promotionRepository;
  private SiteItemDatumRepository siteItemDatumRepository;
  private SiteItemRepository siteItemRepository;
  private SiteRepository siteRepository;

  // private IDatabaseConnection getConnection() throws Exception {
  // return new DatabaseConnection(entityManager.unwrap(java.sql.Connection.class));
  // }
  //
  // private IDataSet getDataSet() throws Exception {
  // FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
  // flatXmlDataSetBuilder.setColumnSensing(true);
  // return flatXmlDataSetBuilder.build(
  // Thread.currentThread().getContextClassLoader().getResourceAsStream(""));
  //
  // }

  @BeforeClass
  public static void setUpTest() {
    LOGGER.trace("Starting tests");
  }

  @AfterClass
  public static void tearDownTest() {
    LOGGER.trace("Finished tests");
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
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

  /**
   * Constructor
   */
  public AbstractReadOnlyRepositoryIT() {
  }

  @Test
  public void testFindByIdOK() {
    assertNotNull(getRepository().findById(getKeyOK()));
  }

  @Test
  public void testFindByIdKO() {
    assertNull(getRepository().findById(getKeyKO()));
  }

  @Test
  public void testFindAll() {
    assertTrue(getRepository().findAll().size() > 1);
  }

  @Test
  public void testFindByCriteria() {
    assertTrue(getRepository().findByCriteria(getCriteria()).size() > 0);
  }

  @Test
  public void testFindByCriteriaEmpty() {
    assertTrue(getRepository().findByCriteria(getCriteriaEmpty()).size() > 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFindByCriteriaNull() {
    getRepository().findByCriteria(null);
  }

  @Test
  public void testCountAll() {
    assertTrue(getRepository().countAll() > 1);
  }

  @Test
  public void testCountByCriteria() {
    assertTrue(getRepository().countByCriteria(getCriteria()) > 0);
  }

  @Test
  public void testSearchByCriteria() {
    assertTrue(getRepository().searchByCriteria(getCriteria()).getResults().size() > 0);
  }

  @Test
  public void testSearchByCriteriaEmpty() {
    assertTrue(getRepository().searchByCriteria(getCriteriaEmpty()).getResults().size() > 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSearchByCriteriaNull() {
    getRepository().searchByCriteria(null);
  }

  /**
   * @return
   */
  protected abstract AbstractSearchCriteria<T, K> getCriteria();

  /**
   * @return
   */
  protected abstract AbstractSearchCriteria<T, K> getCriteriaEmpty();

  protected abstract K getKeyOK();

  protected abstract K getKeyKO();

  protected abstract ReadOnlyObjectRepository<T, K> getRepository();

  /**
   * @return the entityManager
   */
  public EntityManager getEntityManager() {
    return entityManager;
  }

}
