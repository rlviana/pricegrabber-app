/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.repository.core;

import static org.junit.Assert.assertEquals;
import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.core.SiteSearchCriteria;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ramon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAPersistenceContext.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SiteIT extends AbstractRepositoryIT<Site, Long> {

  private SiteRepository repository;

  private static final Logger LOGGER = LoggerFactory.getLogger(SiteIT.class);

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;

  private static final String SITE_NAME_TAG = "SiteName1";

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected Site getEntityCreateOK() {
    Site entity = new Site();
    entity.setName(NAME_TAG);
    entity.setUrl(URL_TAG);
    entity.setDescription(DESCRIPTION_TAG);
    entity.setCountry(getTestCountry());
    entity.setCurrency(getTestCurrency());
    entity.setLanguage(getTestLanguage());
    LOGGER.debug("Entity OK:{}", entity);
    return entity;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected Site getEntityCreateKO() {
    Site entity = new Site();
    entity.setName(NAME_TAG);
    entity.setUrl(URL_TAG);
    LOGGER.debug("Entity KO:{}", entity);
    return entity;
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateOK()
   */
  @Override
  public void testUpdateOK() {
    LOGGER.debug("testUpdateOK()");
    Site entity = getEntityUpdateOK();
    entity.setName(MOD_TAG);
    getEntityManager().flush();
    assertEquals(getEntityUpdateOK().getName(), MOD_TAG);
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateKO()
   */
  @Override
  public void testUpdateKO() {
    LOGGER.debug("testUpdateKO()");
    Site entity = getEntityUpdateOK();
    entity.setName(null);
    getEntityManager().flush();
    LOGGER.debug("testUpdateKO()");
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKDeleteOK()
   */
  @Override
  protected Long getEntityPKDeleteOK() {
    return ENTITY_PK_DELETE_OK;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKDeleteKO()
   */
  @Override
  protected Long getEntityPKDeleteKO() {
    return ENTITY_PK_DELETE_KO;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKUpdateOK()
   */
  @Override
  protected Long getEntityPKUpdateOK() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKUpdateKO()
   */
  @Override
  protected Long getEntityPKUpdateKO() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT#getRepository()
   */
  @Override
  protected SiteRepository getRepository() {
    return repository;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected SiteSearchCriteria getCriteria() {
    SiteSearchCriteria criteria = getCriteriaEmpty();
    criteria.setName(SITE_NAME_TAG);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected SiteSearchCriteria getCriteriaEmpty() {
    return new SiteSearchCriteria();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyOK()
   */
  @Override
  protected Long getKeyOK() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyKO()
   */
  @Override
  protected Long getKeyKO() {
    return ENTITY_PK_FIND_KO;
  }

  /**
   * @param repository the repository to set
   */
  @Autowired
  public void setRepository(SiteRepository repository) {
    this.repository = repository;
  }

}
