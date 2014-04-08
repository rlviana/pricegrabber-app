/*
 * (C) 2013, Ramon Lopez Viana
 *
 */
package net.rlviana.pricegrabber.model.entity.core;

/**
 * Enum representing types
 * 
 * @author ramon
 */
public enum PriceType {

  REGULAR_PRICE(1),
  SPECIAL_PRICE(2),
  DISCOUNT_PRICE(3);

  private int value;

  /**
   * Constructor private
   * 
   * @param value
   */
  private PriceType(final int value) {
    this.value = value;
  }

  /**
   * @return int value for enum
   */
  public int getValue() {
    return value;
  }

  /**
   * @param id
   * @return obtained enum for given id
   */
  public static PriceType parse(final int id) {
    PriceType right = null; // Default
    for (PriceType item : PriceType.values()) {
      if (item.getValue() == id) {
        right = item;
        break;
      }
    }
    return right;
  }

}
