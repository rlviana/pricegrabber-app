package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.BaseConverter;
import net.rlviana.pricegrabber.model.entity.common.Language;

import org.dozer.Mapper;

/**
 * Converter for language
 * 
 * @author ramon
 * 
 */
public class LanguageConverter
    extends
    BaseConverter<Language, net.rlviana.pricegrabber.domain.entity.common.Language> {

  /**
   * Constructor
   * 
   * @param mapper
   */
  protected LanguageConverter(Mapper mapper) {
    super(mapper, Language.class, net.rlviana.pricegrabber.domain.entity.common.Language.class);
  }

}
