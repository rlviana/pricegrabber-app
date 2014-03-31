package net.rlviana.pricegrabber.converter.service.core;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.core.Promotion;

import org.dozer.Mapper;

/**
 * Converter for promotion
 * 
 * @author ramon
 * 
 */
public class PromotionConverter
    extends
    BaseConverter<Promotion, net.rlviana.pricegrabber.domain.entity.core.Promotion> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected PromotionConverter(Mapper mapper) {
    super(mapper, Promotion.class, net.rlviana.pricegrabber.domain.entity.core.Promotion.class);
  }

}
