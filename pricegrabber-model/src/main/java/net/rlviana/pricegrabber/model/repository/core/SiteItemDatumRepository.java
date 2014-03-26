/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.core;

import net.rlviana.pricegrabber.model.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.model.repository.AbstractJpaObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.core.SiteItemDatumSearchCriteria;

/**
 * JPA Repository Implementation for SiteItemDatum Entity
 * 
 * @author ramon
 * 
 */
public class SiteItemDatumRepository extends AbstractJpaObjectRepository<SiteItemDatum, Long> {

  /**
   * Constructor
   */
  public SiteItemDatumRepository() {
    super(SiteItemDatum.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected SiteItemDatumSearchCriteria getCriteriaAll() {
    return new SiteItemDatumSearchCriteria();
  }

}
