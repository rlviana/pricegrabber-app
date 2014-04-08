/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

/**
 * @author ramon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class })
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:/dbunit/test-Dataset.xml")
public abstract class AbstractReadOnlyEntityTest<T extends IEntity<K>, K extends Serializable> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractReadOnlyEntityTest.class);

  @PersistenceContext
  private EntityManager entityManager;

  @BeforeClass
  public static void setUpTest() {
    LOGGER.trace("Starting tests");
  }

  @AfterClass
  public static void tearDownTest() {
    LOGGER.trace("Finished tests");
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
