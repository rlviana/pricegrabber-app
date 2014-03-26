/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.common;

import net.rlviana.pricegrabber.model.entity.common.Language;
import net.rlviana.pricegrabber.model.repository.AbstractJpaReadOnlyObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.common.LanguageSearchCriteria;

/**
 * JPA Repository Implementation for Language Entity
 * 
 * @author ramon
 * 
 */
public class LanguageRepository extends AbstractJpaReadOnlyObjectRepository<Language, String> {

  /**
   * Constructor
   */
  public LanguageRepository() {
    super(Language.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected LanguageSearchCriteria getCriteriaAll() {
    return new LanguageSearchCriteria();
  }

}
