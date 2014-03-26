/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.common;

import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.repository.AbstractJpaReadOnlyObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.common.CountrySearchCriteria;

/**
 * JPA Repository Implementation for Country Entity
 * 
 * @author ramon
 * 
 */
public class CountryRepository extends AbstractJpaReadOnlyObjectRepository<Country, String> {

  /**
   * Constructor
   */
  public CountryRepository() {
    super(Country.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected CountrySearchCriteria getCriteriaAll() {
    return new CountrySearchCriteria();
  }

}
