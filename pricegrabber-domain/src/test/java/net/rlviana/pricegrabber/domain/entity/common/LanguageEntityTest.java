/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.common;

/**
 * @author ramon
 */
public class LanguageEntityTest extends AbstractEntityTest<Language> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.common.AbstractEntityTest#getEntityOK()
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
   * @see net.rlviana.pricegrabber.domain.entity.common.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected Language getEntityKO() {
    Language language = new Language();
    return language;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.common.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<Language> getDomainEntityType() {
    return Language.class;
  }

}
