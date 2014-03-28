/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.common;

import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
    StringWriter stringWriter = new StringWriter();
    getMarshaller().marshal(getEntityOK(), stringWriter);
    LOGGER.debug("XML:{}", stringWriter.toString());
  }

  @Test
  public void testUnmarshallXml() throws JAXBException {
    getUnmarshaller().unmarshal(new InputSource(new java.io.StringReader(getEntityXML(getEntityOK()))));
  }

  @Test
  public void testMarshallJson() throws JsonGenerationException, JsonMappingException, IOException {
    StringWriter stringWriter = new StringWriter();
    mapper.writeValue(stringWriter, getEntityOK());
    LOGGER.debug("JSON:{}", stringWriter.toString());
  }

  @Test
  public void testUnmarshallJson() throws JsonParseException, JsonMappingException, IOException, JAXBException {
    mapper.readValue(getEntityJSON(getEntityOK()), getDomainEntityType());
  }

  @Test
  public void testMarshallXmlKO() throws JAXBException {
    StringWriter stringWriter = new StringWriter();
    getMarshaller().marshal(getEntityOK(), stringWriter);
    LOGGER.debug("XML:{}", stringWriter.toString());
  }

  @Test
  public void testUnmarshallXmKOl() throws JAXBException {
    getUnmarshaller().unmarshal(new InputSource(new java.io.StringReader(getEntityXML(getEntityOK()))));
  }

  @Test
  public void testMarshallJsonKO() throws JsonGenerationException, JsonMappingException, IOException {
    StringWriter stringWriter = new StringWriter();
    mapper.writeValue(stringWriter, getEntityOK());
    LOGGER.debug("JSON:{}", stringWriter.toString());
  }

  @Test
  public void testUnmarshallJsonKO() throws JsonParseException, JsonMappingException, IOException, JAXBException {
    mapper.readValue(getEntityJSON(getEntityOK()), getDomainEntityType());
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

  protected abstract Class<T> getDomainEntityType();
}