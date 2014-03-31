package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.common.Currency;

import org.dozer.Mapper;

/**
 * Converter for currency
 * 
 * @author ramon
 * 
 */
public class CurrencyConverter
    extends
    BaseConverter<Currency, net.rlviana.pricegrabber.domain.entity.common.Currency> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected CurrencyConverter(Mapper mapper) {
    super(mapper, Currency.class, net.rlviana.pricegrabber.domain.entity.common.Currency.class);
  }

}
