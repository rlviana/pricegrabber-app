/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.common;

import net.rlviana.pricegrabber.model.entity.common.Language;
import net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.common.LanguageSearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ramon
 * 
 */
public class LanguageRepositoryIT extends AbstractReadOnlyRepositoryIT<Language, String> {

  protected static final String OK_KEY = "ES";
  protected static final String KO_KEY = "SE";

  private LanguageRepository repository;

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected LanguageSearchCriteria getCriteria() {
    LanguageSearchCriteria criteria = getCriteriaEmpty();
    criteria.setId(OK_KEY);
    criteria.setIdLike(OK_KEY);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected LanguageSearchCriteria getCriteriaEmpty() {
    return new LanguageSearchCriteria();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyOK()
   */
  @Override
  protected String getKeyOK() {
    return OK_KEY;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyKO()
   */
  @Override
  protected String getKeyKO() {
    return KO_KEY;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getRepository()
   */
  @Override
  protected LanguageRepository getRepository() {
    return repository;
  }

  @Autowired
  protected void setRepository(LanguageRepository repository) {
    this.repository = repository;
  }

}
