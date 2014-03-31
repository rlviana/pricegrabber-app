/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.core;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class ItemTest extends AbstractEntityTest<Item> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected Item getEntityOK() {
    return getTestItem();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected Item getEntityKO() {
    Item item = new Item();
    return item;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<Item> getDomainEntityType() {
    return Item.class;
  }

}
