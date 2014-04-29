package net.rlviana.pricegrabber.ws.service.siteItem;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import net.rlviana.pricegrabber.domain.entity.core.SiteItem;
import net.rlviana.pricegrabber.domain.response.core.SiteItemFindResponse;
import net.rlviana.pricegrabber.domain.response.core.SiteItemResponse;
import net.rlviana.pricegrabber.domain.search.core.SiteItemSearchCriteria;
import net.rlviana.pricegrabber.ws.service.exception.ServiceException;

/**
 * WebService definition
 * 
 * @author ramon
 * 
 */
@WebService(name = "SiteItemPortType", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SiteItemPortType {

  /**
   * 
   * @param criteria
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.SiteItemFindResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/siteItem/listSiteItems")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
  @RequestWrapper(localName = "listSiteItems", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.ListSiteItems")
  @ResponseWrapper(localName = "listSiteItemsResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.ListSiteItemsResponse")
  public
      SiteItemFindResponse
      listSiteItems(
          @WebParam(name = "criteria", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem") SiteItemSearchCriteria criteria) throws ServiceException;

  /**
   * 
   * @param siteItemId
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.SiteItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/siteItem/deleteSiteItem")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
  @RequestWrapper(localName = "deleteSiteItem",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.DeleteSiteItem")
  @ResponseWrapper(localName = "deleteSiteItemResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.DeleteSiteItemResponse")
  public
      SiteItemResponse
      deleteSiteItem(
          @WebParam(name = "siteItemId", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem") Long siteItemId) throws ServiceException;

  /**
   * 
   * @param criteria
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.SiteItemFindResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/siteItem/searchSiteItems")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
  @RequestWrapper(localName = "searchSiteItems",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.SearchSiteItems")
  @ResponseWrapper(localName = "searchSiteItemsResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.SearchSiteItemsResponse")
  public
      SiteItemFindResponse
      searchSiteItems(
          @WebParam(name = "criteria", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem") SiteItemSearchCriteria criteria) throws ServiceException;

  /**
   * 
   * @param siteItem
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.SiteItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/siteItem/createSiteItem")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
  @RequestWrapper(localName = "createSiteItem",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.CreateSiteItem")
  @ResponseWrapper(localName = "createSiteItemResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.CreateSiteItemResponse")
  public
      SiteItemResponse
      createSiteItem(
          @WebParam(name = "siteItem", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem") SiteItem siteItem) throws ServiceException;

  /**
   * 
   * @param siteItem
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.SiteItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/siteItem/updateSiteItem")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
  @RequestWrapper(localName = "updateSiteItem",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.UpdateSiteItem")
  @ResponseWrapper(localName = "updateSiteItemResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.UpdateSiteItemResponse")
  public
      SiteItemResponse
      updateSiteItem(
          @WebParam(name = "siteItem", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem") SiteItem siteItem) throws ServiceException;

  /**
   * 
   * @param siteItemId
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.SiteItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/siteItem/findSiteItemById")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem")
  @RequestWrapper(localName = "findSiteItemById",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.FindSiteItemById")
  @ResponseWrapper(localName = "findSiteItemByIdResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem",
      className = "net.rlviana.pricegrabber.ws.service.siteItem.FindSiteItemByIdResponse")
  public
      SiteItemResponse
      findSiteItemById(
          @WebParam(name = "siteItemId", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/siteItem") Long siteItemId) throws ServiceException;

}
