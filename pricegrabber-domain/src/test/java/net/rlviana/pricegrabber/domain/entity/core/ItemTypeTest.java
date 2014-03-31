/*
 * Created on 03/03/2014
 *
 */
package net.rlviana.pricegrabber.domain.entity.core;

import net.rlviana.pricegrabber.domain.entity.AbstractEntityTest;

/**
 * @author ramon
 */
public class ItemTypeTest extends AbstractEntityTest<ItemType> {

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityOK()
   */
  @Override
  protected ItemType getEntityOK() {
    return getTestItemType();
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getEntityKO()
   */
  @Override
  protected ItemType getEntityKO() {
    ItemType itemType = new ItemType();
    return itemType;
  }

  /**
   * @return
   * @see net.rlviana.pricegrabber.domain.entity.AbstractEntityTest#getDomainEntityType()
   */
  @Override
  protected Class<ItemType> getDomainEntityType() {
    return ItemType.class;
  }

}
