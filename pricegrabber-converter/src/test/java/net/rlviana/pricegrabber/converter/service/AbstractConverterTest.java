package net.rlviana.pricegrabber.converter.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.rlviana.pricegrabber.domain.entity.EntityBase;
import net.rlviana.pricegrabber.domain.entity.core.SiteItemPrice;
import net.rlviana.pricegrabber.model.entity.IEntity;
import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.entity.common.Language;
import net.rlviana.pricegrabber.model.entity.core.Item;
import net.rlviana.pricegrabber.model.entity.core.ItemType;
import net.rlviana.pricegrabber.model.entity.core.PriceType;
import net.rlviana.pricegrabber.model.entity.core.Promotion;
import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;

import org.dozer.DozerBeanMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ramon
 * 
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractConverterTest<T extends IEntity, V extends EntityBase> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConverterTest.class);

  private static final int MAX_ITEMS = 10;

  private BaseConverter<T, V> converter;

  private static DozerBeanMapper mapper;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    mapper = new DozerBeanMapper();
    List<String> mappingFileUrls = new ArrayList<String>();
    mappingFileUrls.add("dozer/commonMappings.xml");
    mappingFileUrls.add("dozer/coreMappings.xml");
    // mappingFileUrls.add("dozer/searchMappings.xml");
    mapper.setMappingFiles(mappingFileUrls);
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testDomainClassConversionOK() {
    assertTrue(getModelObjectClass().equals(getConverter().convertFrom(getDomainObject()).getClass()));
  }

  @Test
  public void testModelClassConversionOK() {
    assertTrue(getDomainObjectClass().equals(getConverter().convertTo(getModelObject()).getClass()));
  }

  @Test
  public void testConversionOK() {
    T modelObject = getModelObject();
    V domainObject = getConverter().convertTo(modelObject);
    assertEquals(modelObject, getConverter().convertFrom(domainObject));
  }

  @Test
  public void testConversionListOK() {
    List<T> modelObjectList = getModelObjectList();
    List<V> domainObjectList = getConverter().convertListTo(modelObjectList);
    assertEquals(modelObjectList, getConverter().convertListFrom(domainObjectList));
  }

  //
  // @Test
  // public void testModelConversionOK() {
  // }
  //
  // @Test
  // public void testDomainListOK() {
  // assertTrue(getModelObjectList().getClass().equals(getConverter().convertListFrom(getDomainObjectList()).getClass()));
  // }
  //
  // @Test
  // public void testDomainListConversionClassOK() {
  // assertTrue(getModelObjectList().getClass().equals(getConverter().convertListFrom(getDomainObjectList()).getClass()));
  // }
  //
  // @Test
  // public void testModelListOK() {
  // assertTrue(getDomainObjectList().getClass().equals(getConverter().convertListTo(getModelObjectList()).getClass()));
  // }
  //
  // @Test
  // public void testModelListConversionOK() {
  // }

  protected List<T> getModelObjectList() {
    List<T> list =
        new ArrayList<T>();
    for (int i = 0; i < MAX_ITEMS; i++) {
      list.add(getModelObject());
    }
    return list;
  }

  /**
   * 
   */
  protected List<V> getDomainObjectList() {
    List<V> list =
        new ArrayList<V>();
    for (int i = 0; i < MAX_ITEMS; i++) {
      list.add(getDomainObject());
    }
    return list;
  }

  /**
   * 
   */
  protected net.rlviana.pricegrabber.domain.entity.common.Country getTestDomainCountry() {
    net.rlviana.pricegrabber.domain.entity.common.Country country =
        new net.rlviana.pricegrabber.domain.entity.common.Country();
    country.setCod("cod");
    country.setCode("999");
    country.setName("name");
    return country;
  }

  protected Country getTestModelCountry() {
    Country country =
        new Country();
    country.setCod("cod");
    country.setCodNum(99999);
    country.setName("name");
    return country;
  }

  /**
   * 
   */
  protected net.rlviana.pricegrabber.domain.entity.common.Currency getTestDomainCurrency() {
    net.rlviana.pricegrabber.domain.entity.common.Currency currency =
        new net.rlviana.pricegrabber.domain.entity.common.Currency();
    currency.setCod("1");
    currency.setCode("code");
    currency.setName("name");
    return currency;
  }

  protected Currency getTestModelCurrency() {
    Currency currency =
        new Currency();
    currency.setCod(1);
    currency.setId("id");
    currency.setName("name");
    return currency;
  }

  /**
   * 
   */
  protected net.rlviana.pricegrabber.domain.entity.common.Language getTestDomainLanguage() {
    net.rlviana.pricegrabber.domain.entity.common.Language language =
        new net.rlviana.pricegrabber.domain.entity.common.Language();
    language.setCod("cod");
    language.setCode("code");
    language.setName("name");
    return language;
  }

  protected Language getTestModelLanguage() {
    Language language =
        new Language();
    language.setCod("cod");
    language.setId("id");
    language.setName("name");
    return language;
  }

  /**
   * 
   */
  protected net.rlviana.pricegrabber.domain.entity.core.ItemType getTestDomainItemType() {
    net.rlviana.pricegrabber.domain.entity.core.ItemType itemType =
        new net.rlviana.pricegrabber.domain.entity.core.ItemType();
    itemType.setId(1L);
    itemType.setCode("code");
    itemType.setName("name");
    return itemType;
  }

  protected ItemType getTestModelItemType() {
    ItemType itemType = new ItemType();
    itemType.setId(1);
    itemType.setName("name");
    itemType.setDescription("description");
    itemType.addChildren(getTestModelItemTypeChild());
    return itemType;
  }

  protected ItemType getTestModelItemTypeChild() {
    ItemType itemType = new ItemType();
    itemType.setId(10);
    itemType.setName("childName");
    itemType.setDescription("childDescription");
    return itemType;
  }

  /**
   * 
   */
  protected net.rlviana.pricegrabber.domain.entity.core.Item getTestDomainItem() {
    net.rlviana.pricegrabber.domain.entity.core.Item item =
        new net.rlviana.pricegrabber.domain.entity.core.Item();
    item.setId(1L);
    item.setName("name");
    item.setDescription("description");
    item.setItemType(getTestDomainItemType());
    return item;
  }

  protected Item getTestModelItem() {
    Item item = new Item();
    item.setId(1L);
    item.setDescription("description");
    item.setItemType(getTestModelItemType());
    item.setName("name");
    return item;
  }

  /**
   * 
   */
  protected net.rlviana.pricegrabber.domain.entity.core.Promotion getTestDomainPromotion() {
    net.rlviana.pricegrabber.domain.entity.core.Promotion promotion =
        new net.rlviana.pricegrabber.domain.entity.core.Promotion();
    promotion.setId(1L);
    promotion.setName("name");
    promotion.setDescription("description");
    promotion.setBeginDate(Calendar.getInstance());
    promotion.setEndDate(Calendar.getInstance());
    promotion.setUrl("url");
    promotion.setActive(Boolean.TRUE);
    // promotion.setSiteItems(siteItems);
    return promotion;
  }

  protected Promotion getTestModelPromotion() {
    Promotion promotion = new Promotion();
    promotion.setId(1L);
    promotion.setDescription("description");
    promotion.setName("name");
    promotion.setBeginDate(Calendar.getInstance());
    promotion.setEndDate(Calendar.getInstance());
    promotion.setActive(Boolean.TRUE);
    return promotion;
  }

  protected net.rlviana.pricegrabber.domain.entity.core.SiteItem getTestDomainSiteItem() {
    net.rlviana.pricegrabber.domain.entity.core.SiteItem siteItem =
        new net.rlviana.pricegrabber.domain.entity.core.SiteItem();
    siteItem.setId(1L);
    siteItem.setName("name");
    siteItem.setUrl("url");
    siteItem.setItemType(getTestDomainItemType());
    siteItem.setSiteCod("siteCod");
    // siteItem.setSiteItemData(siteItemData);
    // siteItem.setPromotions(siteItemData);
    siteItem.setCurrentPrice(getTestPrice());
    siteItem.setHighestPrice(getTestPrice());
    siteItem.setLowestPrice(getTestPrice());
    return siteItem;
  }

  /**
   * @return
   */
  private SiteItemPrice getTestPrice() {
    SiteItemPrice price = new SiteItemPrice();
    price.setPriceCurrency(getTestDomainCurrency());
    price.setPriceDate(Calendar.getInstance());
    price.setPriceValue(BigDecimal.valueOf(10));
    return price;
  }

  protected SiteItem getTestModelSiteItem() {
    SiteItem siteItem = new SiteItem();
    siteItem.setId(1L);
    siteItem.setName("name");
    siteItem.setSite(getTestModelSite());
    siteItem.setSiteCod("siteCod");
    siteItem.setUrl("url");
    // siteItem.setPromotions(promotions);
    // siteItem.setSiteItemData(siteItemData);
    return siteItem;
  }

  protected net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum getTestDomainSiteItemDatum() {
    net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum siteItemDatum =
        new net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum();
    siteItemDatum.setId(1L);
    siteItemDatum.setAvailability("availability");
    siteItemDatum.setPriceCurrency(getTestDomainCurrency());
    siteItemDatum.setPriceDate(Calendar.getInstance());
    siteItemDatum.setPriceType(net.rlviana.pricegrabber.domain.entity.core.PriceType.REGULAR_PRICE);
    siteItemDatum.setPriceValue(BigDecimal.valueOf(10));
    siteItemDatum.setSiteItem(getTestDomainSiteItem());
    return siteItemDatum;
  }

  protected SiteItemDatum getTestModelSiteItemDatum() {
    SiteItemDatum siteItemDatum = new SiteItemDatum();
    siteItemDatum.setId(1L);
    siteItemDatum.setAvailability("availability");
    siteItemDatum.setPriceCurrency(getTestModelCurrency());
    siteItemDatum.setPriceDate(Calendar.getInstance());
    siteItemDatum.setPriceType(PriceType.REGULAR_PRICE);
    siteItemDatum.setPriceValue(BigDecimal.valueOf(10));
    siteItemDatum.setSiteItem(getTestModelSiteItem());
    return siteItemDatum;
  }

  protected net.rlviana.pricegrabber.domain.entity.core.Site getTestDomainSite() {
    net.rlviana.pricegrabber.domain.entity.core.Site site =
        new net.rlviana.pricegrabber.domain.entity.core.Site();
    site.setId(1L);
    site.setName("name");
    site.setUrl("url");
    site.setDescription("description");
    site.setBaseCurrency(getTestDomainCurrency());
    site.setCountry(getTestDomainCountry());
    // site.setPromotions(promotions);
    // site.setSiteItems(siteItems);
    return site;
  }

  protected Site getTestModelSite() {
    Site site = new Site();
    site.setId(1L);
    site.setName("name");
    site.setUrl("url");
    site.setCurrency(getTestModelCurrency());
    site.setDescription("description");
    site.setCountry(getTestModelCountry());
    // site.setPromotions(promotions);
    // site.setSiteItems(siteItems);
    return site;
  }

  protected abstract V getDomainObject();

  protected abstract T getModelObject();

  protected abstract Class<V> getDomainObjectClass();

  protected abstract Class<T> getModelObjectClass();

  /**
   * @return the converter
   */
  @SuppressWarnings("unchecked")
  public BaseConverter<T, V> getConverter() {
    synchronized (this) {
      if (converter == null) {
        converter = new BaseConverter(mapper, getModelObjectClass(), getDomainObjectClass());
      }
    }
    return converter;
  }

}
