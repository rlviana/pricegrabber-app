/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.repository.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.core.Promotion;
import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.core.PromotionSearchCriteria;

import org.junit.Test;
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
public class PromotionIT extends AbstractRepositoryIT<Promotion, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(PromotionIT.class);

  private static final Long SITEITEM_ID = 1L;
  private static final Long SITE_ID = 1L;

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;
  private static final Long ENTITY_PK_FIND_WITH_CHILDREN = 1L;
  private static final Long ENTITY_PK_FIND_WITHOUT_CHILDREN = 3L;

  private static final String PROMOTION_NAME_TAG = null;

  private PromotionRepository repository;

  @Test
  public void testRemoveChild() {
    Promotion entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getSiteItems().size() > 0);
    LOGGER.debug("Children before:{}", entity.getSiteItems().size());
    entity.getSiteItems().remove(0);
    LOGGER.debug("Children after:{}", entity.getSiteItems().size());
    getEntityManager().flush();
    getEntityManager().clear();
    entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    LOGGER.debug("Children after commiting:{}", entity.getSiteItems().size());
  }

  @Test
  public void testFindWithChildren() {
    Promotion entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getSiteItems().size() > 0);
  }

  @Test
  public void testFindWithoutChildren() {
    Promotion entity = getRepository().findById(ENTITY_PK_FIND_WITHOUT_CHILDREN);
    assertTrue(entity.getSiteItems().size() == 0);
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected Promotion getEntityCreateOK() {
    Promotion entity = new Promotion();
    entity.setName(NAME_TAG);
    entity.addSiteItem(getSiteItem());
    entity.setSite(getSite());
    entity.setDescription(DESCRIPTION_TAG);
    entity.setUrl(URL_TAG);
    return entity;
  }

  /**
   * @return
   */
  private Site getSite() {
    return getSiteRepository().findById(SITE_ID);
  }

  /**
   * @return
   */
  private SiteItem getSiteItem() {
    return getSiteItemRepository().findById(SITEITEM_ID);
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected Promotion getEntityCreateKO() {
    Promotion entity = new Promotion();
    entity.setName(NAME_TAG);
    return entity;
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateOK()
   */
  @Override
  public void testUpdateOK() {
    Promotion entity = getEntityUpdateOK();
    entity.setName(MOD_TAG);
    getEntityManager().flush();
    assertEquals(getEntityUpdateOK().getName(), MOD_TAG);
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateKO()
   */
  @Override
  public void testUpdateKO() {
    Promotion entity = getEntityUpdateOK();
    entity.setName(null);
    getEntityManager().flush();
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
   * 
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT#getEntityPKUpdateOK()
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
  protected PromotionRepository getRepository() {
    return repository;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected PromotionSearchCriteria getCriteria() {
    PromotionSearchCriteria criteria = getCriteriaEmpty();
    criteria.setName(PROMOTION_NAME_TAG);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected PromotionSearchCriteria getCriteriaEmpty() {
    return new PromotionSearchCriteria();
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
  public void setRepository(PromotionRepository repository) {
    this.repository = repository;
  }

}
