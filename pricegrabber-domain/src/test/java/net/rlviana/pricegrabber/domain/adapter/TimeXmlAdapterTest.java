/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.adapter;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ramon
 */
public class TimeXmlAdapterTest {

  protected static final String VALUE_STRING = "10:00:00";
  protected static final String VALUE_STRING_KO = "2014-13-03";

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
    assertEquals(getAdapter().marshal(getDate(getDateFromString(VALUE_STRING))), VALUE_STRING);
  }

  @Test
  public void testUnmarshallOK() throws ParseException {
    assertEquals(getAdapter().unmarshal(VALUE_STRING), getDate(getDateFromString(VALUE_STRING)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUnmarshallKO() throws Exception {
    System.out.println(getAdapter().unmarshal(VALUE_STRING_KO));
  }

  protected TimeXmlAdapter getAdapter() {
    return new TimeXmlAdapter();
  }

  private Date getDate(final Date date) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    return calendar.getTime();
  }

  private Date getDateFromString(final String date) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat(TimeXmlAdapter.PATTERN);
    return format.parse(date);
  }
}
