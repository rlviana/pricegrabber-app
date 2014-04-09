/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.adapter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ramon
 */
public class BigDecimalXmlAdapterTest {

  protected static final BigDecimal VALUE_DECIMAL = BigDecimal.valueOf(10.10).setScale(2, BigDecimal.ROUND_HALF_UP);
  protected static final BigDecimal VALUE_DECIMAL_KO = BigDecimal.valueOf(10.101);
  protected static final String VALUE_STRING = "10.10";
  protected static final String VALUE_STRING_KO = "AAA";

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
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testMarshallOK() throws Exception {
    assertEquals(getAdapter().marshal(VALUE_DECIMAL), VALUE_STRING);
  }

  @Test
  public void testUnmarshallOK() {
    assertEquals(getAdapter().unmarshal(VALUE_STRING), VALUE_DECIMAL);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUnmarshallKO() throws Exception {
    getAdapter().unmarshal(VALUE_STRING_KO);
  }

  protected BigDecimalXmlAdapter getAdapter() {
    return new BigDecimalXmlAdapter();
  }

}
