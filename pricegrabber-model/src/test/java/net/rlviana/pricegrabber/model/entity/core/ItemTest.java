/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

import static org.junit.Assert.assertEquals;
import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.AbstractEntityTest;
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
public class ItemTest extends AbstractEntityTest<Item, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ItemTest.class);

  private static final Integer ITEMTYPE_ID = 1;

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected Item getEntityCreateOK() {
    Item entity = new Item();
    entity.setName(NAME_TAG);
    entity.setDescription(DESCRIPTION_TAG);
    entity.setItemType(getItemType());
    return entity;
  }

  /**
   * @return
   */
  private ItemType getItemType() {
    return getEntityManager().find(ItemType.class, ITEMTYPE_ID);
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected Item getEntityCreateKO() {
    Item entity = new Item();
    entity.setName(NAME_TAG);
    return entity;
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateOK()
   */
  @Override
  public void testUpdateOK() {
    Item entity = getEntityUpdateOK();
    entity.setName(MOD_TAG);
    getEntityManager().flush();
    assertEquals(getEntityUpdateOK().getName(), MOD_TAG);
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateKO()
   */
  @Override
  public void testUpdateKO() {
    Item entity = getEntityUpdateOK();
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
  protected Class<Item> getTestClass() {
    return Item.class;
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
