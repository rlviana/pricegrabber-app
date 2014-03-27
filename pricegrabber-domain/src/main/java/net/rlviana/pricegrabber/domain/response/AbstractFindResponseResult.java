package net.rlviana.pricegrabber.domain.response;

import java.util.List;
import javax.xml.bind.annotation.XmlTransient;
import net.rlviana.pricegrabber.domain.entity.EntityBase;

/**
 * Abstract find entities result.
 * 
 * @author ramon
 */
@XmlTransient
public abstract class AbstractFindResponseResult extends AbstractResponse implements IEntityFindResponseResult {

  /**
   * @return list of entities
   * @see net.rlviana.pricegrabber.domain.response.IEntityFindResult#getResults()
   */
  @Override
  public abstract List<? extends EntityBase> getResults();
}
