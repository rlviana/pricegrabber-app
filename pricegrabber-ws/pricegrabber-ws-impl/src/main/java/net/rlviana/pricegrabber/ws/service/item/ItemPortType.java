package net.rlviana.pricegrabber.ws.service.item;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import net.rlviana.pricegrabber.domain.entity.core.Item;
import net.rlviana.pricegrabber.domain.response.core.ItemFindResponse;
import net.rlviana.pricegrabber.domain.response.core.ItemResponse;
import net.rlviana.pricegrabber.domain.search.core.ItemSearchCriteria;
import net.rlviana.pricegrabber.ws.service.exception.ServiceException;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ItemPortType", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ItemPortType {

  /**
   * 
   * @param criteria
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.ItemFindResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/listItems")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
  @RequestWrapper(localName = "listItems", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.ListItems")
  @ResponseWrapper(localName = "listItemsResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.ListItemsResponse")
  public
      ItemFindResponse
      listItems(
          @WebParam(name = "criteria", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item") ItemSearchCriteria criteria)
          throws ServiceException;

  /**
   * 
   * @param itemId
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.ItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/deleteItem")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
  @RequestWrapper(localName = "deleteItem", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.DeleteItem")
  @ResponseWrapper(localName = "deleteItemResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.DeleteItemResponse")
  public
      ItemResponse
      deleteItem(
          @WebParam(name = "itemId", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item") Long itemId) throws ServiceException;

  /**
   * 
   * @param criteria
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.ItemFindResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/searchItems")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
  @RequestWrapper(localName = "searchItems", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.SearchItems")
  @ResponseWrapper(localName = "searchItemsResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.SearchItemsResponse")
  public
      ItemFindResponse
      searchItems(
          @WebParam(name = "criteria", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item") ItemSearchCriteria criteria)
          throws ServiceException;

  /**
   * 
   * @param item
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.ItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/createItem")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
  @RequestWrapper(localName = "createItem", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.CreateItem")
  @ResponseWrapper(localName = "createItemResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.CreateItemResponse")
  public ItemResponse createItem(
      @WebParam(name = "item", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item") Item item)
      throws ServiceException;

  /**
   * 
   * @param item
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.ItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/updateItem")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
  @RequestWrapper(localName = "updateItem", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.UpdateItem")
  @ResponseWrapper(localName = "updateItemResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.UpdateItemResponse")
  public ItemResponse updateItem(
      @WebParam(name = "item", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item") Item item)
      throws ServiceException;

  /**
   * 
   * @param itemId
   * @return
   *         returns net.rlviana.pricegrabber.domain.response.core.ItemResponse
   */
  @WebMethod(action = "http://pricegrabber.rlviana.net/ws/service/findItemById")
  @WebResult(targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item")
  @RequestWrapper(localName = "findItemById", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.FindItemById")
  @ResponseWrapper(localName = "findItemByIdResponse",
      targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
      className = "net.rlviana.pricegrabber.ws.service.item.FindItemByIdResponse")
  public ItemResponse findItemById(
      @WebParam(name = "itemId", targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item") Long itemId)
      throws ServiceException;

}
