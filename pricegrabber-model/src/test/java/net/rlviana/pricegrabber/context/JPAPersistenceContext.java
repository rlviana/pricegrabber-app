package net.rlviana.pricegrabber.context;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource(value = { "classpath:persistence.properties", "classpath:jpa.properties" })
@EnableTransactionManagement
public class JPAPersistenceContext {

  private static final Logger LOGGER = LoggerFactory.getLogger(JPAPersistenceContext.class);

  public static final String ECLIPSELINK_ENTITY_MANAGER_CLASS = "org.eclipse.persistence.jpa.JpaEntityManager";

  protected static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
  protected static final String PROPERTY_NAME_DATABASE_URL = "db.url";
  protected static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
  protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

  protected static final String PROPERTY_NAME_JPA_SCHEMA_ACTION = "javax.persistence.schema-generation.database.action";

  protected static final String PROPERTY_NAME_JPA_SCHEMA_CREATE_SOURCE =
      "javax.persistence.schema-generation.create-source";
  protected static final String PROPERTY_NAME_JPA_SCHEMA_CREATE_SCRIPT_SOURCE =
      "javax.persistence.schema-generation.create-script-source";
  protected static final String PROPERTY_NAME_JPA_SCHEMA_DROP_SOURCE =
      "javax.persistence.schema-generation.drop-source";
  protected static final String PROPERTY_NAME_JPA_SCHEMA_DROP_SCRIPT_SOURCE =
      "javax.persistence.schema-generation.drop-script-source";
  protected static final String PROPERTY_NAME_JPA_SCHEMA_LOAD_SCRIPT_SOURCE =
      "javax.persistence.sql-load-script-source";

  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private static final String PROPERTY_NAME_HIBERNATE_EJB_CLASS_ENHANCER = "hibernate.ejb.use_class_enhancer";

  private static final String PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL = "eclipselink.logging.level";
  private static final String PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL_SQL = "eclipselink.logging.level.sql";
  private static final String PROPERTY_NAME_ECLIPSELINK_LOG_PARAMETERS = "eclipselink.logging.parameters";
  private static final String PROPERTY_NAME_ECLIPSELINK_WEAVING = "eclipselink.weaving";
  private static final String PROPERTY_NAME_ECLIPSELINK_LOGGING_LOGER = "eclipselink.logging.logger";

  @Autowired
  private Environment environment;

  /**
   * Creates a datasource for the configured parameters
   * 
   * @return created datasource (uses BoneCPDataSource)
   */
  @Bean
  public DataSource dataSource() {

    BoneCPDataSource dataSource = new BoneCPDataSource();
    dataSource.setDriverClass(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
    dataSource.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
    // DriverManagerDataSource dataSource = new DriverManagerDataSource();
    // dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
    // dataSource.setUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));

    dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
    dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
    return dataSource;
  }

  private JpaVendorAdapter jpaVendorAdapter() {
    JpaVendorAdapter jpaVendorAdapter = null;
    try {
      Class.forName(ECLIPSELINK_ENTITY_MANAGER_CLASS);
      jpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
      LOGGER.info("Using EclipseLink JPA Adapter");
    } catch (ClassNotFoundException e) {
      LOGGER.info("Could not find entity manager for EclipseLink using Hibernate JPA Adapter instead");
      jpaVendorAdapter = new HibernateJpaVendorAdapter();
    }
    return jpaVendorAdapter;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

  private JpaDialect jpaVendorDialect() {
    JpaDialect jpaDialect = null;
    try {
      Class.forName(ECLIPSELINK_ENTITY_MANAGER_CLASS);
      jpaDialect = new EclipseLinkJpaDialect();
      LOGGER.info("Using EclipseLink JPA Dialect");
    } catch (ClassNotFoundException e) {
      LOGGER.info("Could not find entity manager for EclipseLink using Hibernate JPA Dialect instead");
      jpaDialect = new HibernateJpaDialect();
    }
    return jpaDialect;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
    entityManagerFactoryBean.setJpaDialect(jpaVendorDialect());
    entityManagerFactoryBean.setJpaProperties(jpaProperties());
    return entityManagerFactoryBean;
  }

  // @Bean
  // public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
  // final JpaTransactionManager transactionManager = new JpaTransactionManager();
  // transactionManager.setEntityManagerFactory(emf);
  // return transactionManager;
  // }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  protected Properties jpaProperties() {
    Properties jpaProperties = new Properties();

    jpaProperties.setProperty(PROPERTY_NAME_JPA_SCHEMA_ACTION,
        environment.getRequiredProperty(PROPERTY_NAME_JPA_SCHEMA_ACTION));

    if (environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_CREATE_SOURCE) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_JPA_SCHEMA_CREATE_SOURCE,
          environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_CREATE_SOURCE));
    }

    if (environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_CREATE_SCRIPT_SOURCE) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_JPA_SCHEMA_CREATE_SCRIPT_SOURCE,
          environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_CREATE_SCRIPT_SOURCE));
    }

    if (environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_DROP_SOURCE) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_JPA_SCHEMA_DROP_SOURCE,
          environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_DROP_SOURCE));
    }

    if (environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_DROP_SCRIPT_SOURCE) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_JPA_SCHEMA_DROP_SCRIPT_SOURCE,
          environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_DROP_SCRIPT_SOURCE));
    }

    if (environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_LOAD_SCRIPT_SOURCE) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_JPA_SCHEMA_LOAD_SCRIPT_SOURCE,
          environment.getProperty(PROPERTY_NAME_JPA_SCHEMA_LOAD_SCRIPT_SOURCE));
    }

    // Looks for hibernate properties
    if (environment.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_DIALECT,
          environment.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    }
    if (environment.getProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
          environment.getProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
    }
    if (environment.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
          environment.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
    }

    if (environment.getProperty(PROPERTY_NAME_HIBERNATE_EJB_CLASS_ENHANCER) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_EJB_CLASS_ENHANCER,
          environment.getProperty(PROPERTY_NAME_HIBERNATE_EJB_CLASS_ENHANCER));
    }

    // Looks for eclipselink properties
    if (environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL,
          environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL));
    }
    if (environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL_SQL) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL_SQL,
          environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOG_LEVEL_SQL));
    }
    if (environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOG_PARAMETERS) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_ECLIPSELINK_LOG_PARAMETERS,
          environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOG_PARAMETERS));
    }
    if (environment.getProperty(PROPERTY_NAME_ECLIPSELINK_WEAVING) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_ECLIPSELINK_WEAVING,
          environment.getProperty(PROPERTY_NAME_ECLIPSELINK_WEAVING));
    }
    if (environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOGGING_LOGER) != null) {
      jpaProperties.setProperty(PROPERTY_NAME_ECLIPSELINK_LOGGING_LOGER,
          environment.getProperty(PROPERTY_NAME_ECLIPSELINK_LOGGING_LOGER));
    }

    LOGGER.debug("Using JPA Properties: {}", jpaProperties);
    return jpaProperties;
  }
}
