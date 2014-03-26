/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.xml.sax.InputSource;

/**
 * @author ramon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class })
public class EntityConfigurationTest {

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private DataSource dataSource;

  @Test
  public void testConfiguration() throws Exception {
    DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet()); //
    // Import
    getConnection().close();
  }

  private IDatabaseConnection getConnection() throws Exception {
    return new DatabaseConnection(dataSource.getConnection());
  }

  private IDataSet getDataSet() throws Exception {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    return new FlatXmlDataSet(new FlatXmlProducer(new InputSource(
        classLoader.getResourceAsStream("dbunit/test-Dataset.xml"))));

  }

}
