/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Util class for transformations
 * 
 * @author ramon
 */
public class CodeUtil {

  private static final Map<String, Locale> COUNTRY_TO_LOCALE_MAP = new HashMap<String, Locale>();

  private static final CodeUtil INSTANCE = new CodeUtil();

  static {
    Locale[] locales = Locale.getAvailableLocales();
    for (Locale locale : locales) {
      COUNTRY_TO_LOCALE_MAP.put(locale.getCountry(), locale);
    }
  }

  public static final CodeUtil getCodeUtil() {
    return INSTANCE;
  }

  /**
   * Returns locale for given countryCod
   * 
   * @param countryCod
   * @return
   */
  public Locale getLocaleFromCountry(final String countryCod) {
    return COUNTRY_TO_LOCALE_MAP.get(countryCod);
  }
}
