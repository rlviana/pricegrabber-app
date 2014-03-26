/**
 * 
 */
package net.rlviana.pricegrabber.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * @author ramon
 * 
 */
public class DdlGeneration {

  @Test
  public void testGenerateCreateSchema21() {
    Map<String, String> properties = new HashMap<String, String>();
    properties.put("javax.persistence.database-product-name", "Derby");
    properties.put("javax.persistence.database-major-version", "12");
    properties.put("javax.persistence.database-minor-version", "1");
    properties.put("javax.persistence.schema-generation.scripts.action", "drop-and-create");
    properties.put("javax.persistence.schema-generation.scripts.drop-target",
        "jpa21-generate-schema-no-connection-drop.jdbc");
    properties.put("javax.persistence.schema-generation.scripts.create-target",
        "jpa21-generate-schema-no-connection-create.jdbc");

    Persistence.generateSchema("pricegrabber", properties);
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("pricegrabber", persistProperties);
    // emf.createEntityManager();
  }

  @Test
  public void testGenerateCreateSchema20() {
    Map<String, String> persistProperties = new HashMap<String, String>();
    // persistProperties.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
    // persistProperties.put(PersistenceUnitProperties.DDL_GENERATION_MODE,
    // PersistenceUnitProperties.DDL_SQL_SCRIPT_GENERATION);
    // // persistProperties.put(PersistenceUnitProperties.APP_LOCATION, "/users/ramon/workspace");
    // persistProperties.put(PersistenceUnitProperties.CREATE_JDBC_DDL_FILE, "createDB.sql");
    // persistProperties.put(PersistenceUnitProperties.JDBC_DRIVER, "org.apache.derby.jdbc.EmbeddedDriver");
    // persistProperties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:derby:memory:testDB;create=true");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pricegrabber", persistProperties);
    emf.createEntityManager();
  }

  @Test
  public void testGenerateDropSchema() {
  }

}
