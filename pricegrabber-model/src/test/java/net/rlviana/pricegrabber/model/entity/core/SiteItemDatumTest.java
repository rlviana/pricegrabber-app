/*
 * Created on 24/02/2014
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.Date;
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
public class SiteItemDatumTest extends AbstractEntityTest<SiteItemDatum, Long> {

  private static final Logger LOGGER = LoggerFactory.getLogger(SiteItemDatumTest.class);

  private static final Long SITEITEM_ID = 1L;

  private static final Long ENTITY_PK_FIND_OK = 1L;
  private static final Long ENTITY_PK_FIND_KO = 0L;
  private static final Long ENTITY_PK_DELETE_OK = 2L;
  private static final Long ENTITY_PK_DELETE_KO = 1L;

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
    return getEntityManager().find(SiteItem.class, SITEITEM_ID);
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
  protected Class<SiteItemDatum> getTestClass() {
    return SiteItemDatum.class;
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
