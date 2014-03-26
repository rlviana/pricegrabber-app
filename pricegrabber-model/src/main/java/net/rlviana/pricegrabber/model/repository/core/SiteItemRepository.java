/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.core;

import net.rlviana.pricegrabber.model.entity.core.SiteItem;
import net.rlviana.pricegrabber.model.repository.AbstractJpaObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.core.SiteItemSearchCriteria;

/**
 * JPA Repository Implementation for SiteItem Entity
 * 
 * @author ramon
 * 
 */
public class SiteItemRepository extends AbstractJpaObjectRepository<SiteItem, Long> {

  /**
   * Constructor
   */
  public SiteItemRepository() {
    super(SiteItem.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected SiteItemSearchCriteria getCriteriaAll() {
    return new SiteItemSearchCriteria();
  }

}
