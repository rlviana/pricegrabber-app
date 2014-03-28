package net.rlviana.pricegrabber.domain.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Converts a date time <code>String</code> to a <code>Date</code> and back.
 * 
 * @author ramon
 */
public class DateTimeXmlAdapter extends XmlAdapter<String, Date> {

  public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
  private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(PATTERN);

  /**
   * @param value
   * @return
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
   */
  @Override
  public Date unmarshal(final String value) {
    try {
      return DATE_FORMATTER.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * @param value
   * @return
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
   */
  @Override
  public String marshal(final Date value) {
    return DATE_FORMATTER.format(value);
  }
}
