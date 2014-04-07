package net.rlviana.pricegrabber.domain.response;

import net.rlviana.pricegrabber.domain.entity.EntityBase;

/**
 * Entity result interface.
 * 
 * @author ramon
 */
public interface IEntityResult {

  /**
   * To implement
   * 
   * @return single entity result
   */
  <T extends EntityBase> T getResults();

}
