package net.rlviana.pricegrabber.ws.service.item;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.rlviana.pricegrabber.domain.entity.core.Item;
import net.rlviana.pricegrabber.domain.response.core.ItemFindResponse;
import net.rlviana.pricegrabber.domain.response.core.ItemResponse;
import net.rlviana.pricegrabber.domain.search.core.ItemSearchCriteria;
import net.rlviana.pricegrabber.ws.service.exception.ServiceException;

@WebService(portName = "ItemPort", serviceName = "ItemService",
    targetNamespace = "http://pricegrabber.rlviana.net/ws/service/item",
    endpointInterface = "net.rlviana.pricegrabber.ws.service.item.ItemPortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class ItemPortTypeImpl
    implements ItemPortType
{

  public ItemPortTypeImpl() {
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.item.ItemPortType#searchItems(net.rlviana.pricegrabber.domain.search.core.ItemSearchCriteria)
   */
  @Override
  public ItemFindResponse searchItems(ItemSearchCriteria criteria) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.item.ItemPortType#updateItem(net.rlviana.pricegrabber.domain.entity.core.Item)
   */
  @Override
  public ItemResponse updateItem(Item item) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.item.ItemPortType#createItem(net.rlviana.pricegrabber.domain.entity.core.Item)
   */
  @Override
  public ItemResponse createItem(Item item) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.item.ItemPortType#deleteItem(java.lang.Long)
   */
  @Override
  public ItemResponse deleteItem(Long itemId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.item.ItemPortType#listItems(net.rlviana.pricegrabber.domain.search.core.ItemSearchCriteria)
   */
  @Override
  public ItemFindResponse listItems(ItemSearchCriteria criteria) throws ServiceException

  {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.ws.service.item.ItemPortType#findItemById(java.lang.Long)
   */
  @Override
  public ItemResponse findItemById(Long itemId) throws ServiceException {
    // TODO Auto-generated method stub
    return null;
  }

}
