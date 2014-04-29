package net.rlviana.pricegrabber.ws.service.siteItemDatum;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.domain.response.core.SiteItemDatumResponse;
import net.rlviana.pricegrabber.ws.service.exception.ServiceException;

@WebService(portName = "SiteItemDatumPort", serviceName = "SiteItemDatumService",
    targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItemDatum")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class SiteItemDatumPortTypeImpl
    implements SiteItemDatumPortType
{

  public SiteItemDatumPortTypeImpl() {
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItemDatum.SiteItemDatumPortType#listSiteItemDatums(net.rlviana.pricegrabber.ws.service.siteItemDatum.ListSiteItemData)
   */
  @Override
  public ListSiteItemDataResponse listSiteItemDatums(ListSiteItemData parameters) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItemDatum.SiteItemDatumPortType#createSiteItemDatum(net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum)
   */
  @Override
  public SiteItemDatumResponse createSiteItemDatum(SiteItemDatum siteItemDatum) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItemDatum.SiteItemDatumPortType#findSiteItemDatumById(java.lang.Long)
   */
  @Override
  public SiteItemDatumResponse findSiteItemDatumById(Long siteItemDatumId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItemDatum.SiteItemDatumPortType#searchSiteItemDatums(net.rlviana.pricegrabber.ws.service.siteItemDatum.SearchSiteItemData)
   */
  @Override
  public SearchSiteItemDataResponse searchSiteItemDatums(SearchSiteItemData parameters) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItemDatum.SiteItemDatumPortType#deleteSiteItemDatum(java.lang.Long)
   */
  @Override
  public SiteItemDatumResponse deleteSiteItemDatum(Long siteItemDatumId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteItemDatum.SiteItemDatumPortType#updateSiteItemDatum(net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum)
   */
  @Override
  public SiteItemDatumResponse updateSiteItemDatum(SiteItemDatum siteItemDatum) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

}
