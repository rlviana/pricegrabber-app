package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.ConverterTest;
import net.rlviana.pricegrabber.model.entity.common.Language;

/**
 * @author ramon
 * 
 */
public class LanguageConverterTest
    extends
    ConverterTest<Language, net.rlviana.pricegrabber.domain.entity.common.Language> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.common.Language getDomainObject() {
    return getTestDomainLanguage();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObject()
   */

  @Override
  protected Language getModelObject() {
    return getTestModelLanguage();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.common.Language> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.common.Language.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.ConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Language> getModelObjectClass() {
    return Language.class;
  }

}
