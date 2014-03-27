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
/**
 * @author ramon
 */
public class TimeXmlAdapter extends XmlAdapter<String, Date> {

  public static final String PATTERN = "HH:mm:ss";
  private static final SimpleDateFormat formatter = new SimpleDateFormat(PATTERN);

  /**
   * @param value
   * @return
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
   */
  @Override
  public Date unmarshal(final String value) {
    try {
      return formatter.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public String marshal(final Date value) {
    return formatter.format(value);
  }
}
