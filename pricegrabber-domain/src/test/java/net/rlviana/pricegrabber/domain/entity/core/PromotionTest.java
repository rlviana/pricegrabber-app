/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.core;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class PromotionTest extends AbstractEntityTest<Promotion> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected Promotion getEntityOK() {
    return getTestPromotion();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected Promotion getEntityKO() {
    Promotion promotion = new Promotion();
    return promotion;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<Promotion> getDomainEntityType() {
    return Promotion.class;
  }

}
