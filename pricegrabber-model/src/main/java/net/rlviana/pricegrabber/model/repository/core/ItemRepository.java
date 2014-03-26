/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.core;

import net.rlviana.pricegrabber.model.entity.core.Item;
import net.rlviana.pricegrabber.model.repository.AbstractJpaObjectRepository;
import net.rlviana.pricegrabber.model.search.entity.core.ItemSearchCriteria;

/**
 * JPA Repository Implementation for Item Entity
 * 
 * @author ramon
 * 
 */
public class ItemRepository extends AbstractJpaObjectRepository<Item, Long> {

  /**
   * Constructor
   */
  public ItemRepository() {
    super(Item.class);
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractBaseJpaReadOnlyObjectRepository#getCriteriaAll()
   */
  @Override
  protected ItemSearchCriteria getCriteriaAll() {
    return new ItemSearchCriteria();
  }

}
