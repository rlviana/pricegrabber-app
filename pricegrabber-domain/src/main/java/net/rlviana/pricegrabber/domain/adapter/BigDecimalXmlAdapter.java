/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.domain.adapter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * XML converter for String -> BigDecimals
 * 
 * @author ramon
 */
public class BigDecimalXmlAdapter extends XmlAdapter<String, BigDecimal> {

  public static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * @param value
   * @return
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
   */
  @Override
  public BigDecimal unmarshal(final String value) {
    // TODO Take into account xml vs system format
    df.setParseBigDecimal(true);
    try {
      return (BigDecimal) df.parse(value);
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * @param value
   * @return
   * @throws Exception
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
   */
  @Override
  public String marshal(final BigDecimal value) throws Exception {
    // TODO Take into account xml vs system format
    return df.format(value);
  }

}
