/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.repository.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.core.Item;
import net.rlviana.pricegrabber.model.entity.core.Promotion;
import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.core.SiteItemSearchCriteria;

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
public class SiteItemIT extends AbstractRepositoryIT<SiteItem, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(SiteItemIT.class);

  private static final Long ITEM_ID = 1L;
  private static final Long SITE_ID = 1L;
  private static final Long PROMOTION_ID = 1L;

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;
  private static final Long ENTITY_PK_FIND_WITH_CHILDREN = 1L;
  private static final Long ENTITY_PK_FIND_WITHOUT_CHILDREN = 3L;

  private static final String SITE_ITEM_NAME_TAG = "SiteItemName1";

  private SiteItemRepository repository;

  @Test
  public void testFindWithChildren() {
    SiteItem entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getSiteItemData().size() > 0);
    if (entity.getSiteItemData().size() > 0) {
      SiteItemDatum datum = entity.getSiteItemData().get(0);
      assertEquals(entity.getPriceCurrency(), datum.getPriceCurrency());
      assertEquals(entity.getPriceDate(), datum.getPriceDate());
      assertEquals(entity.getPriceType(), datum.getPriceType());
      assertEquals(entity.getPriceValue(), datum.getPriceValue());
    }
  }

  @Test
  public void testFindWithoutChildren() {
    SiteItem entity = getRepository().findById(ENTITY_PK_FIND_WITHOUT_CHILDREN);
    assertNull(entity.getPriceCurrency());
    assertNull(entity.getPriceDate());
    assertNull(entity.getPriceType());
    assertNull(entity.getPriceValue());
  }

  @Test
  public void testRemoveChildWithMerge() {
    SiteItem entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getPromotions().size() > 0);
    LOGGER.debug("Children before:{}", entity.getPromotions().size());
    entity.getPromotions().remove(0);
    LOGGER.debug("Children after:{}", entity.getPromotions().size());
    entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    LOGGER.debug("Children after commiting:{}", entity.getPromotions().size());
  }

  @Test
  public void testRemoveChild() {
    SiteItem entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getPromotions().size() > 0);
    LOGGER.debug("Children before:{}", entity.getPromotions().size());
    entity.removePromotion(entity.getPromotions().get(0));
    LOGGER.debug("Children after:{}", entity.getPromotions().size());
    entity = getRepository().findById(ENTITY_PK_FIND_WITH_CHILDREN);
    LOGGER.debug("Children after commiting:{}", entity.getPromotions().size());
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected SiteItem getEntityCreateOK() {
    SiteItem entity = new SiteItem();
    entity.setName(NAME_TAG);
    entity.setItem(getItem());
    entity.setSite(getSite());
    entity.addPromotion(getPromotion());
    entity.setSiteCod("siteCod");
    entity.setUrl(URL_TAG);
    return entity;
  }

  /**
   * @return
   */
  private Promotion getPromotion() {
    return getPromotionRepository().findById(PROMOTION_ID);
  }

  /**
   * @return
   */
  private Item getItem() {
    return getItemRepository().findById(ITEM_ID);
  }

  /**
   * @return
   */
  private Site getSite() {
    return getSiteRepository().findById(SITE_ID);
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected SiteItem getEntityCreateKO() {
    SiteItem entity = new SiteItem();
    entity.setName(NAME_TAG);
    return entity;
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateOK()
   */
  @Override
  public void testUpdateOK() {
    SiteItem entity = getEntityUpdateOK();
    entity.setName(MOD_TAG);
    getEntityManager().flush();
    assertEquals(entity.getName(), MOD_TAG);
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateKO()
   */
  @Override
  public void testUpdateKO() {
    SiteItem entity = getEntityUpdateOK();
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
  protected SiteItemRepository getRepository() {
    return repository;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected SiteItemSearchCriteria getCriteria() {
    SiteItemSearchCriteria criteria = getCriteriaEmpty();
    criteria.setName(SITE_ITEM_NAME_TAG);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected SiteItemSearchCriteria getCriteriaEmpty() {
    return new SiteItemSearchCriteria();
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
  public void setRepository(SiteItemRepository repository) {
    this.repository = repository;
  }

}
