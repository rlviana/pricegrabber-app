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
public class DateXmlAdapterTest {

  protected static final String VALUE_STRING = "2014-03-03";
  protected static final String VALUE_STRING_KO = "201413-03";

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

  protected DateXmlAdapter getAdapter() {
    return new DateXmlAdapter();
  }

  private Date getDate(final Date date) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR, 0); // 12 hour clock
    calendar.set(Calendar.HOUR_OF_DAY, 0); // 24 hour clock
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  private Date getDateFromString(final String date) throws ParseException {
    SimpleDateFormat format = new SimpleDateFormat(DateXmlAdapter.PATTERN);
    return format.parse(date);
  }
}
