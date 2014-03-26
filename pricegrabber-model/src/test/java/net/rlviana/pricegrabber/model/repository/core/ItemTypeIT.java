/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.repository.core;

import static org.junit.Assert.assertTrue;
import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.core.ItemType;
import net.rlviana.pricegrabber.model.entity.core.ItemTypeTest;
import net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.core.ItemTypeSearchCriteria;

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
public class ItemTypeIT extends AbstractRepositoryIT<ItemType, Integer> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ItemTypeTest.class);

  private static final Integer ENTITY_PK_FIND_OK = 1;
  private static final Integer ENTITY_PK_WITH_CHILDREN = 1;
  private static final Integer ENTITY_PK_FIND_KO = 0;
  private static final Integer ENTITY_PK_DELETE_OK = 2;
  private static final Integer ENTITY_PK_DELETE_KO = 1;

  private static final String ITEM_TYPE_NAME_TAG = null;

  private ItemTypeRepository repository;

  @Test
  public void testInsertWithParent() {
    ItemType entity = getEntityCreateOK();
    ItemType parent = getRepository().findById(ENTITY_PK_WITH_CHILDREN);
    entity.setParent(parent);
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

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT#getRepository()
   */
  @Override
  protected ItemTypeRepository getRepository() {
    return repository;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected ItemTypeSearchCriteria getCriteria() {
    ItemTypeSearchCriteria criteria = getCriteriaEmpty();
    criteria.setName(ITEM_TYPE_NAME_TAG);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected ItemTypeSearchCriteria getCriteriaEmpty() {
    return new ItemTypeSearchCriteria();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyOK()
   */
  @Override
  protected Integer getKeyOK() {
    return ENTITY_PK_FIND_OK;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyKO()
   */
  @Override
  protected Integer getKeyKO() {
    return ENTITY_PK_FIND_KO;
  }

  /**
   * @param repository the repository to set
   */
  @Autowired
  public void setRepository(ItemTypeRepository repository) {
    this.repository = repository;
  }

}
