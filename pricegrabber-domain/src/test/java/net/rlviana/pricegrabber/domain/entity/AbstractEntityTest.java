/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.rlviana.pricegrabber.domain.entity.common.Country;
import net.rlviana.pricegrabber.domain.entity.common.Currency;
import net.rlviana.pricegrabber.domain.entity.core.Item;
import net.rlviana.pricegrabber.domain.entity.core.ItemType;
import net.rlviana.pricegrabber.domain.entity.core.Promotion;
import net.rlviana.pricegrabber.domain.entity.core.Site;
import net.rlviana.pricegrabber.domain.entity.core.SiteItem;
import net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.domain.entity.core.SiteItemPrice;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ramon
 * @param <T> Domain entity under test
 */
public abstract class AbstractEntityTest<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEntityTest.class);

  private JAXBContext instance = null;

  private ObjectMapper mapper;

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
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
    if (instance == null) {
      instance = JAXBContext.newInstance(getDomainEntityType());
    }
    if (mapper == null) {
      mapper = new ObjectMapper();
    }
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testMarshallXml() throws JAXBException {
    String entityOK = ToStringBuilder.reflectionToString(getEntityOK(), ToStringStyle.SHORT_PREFIX_STYLE);
    LOGGER.trace("entityOK->{}", entityOK);
    StringWriter stringWriter = new StringWriter();
    getMarshaller().marshal(getEntityOK(), stringWriter);
    LOGGER.trace("xml->{}", stringWriter.toString());
    String result =
        ToStringBuilder.reflectionToString(getUnmarshaller().unmarshal(new StringReader(stringWriter.toString())),
            ToStringStyle.SHORT_PREFIX_STYLE);
    LOGGER.trace("result->{}", result);
    // assertEquals(result, entityOK);

  }

  @Test
  public void testUnmarshallXml() throws JAXBException {
    String entityOK = ToStringBuilder.reflectionToString(getEntityOK(), ToStringStyle.SHORT_PREFIX_STYLE);
    Object resultEntity =
        getUnmarshaller().unmarshal(new InputSource(new java.io.StringReader(getEntityXML(getEntityOK()))));
    String result = ToStringBuilder.reflectionToString(resultEntity, ToStringStyle.SHORT_PREFIX_STYLE);
    // assertEquals(result, entityOK);

  }

  @Test
  public void testMarshallJson() throws JsonGenerationException, JsonMappingException, IOException {
    String entityOK = ToStringBuilder.reflectionToString(getEntityOK(), ToStringStyle.SHORT_PREFIX_STYLE);
    StringWriter stringWriter = new StringWriter();
    mapper.writeValue(stringWriter, getEntityOK());
    String result =
        ToStringBuilder.reflectionToString(mapper.readValue(stringWriter.toString(),
            getDomainEntityType()),
            ToStringStyle.SHORT_PREFIX_STYLE);
    // assertEquals(result, entityOK);
  }

  @Test
  public void testUnmarshallJson() throws JsonParseException, JsonMappingException, IOException, JAXBException {
    String entityOK = ToStringBuilder.reflectionToString(getEntityOK(), ToStringStyle.SHORT_PREFIX_STYLE);
    T resultEntity = mapper.readValue(getEntityJSON(getEntityOK()), getDomainEntityType());
    String result = ToStringBuilder.reflectionToString(resultEntity, ToStringStyle.SHORT_PREFIX_STYLE);
    // assertEquals(result, entityOK);
  }

  protected Marshaller getMarshaller() throws JAXBException {
    Marshaller marshaller = instance.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
    return marshaller;
  }

  protected Unmarshaller getUnmarshaller() throws JAXBException {
    Unmarshaller unmarshaller = instance.createUnmarshaller();
    return unmarshaller;
  }

  protected abstract T getEntityOK();

  protected abstract T getEntityKO();

  protected String getEntityJSON(T entity) throws JsonGenerationException, JsonMappingException, IOException {
    StringWriter stringWriter = new StringWriter();
    mapper.writeValue(stringWriter, entity);
    return stringWriter.toString();

  }

  protected String getEntityXML(T entity) throws JAXBException {
    StringWriter stringWriter = new StringWriter();
    getMarshaller().marshal(entity, stringWriter);
    return stringWriter.toString();
  }

  /**
   * @return
   */
  protected ItemType getTestItemType() {
    ItemType itemType = new ItemType();
    itemType.setCode("code");
    itemType.setName("name");
    itemType.setId(1L);
    return itemType;
  }

  /**
   * @return
   */
  protected SiteItem getTestSiteItem() {
    SiteItem siteItem = new SiteItem();
    siteItem.setId(1L);
    siteItem.setUrl("url");
    siteItem.setName("name");
    siteItem.setSiteCod("siteCod");
    siteItem.setItemType(getTestItemType());
    siteItem.setCurrentPrice(getTestPrice());
    return siteItem;
  }

  /**
   * @return
   */
  private SiteItemPrice getTestPrice() {
    SiteItemPrice price = new SiteItemPrice();
    price.setPriceCurrency(getTestCurrency());
    price.setPriceDate(Calendar.getInstance());
    price.setPriceValue(BigDecimal.valueOf(10.1));
    return price;
  }

  /**
   * @return
   */
  protected Currency getTestCurrency() {
    Currency currency = new Currency();
    currency.setCod("cod");
    currency.setCode("code");
    currency.setName("name");
    return currency;
  }

  protected Promotion getTestPromotion() {
    Promotion promotion = new Promotion();
    promotion.setId(1L);
    promotion.setName("name");
    promotion.setDescription("description");
    promotion.setUrl("url");
    promotion.setBeginDate(Calendar.getInstance());
    promotion.setEndDate(Calendar.getInstance());
    promotion.setActive(Boolean.FALSE);
    promotion.getSiteItems().add(getTestSiteItem());
    return promotion;
  }

  /**
   * @return
   */
  protected Item getTestItem() {
    Item item = new Item();
    item.setId(1L);
    item.setName("name");
    item.setDescription("description");
    item.setItemType(getTestItemType());
    return item;
  }

  /**
   * @return
   */
  protected Site getTestSite() {
    Site site = new Site();
    site.setCountry(getTestCountry());
    site.setBaseCurrrency(getTestCurrency());
    site.setDescription("description");
    site.setId(1L);
    site.getPromotions().add(getTestPromotion());
    site.getSiteItems().add(getTestSiteItem());
    return site;
  }

  /**
   * @return
   */
  protected Country getTestCountry() {
    Country country = new Country();
    country.setCod("cod");
    country.setCode("code");
    country.setName("name");
    return country;
  }

  /**
   * @return
   */
  protected SiteItemDatum getTestSiteItemDatum() {
    SiteItemDatum siteItemDatum = new SiteItemDatum();
    siteItemDatum.setId(1L);
    siteItemDatum.setPriceCurrency(getTestCurrency());
    siteItemDatum.setPriceDate(Calendar.getInstance());
    siteItemDatum.setPriceValue(BigDecimal.valueOf(10.1));
    siteItemDatum.setSiteItem(getTestSiteItem());
    return siteItemDatum;

  }

  protected abstract Class<T> getDomainEntityType();
}
