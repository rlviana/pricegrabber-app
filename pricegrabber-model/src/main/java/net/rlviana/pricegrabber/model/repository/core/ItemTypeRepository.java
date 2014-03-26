/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.core;

import net.rlviana.pricegrabber.model.entity.core.ItemType;
import net.rlviana.pricegrabber.model.repository.AbstractJpaObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.core.ItemTypeSearchCriteria;

/**
 * JPA Repository Implementation for Item Type Entity
 * 
 * @author ramon
 * 
 */
public class ItemTypeRepository extends AbstractJpaObjectRepository<ItemType, Integer> {

  /**
   * Constructor
   */
  public ItemTypeRepository() {
    super(ItemType.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected ItemTypeSearchCriteria getCriteriaAll() {
    return new ItemTypeSearchCriteria();
  }

}
