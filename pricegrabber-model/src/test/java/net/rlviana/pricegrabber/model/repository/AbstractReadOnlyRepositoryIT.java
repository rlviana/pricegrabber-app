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
import net.rlviana.pricegrabber.model.search.AbstractSearchCriteria;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ramon
 * 
 * @param <T>
 * @param <K>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class, RepositoryContext.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class })
@Transactional
public abstract class AbstractReadOnlyRepositoryIT<T extends IEntity<K>, K extends Serializable> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReadOnlyRepositoryIT.class);

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private DataSource dataSource;

  private IDatabaseConnection getConnection() throws Exception {
    return new DatabaseConnection(entityManager.unwrap(java.sql.Connection.class));
  }

  private IDataSet getDataSet() throws Exception {
    FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
    flatXmlDataSetBuilder.setColumnSensing(true);
    return flatXmlDataSetBuilder.build(
        Thread.currentThread().getContextClassLoader().getResourceAsStream("dbunit/test-Dataset.xml"));

  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    assertNotNull(entityManager);
    IDatabaseConnection conn = getConnection();
    DatabaseOperation.CLEAN_INSERT.execute(conn, getDataSet()); //
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
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
