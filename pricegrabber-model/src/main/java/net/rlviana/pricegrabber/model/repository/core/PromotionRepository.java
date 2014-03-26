/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.core;

import net.rlviana.pricegrabber.model.entity.core.Promotion;
import net.rlviana.pricegrabber.model.repository.AbstractJpaObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.core.PromotionSearchCriteria;

/**
 * JPA Repository Implementation for Promotion Entity
 * 
 * @author ramon
 * 
 */
public class PromotionRepository extends AbstractJpaObjectRepository<Promotion, Long> {

  /**
   * Constructor
   */
  public PromotionRepository() {
    super(Promotion.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected PromotionSearchCriteria getCriteriaAll() {
    return new PromotionSearchCriteria();
  }

}
