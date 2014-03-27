package net.rlviana.pricegrabber.domain.response;

import javax.xml.bind.annotation.XmlTransient;
import net.rlviana.pricegrabber.domain.entity.EntityBase;

/**
 * Abstract entity result.
 * 
 * @author ramon
 */
@XmlTransient
public abstract class AbstractResponseResult extends AbstractResponse implements IEntityResponseResult {

  /**
   * @return result object
   * @see net.rlviana.pricegrabber.domain.response.IEntityResult#getResults()
   */
  @Override
  public abstract <T extends EntityBase> T getResults();

}