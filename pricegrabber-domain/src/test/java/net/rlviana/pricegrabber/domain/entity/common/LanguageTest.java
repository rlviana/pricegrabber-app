/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.common;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class LanguageTest extends AbstractEntityTest<Language> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected Language getEntityOK() {
    Language language = new Language();
    language.setCod("cod");
    language.setCode("code");
    language.setName("name");
    return language;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected Language getEntityKO() {
    Language language = new Language();
    return language;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<Language> getDomainEntityType() {
    return Language.class;
  }

}
