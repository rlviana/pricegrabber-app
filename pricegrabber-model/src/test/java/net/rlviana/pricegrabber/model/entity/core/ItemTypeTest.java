/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

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
@ContextConfiguration(classes = {JPAPersistenceContext.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ItemTypeTest extends AbstractEntityTest<ItemType, Integer> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ItemTypeTest.class);

  private static final Integer ENTITY_PK_FIND_OK = 1;
  private static final Integer ENTITY_PK_FIND_KO = 0;
  private static final Integer ENTITY_PK_DELETE_OK = 2;
  private static final Integer ENTITY_PK_DELETE_KO = 1;

  @Test
  public void testInsertWithParent() {
    ItemType entity = getEntityCreateOK();
    ItemType parent = getEntityManager().find(ItemType.class, getEntityPKFindOK());
    entity.setParent(parent);
    getEntityManager().persist(entity);
    getEntityManager().flush();
    LOGGER.debug("Pesisted with id:{}", entity.getId());
    assertTrue(parent.getChildren().contains(entity));
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected ItemType getEntityCreateOK() {
    ItemType itemType = new ItemType();
    itemType.setName(NAME_TAG);
    return itemType;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected ItemType getEntityCreateKO() {
    ItemType itemType = new ItemType();
    return itemType;
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateOK()
   */
  @Override
  public void testUpdateOK() {
    ItemType item = getEntityUpdateOK();
    item.setName(MOD_TAG);
    getEntityManager().flush();
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateKO()
   */
  @Override
  public void testUpdateKO() {
    ItemType item = getEntityUpdateOK();
    item.setName(null);
    getEntityManager().flush();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKDeleteOK()
   */
  @Override
  protected Integer getEntityPKDeleteOK() {
    return ENTITY_PK_DELETE_OK;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKDeleteKO()
   */
  @Override
  protected Integer getEntityPKDeleteKO() {
    return ENTITY_PK_DELETE_KO;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindOK()
   */
  @Override
  protected Integer getEntityPKFindOK() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getEntityPKFindKO()
   */
  @Override
  protected Integer getEntityPKFindKO() {
    return ENTITY_PK_FIND_KO;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractReadOnlyEntityTest#getTestClass()
   */
  @Override
  protected Class<ItemType> getTestClass() {
    return ItemType.class;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKUpdateOK()
   */
  @Override
  protected Integer getEntityPKUpdateOK() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityPKUpdateKO()
   */
  @Override
  protected Integer getEntityPKUpdateKO() {
    return ENTITY_PK_FIND_OK;
  }

}
