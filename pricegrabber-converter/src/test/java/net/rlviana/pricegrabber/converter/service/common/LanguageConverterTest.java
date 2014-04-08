package net.rlviana.pricegrabber.converter.service.common;

import net.rlviana.pricegrabber.converter.service.AbstractConverterTest;
import net.rlviana.pricegrabber.model.entity.common.Language;

/**
 * @author ramon
 * 
 */
public class LanguageConverterTest
    extends
    AbstractConverterTest<Language, net.rlviana.pricegrabber.domain.entity.common.Language> {

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObject()
   */
  @Override
  protected net.rlviana.pricegrabber.domain.entity.common.Language getDomainObject() {
    return getTestDomainLanguage();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObject()
   */

  @Override
  protected Language getModelObject() {
    return getTestModelLanguage();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getDomainObjectClass()
   */
  @Override
  protected Class<net.rlviana.pricegrabber.domain.entity.common.Language> getDomainObjectClass() {
    return net.rlviana.pricegrabber.domain.entity.common.Language.class;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.converter.service.AbstractConverterTest#getModelObjectClass()
   */
  @Override
  protected Class<Language> getModelObjectClass() {
    return Language.class;
  }

}
