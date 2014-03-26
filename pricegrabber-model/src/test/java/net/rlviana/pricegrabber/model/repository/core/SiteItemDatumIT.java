/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.repository.core;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import net.rlviana.pricegrabber.context.JPAPersistenceContext;
import net.rlviana.pricegrabber.model.entity.core.PriceType;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatumTest;
import net.rlviana.pricegrabber.model.repository.AbstractRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.core.SiteItemDatumSearchCriteria;

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
public class SiteItemDatumIT extends AbstractRepositoryIT<SiteItemDatum, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(SiteItemDatumTest.class);

  private static final Long SITEITEM_ID = 1L;

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;

  private SiteItemDatumRepository repository;

  /**
   * @return
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#getEntityCreate()
   */
  @Override
  protected SiteItemDatum getEntityCreateOK() {
    SiteItemDatum entity = new SiteItemDatum();
    entity.setAvailability("availability");
    entity.setSiteItem(getSiteItem());
    entity.setPriceCurrency(getTestCurrency());
    entity.setPriceDate(new Date());
    entity.setPriceType(PriceType.REGULAR_PRICE);
    entity.setPriceValue(BigDecimal.valueOf(10L));
    return entity;
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
  protected SiteItemDatum getEntityCreateKO() {
    SiteItemDatum entity = new SiteItemDatum();
    entity.setAvailability("availability");
    return entity;
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateOK()
   */
  @Override
  public void testUpdateOK() {
    SiteItemDatum entity = getEntityUpdateOK();
    entity.setAvailability(MOD_TAG);
    getEntityManager().flush();
    assertEquals(getEntityUpdateOK().getAvailability(), MOD_TAG);
  }

  /**
   * @see net.rlviana.pricegrabber.model.entity.AbstractEntityTest#testUpdateKO()
   */
  @Override
  public void testUpdateKO() {
    SiteItemDatum entity = getEntityUpdateOK();
    entity.setSiteItem(null);
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
  protected SiteItemDatumRepository getRepository() {
    return repository;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected SiteItemDatumSearchCriteria getCriteria() {
    SiteItemDatumSearchCriteria criteria = getCriteriaEmpty();
    criteria.setSiteItemId(1L);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected SiteItemDatumSearchCriteria getCriteriaEmpty() {
    return new SiteItemDatumSearchCriteria();
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
  public void setRepository(SiteItemDatumRepository repository) {
    this.repository = repository;
  }

}
