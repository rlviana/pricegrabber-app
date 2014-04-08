package net.rlviana.pricegrabber.converter.custom;

import net.rlviana.pricegrabber.model.entity.core.PriceType;

/**
 * @author ramon
 * 
 */
public class PriceTypeConverter
    extends
    AbstractConverter<PriceType, net.rlviana.pricegrabber.domain.entity.core.PriceType> {

  /**
   * Constructor
   * 
   * @param sourceClass
   * @param destinationClass
   */
  public PriceTypeConverter() {
    super(PriceType.class, net.rlviana.pricegrabber.domain.entity.core.PriceType.class);
  }

  /**
   * 
   * @see org.dozer.DozerConverter#convertFrom(java.lang.Object, java.lang.Object)
   */
  @Override
  public net.rlviana.pricegrabber.domain.entity.core.PriceType convertTo(final PriceType source,
      final net.rlviana.pricegrabber.domain.entity.core.PriceType destination) {

    net.rlviana.pricegrabber.domain.entity.core.PriceType result =
        null;
    if (source != null) {
      switch (source) {
      case REGULAR_PRICE:
        result = net.rlviana.pricegrabber.domain.entity.core.PriceType.REGULAR_PRICE;
        break;
      case SPECIAL_PRICE:
        result = net.rlviana.pricegrabber.domain.entity.core.PriceType.SPECIAL_PRICE;
        break;
      case DISCOUNT_PRICE:
        result = net.rlviana.pricegrabber.domain.entity.core.PriceType.DISCOUNT_PRICE;
        break;
      default:
        break;
      }
    }
    return result;
  }

  /**
   * 
   * @see org.dozer.DozerConverter#convertTo(java.lang.Object, java.lang.Object)
   */
  @Override
  public PriceType convertFrom(final net.rlviana.pricegrabber.domain.entity.core.PriceType source,
      final PriceType destination) {
    PriceType result = null;
    if (source != null) {
      switch (source) {
      case REGULAR_PRICE:
        result = PriceType.REGULAR_PRICE;
        break;
      case SPECIAL_PRICE:
        result = PriceType.SPECIAL_PRICE;
        break;
      case DISCOUNT_PRICE:
        result = PriceType.DISCOUNT_PRICE;
        break;
      default:
        break;

      }
    }
    return result;
  }
}
