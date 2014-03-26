/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.common;

import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.repository.AbstractJpaReadOnlyObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.common.CurrencySearchCriteria;

/**
 * JPA Repository Implementation for Currency Entity
 * 
 * @author ramon
 * 
 */
public class CurrencyRepository extends AbstractJpaReadOnlyObjectRepository<Currency, String> {

  /**
   * Constructor
   */
  public CurrencyRepository() {
    super(Currency.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected CurrencySearchCriteria getCriteriaAll() {
    return new CurrencySearchCriteria();
  }

}
