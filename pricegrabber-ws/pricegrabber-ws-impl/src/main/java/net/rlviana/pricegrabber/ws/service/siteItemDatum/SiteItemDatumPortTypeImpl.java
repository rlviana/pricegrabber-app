package net.rlviana.pricegrabber.ws.service.siteItemDatum;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum;
import net.rlviana.pricegrabber.domain.response.core.SiteItemDatumResponse;
import net.rlviana.pricegrabber.ws.service.siteitemdatum.ListSiteItemData;
import net.rlviana.pricegrabber.ws.service.siteitemdatum.ListSiteItemDataResponse;
import net.rlviana.pricegrabber.ws.service.siteitemdatum.SearchSiteItemData;
import net.rlviana.pricegrabber.ws.service.siteitemdatum.SearchSiteItemDataResponse;
import net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType;

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
   * @see net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType#listSiteItemDatums(net.rlviana.pricegrabber.ws.service.siteitemdatum.ListSiteItemData)
   */
  @Override
  public ListSiteItemDataResponse listSiteItemDatums(ListSiteItemData parameters) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType#createSiteItemDatum(net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum)
   */
  @Override
  public SiteItemDatumResponse createSiteItemDatum(SiteItemDatum siteItemDatum) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType#findSiteItemDatumById(java.lang.Long)
   */
  @Override
  public SiteItemDatumResponse findSiteItemDatumById(Long siteItemDatumId) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType#searchSiteItemDatums(net.rlviana.pricegrabber.ws.service.siteitemdatum.SearchSiteItemData)
   */
  @Override
  public SearchSiteItemDataResponse searchSiteItemDatums(SearchSiteItemData parameters) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType#deleteSiteItemDatum(java.lang.Long)
   */
  @Override
  public SiteItemDatumResponse deleteSiteItemDatum(Long siteItemDatumId) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.siteitemdatum.SiteItemDatumPortType#updateSiteItemDatum(net.rlviana.pricegrabber.domain.entity.core.SiteItemDatum)
   */
  @Override
  public SiteItemDatumResponse updateSiteItemDatum(SiteItemDatum siteItemDatum) {
    // TODO Auto-generated method stub
    return null;
  }

}
