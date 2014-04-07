/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.domain.adapter;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * XML converter for String -> BigDecimals
 * 
 * @author ramon
 */
public class BigDecimalXmlAdapter extends XmlAdapter<String, BigDecimal> {

  /**
   * @param value
   * @return
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
   */
  @Override
  public BigDecimal unmarshal(final String value) {
    return new BigDecimal(value);
  }

  /**
   * @param value
   * @return
   * @throws Exception
   * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
   */
  @Override
  public String marshal(final BigDecimal value) throws Exception {
    if (value != null)
    {
      return value.toString();
    }
    return null;
  }

}
