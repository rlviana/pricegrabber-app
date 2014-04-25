package net.rlviana.pricegrabber.ws.service.site;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.rlviana.pricegrabber.domain.entity.core.Site;
import net.rlviana.pricegrabber.domain.response.core.SiteFindResponse;
import net.rlviana.pricegrabber.domain.response.core.SiteResponse;
import net.rlviana.pricegrabber.domain.search.core.SiteSearchCriteria;

@WebService(portName = "SitePort", serviceName = "SiteService",
    targetNamespace = "http://pricegrabber.rlviana.net/ws/service/site",
    endpointInterface = "net.rlviana.pricegrabber.ws.service.site.SitePortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class SitePortTypeImpl
    implements SitePortType
{

  public SitePortTypeImpl() {
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.AbstractWSService#listSites(net.rlviana.pricegrabber.domain.search.core.SiteSearchCriteria)
   */
  @Override
  public SiteFindResponse listSites(SiteSearchCriteria criteria) {
    // replace with your impl here
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.AbstractWSService#deleteSite(java.lang.Long)
   */
  @Override
  public SiteResponse deleteSite(Long siteId) {
    // replace with your impl here
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.AbstractWSService#searchSites(net.rlviana.pricegrabber.domain.search.core.SiteSearchCriteria)
   */
  @Override
  public SiteFindResponse searchSites(SiteSearchCriteria criteria) {
    // replace with your impl here
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.AbstractWSService#createSite(net.rlviana.pricegrabber.domain.entity.core.Site)
   */
  @Override
  public SiteResponse createSite(Site site) {
    // replace with your impl here
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.AbstractWSService#updateSite(net.rlviana.pricegrabber.domain.entity.core.Site)
   */
  @Override
  public SiteResponse updateSite(Site site) {
    // replace with your impl here
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.AbstractWSService#findSiteById(java.lang.Long)
   */
  @Override
  public SiteResponse findSiteById(Long siteId) {
    // replace with your impl here
    return null;
  }

}
