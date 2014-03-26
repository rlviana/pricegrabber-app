/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.core;

import net.rlviana.pricegrabber.model.entity.core.Site;
import net.rlviana.pricegrabber.model.repository.AbstractJpaObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.core.SiteSearchCriteria;

/**
 * JPA Repository Implementation for Site Entity
 * 
 * @author ramon
 * 
 */
public class SiteRepository extends AbstractJpaObjectRepository<Site, Long> {

  /**
   * Constructor
   */
  public SiteRepository() {
    super(Site.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected SiteSearchCriteria getCriteriaAll() {
    return new SiteSearchCriteria();
  }

}
