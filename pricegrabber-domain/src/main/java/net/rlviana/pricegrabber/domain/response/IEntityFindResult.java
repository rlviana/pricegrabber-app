package net.rlviana.pricegrabber.domain.response;

import java.util.List;

import net.rlviana.pricegrabber.domain.entity.EntityBase;

/**
 * Entity find result interface.
 * 
 * @author ramon
 */
public interface IEntityFindResult {

  /**
   * @return entities included
   */
  List<? extends EntityBase> getResults();

  /**
   * Gets total element count. For pagination purposes
   * 
   * @return total number of elements.
   */
  long getCount();

}
