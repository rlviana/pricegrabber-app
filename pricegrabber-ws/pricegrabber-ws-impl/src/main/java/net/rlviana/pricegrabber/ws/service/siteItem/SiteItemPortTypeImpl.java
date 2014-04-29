package net.rlviana.pricegrabber.ws.service.siteItem;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.rlviana.pricegrabber.domain.entity.core.SiteItem;
import net.rlviana.pricegrabber.domain.response.core.SiteItemFindResponse;
import net.rlviana.pricegrabber.domain.response.core.SiteItemResponse;
import net.rlviana.pricegrabber.domain.search.core.SiteItemSearchCriteria;
import net.rlviana.pricegrabber.ws.service.exception.ServiceException;

@WebService(portName = "SiteItemPort", serviceName = "SiteItemService",
    targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class SiteItemPortTypeImpl
    implements SiteItemPortType
{

  public SiteItemPortTypeImpl() {
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItem.SiteItemPortType#listSiteItems(net.rlviana.pricegrabber.domain.search.core.SiteItemSearchCriteria)
   */
  @Override
  public SiteItemFindResponse listSiteItems(SiteItemSearchCriteria criteria) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItem.SiteItemPortType#searchSiteItems(net.rlviana.pricegrabber.domain.search.core.SiteItemSearchCriteria)
   */
  @Override
  public SiteItemFindResponse searchSiteItems(SiteItemSearchCriteria criteria) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItem.SiteItemPortType#findSiteItemById(java.lang.Long)
   */
  @Override
  public SiteItemResponse findSiteItemById(Long siteItemId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItem.SiteItemPortType#updateSiteItem(net.rlviana.pricegrabber.domain.entity.core.SiteItem)
   */
  @Override
  public SiteItemResponse updateSiteItem(SiteItem siteItem) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItem.SiteItemPortType#createSiteItem(net.rlviana.pricegrabber.domain.entity.core.SiteItem)
   */
  @Override
  public SiteItemResponse createSiteItem(SiteItem siteItem) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItem.SiteItemPortType#deleteSiteItem(java.lang.Long)
   */
  @Override
  public SiteItemResponse deleteSiteItem(Long siteItemId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

}
