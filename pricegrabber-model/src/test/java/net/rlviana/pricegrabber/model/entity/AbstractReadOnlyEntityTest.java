/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
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
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class })
@Transactional
public abstract class AbstractReadOnlyEntityTest<T extends IEntity<K>, K extends Serializable> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReadOnlyEntityTest.class);

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private DataSource dataSource;

  private IDatabaseConnection getConnection() throws Exception {
    Connection con = null;
    try {
      Class.forName(JPAPersistenceContext.ECLIPSELINK_ENTITY_MANAGER_CLASS);
      con = entityManager.unwrap(Connection.class);
    } catch (ClassNotFoundException e) {
      Session session = entityManager.unwrap(Session.class);
      SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
      @SuppressWarnings("deprecation")
      ConnectionProvider cp = sfi.getConnectionProvider();
      con = cp.getConnection();
    }
    return new DatabaseConnection(con);
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

  @Test
  public void testFindById() {
    LOGGER.debug("testFindById()");
    assertEquals(getEntityPKFindOK(), getEntityManager().find(getTestClass(), getEntityPKFindOK()).getId());
  }

  @Test
  public void testNotFound() {
    LOGGER.debug("testNotFound()");
    assertNull(getEntityManager().find(getTestClass(), getEntityPKFindKO()));
  }

  @Test
  public void testFindAll() {
    assertTrue(getEntityManager().createQuery("select a from " + getTestClass().getSimpleName() + " a")
        .getResultList()
        .size() > 0);
  }

  protected abstract K getEntityPKFindOK();

  protected abstract K getEntityPKFindKO();

  protected EntityManager getEntityManager() {
    return entityManager;
  }

  protected abstract Class<T> getTestClass();
}
