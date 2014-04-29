package net.rlviana.pricegrabber.ws.service.promotion;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.rlviana.pricegrabber.domain.entity.core.Promotion;
import net.rlviana.pricegrabber.domain.response.core.PromotionFindResponse;
import net.rlviana.pricegrabber.domain.response.core.PromotionResponse;
import net.rlviana.pricegrabber.domain.search.core.PromotionSearchCriteria;
import net.rlviana.pricegrabber.ws.service.exception.ServiceException;

@WebService(portName = "PromotionPort", serviceName = "PromotionService",
    targetNamespace = "http://pricegrabber.rlviana.net/ws/service/promotion",
    endpointInterface = "net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class PromotionPortTypeImpl
    implements PromotionPortType
{

  public PromotionPortTypeImpl() {
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType#updatePromotion(net.rlviana.pricegrabber.domain.entity.core.Promotion)
   */
  @Override
  public PromotionResponse updatePromotion(Promotion promotion) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType#findPromotionById(java.lang.Long)
   */
  @Override
  public PromotionResponse findPromotionById(Long promotionId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType#deletePromotion(java.lang.Long)
   */
  @Override
  public PromotionResponse deletePromotion(Long promotionId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType#createPromotion(net.rlviana.pricegrabber.domain.entity.core.Promotion)
   */
  @Override
  public PromotionResponse createPromotion(Promotion promotion) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType#listPromotions(net.rlviana.pricegrabber.domain.search.core.PromotionSearchCriteria)
   */
  @Override
  public PromotionFindResponse listPromotions(PromotionSearchCriteria criteria) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.promotion.PromotionPortType#searchPromotions(net.rlviana.pricegrabber.domain.search.core.PromotionSearchCriteria)
   */
  @Override
  public PromotionFindResponse searchPromotions(PromotionSearchCriteria criteria) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

}
