package net.rlviana.pricegrabber.domain.response;

import java.util.List;

/**
 * Response interface.
 * 
 * @author ramon
 */
public interface IResponse {

  /**
   * Get whether or not the response has any errors.
   * 
   * @return <code>true</code> or <code>false</code>
   */
  public boolean isErrors();

  /**
   * Set whether or not the response has any errors.
   * 
   * @param value <code>true</code> if has errors
   */
  public void setErrors(final boolean value);

  /**
   * Gets message list.
   * 
   * @return list of messages
   */
  public List<Message> getMessages();

  /**
   * Sets message list.
   * 
   * @param messages to assign to response
   */
  public void setMessages(final List<Message> messages);

}