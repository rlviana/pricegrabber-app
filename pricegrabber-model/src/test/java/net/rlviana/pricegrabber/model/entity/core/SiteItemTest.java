/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.AbstractEntityTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class SiteItemTest extends AbstractEntityTest<SiteItem, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(SiteItemTest.class);

  private static final Long ITEM_ID = 1L;
  private static final Long SITE_ID = 1L;
  private static final Long PROMOTION_ID = 1L;

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;
  private static final Long ENTITY_PK_FIND_WITH_CHILDREN = 1L;
  private static final Long ENTITY_PK_FIND_WITHOUT_CHILDREN = 3L;

  @Test
  public void testFindWithChildren() {
    SiteItem entity = getEntityManager().find(getTestClass(), ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getSiteItemData().size() > 0);
    if (entity.getSiteItemData().size() > 0) {
      SiteItemDatum datum = entity.getSiteItemData().get(0);
      assertEquals(entity.getPriceCurrency(), datum.getPriceCurrency());
      assertEquals(entity.getCurrentPriceDate(), datum.getPriceDate());
      assertEquals(entity.getCurrentPriceType(), datum.getPriceType());
      assertEquals(entity.getCurrentPriceValue(), datum.getPriceValue());
    }
  }

  @Test
  public void testFindWithoutChildren() {
    SiteItem entity = getEntityManager().find(getTestClass(), ENTITY_PK_FIND_WITHOUT_CHILDREN);
    assertNull(entity.getPriceCurrency());
    assertNull(entity.getCurrentPriceDate());
    assertNull(entity.getCurrentPriceType());
    assertNull(entity.getCurrentPriceValue());
  }

  @Test
  public void testRemoveChildWithMerge() {
    SiteItem entity = getEntityManager().find(getTestClass(), ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getPromotions().size() > 0);
    LOGGER.debug("Children before:{}", entity.getPromotions().size());
    entity.getPromotions().remove(0);
    getEntityManager().refresh(entity);
    LOGGER.debug("Children after:{}", entity.getPromotions().size());
    getEntityManager().clear();
    entity = getEntityManager().find(getTestClass(), ENTITY_PK_FIND_WITH_CHILDREN);
    LOGGER.debug("Children after commiting:{}", entity.getPromotions().size());
  }

  @Test
  public void testRemoveChild() {
    SiteItem entity = getEntityManager().find(getTestClass(), ENTITY_PK_FIND_WITH_CHILDREN);
    assertTrue(entity.getPromotions().size() > 0);
    LOGGER.debug("Children before:{}", entity.getPromotions().size());
    entity.removePromotion(entity.getPromotions().get(0));
    LOGGER.debug("Children after:{}", entity.getPromotions().size());
    getEntityManager().flush();
    getEntityManager().clear();
    entity = getEntityManager().find(getTestClass(), ENTITY_PK_FIND_WITH_CHILDREN);
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
    return getEntityManager().find(Promotion.class, PROMOTION_ID);
  }

  /**
   * @return
   */
  private Item getItem() {
    return getEntityManager().find(Item.class, ITEM_ID);
  }

  /**
   * @return
   */
  private Site getSite() {
    return getEntityManager().find(Site.class, SITE_ID);
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
    assertEquals(getEntityUpdateOK().getName(), MOD_TAG);
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
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindOK()
   */
  @Override
  protected Long getEntityPKFindOK() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindKO()
   */
  @Override
  protected Long getEntityPKFindKO() {
    return ENTITY_PK_FIND_KO;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getTestClass()
   */
  @Override
  protected Class<SiteItem> getTestClass() {
    return SiteItem.class;
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

}
