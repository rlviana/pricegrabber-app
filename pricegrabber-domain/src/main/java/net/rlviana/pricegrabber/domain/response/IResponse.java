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
  boolean isErrors();

  /**
   * Set whether or not the response has any errors.
   * 
   * @param value <code>true</code> if has errors
   */
  void setErrors(final boolean value);

  /**
   * Gets message list.
   * 
   * @return list of messages
   */
  List<Message> getMessages();

  /**
   * Sets message list.
   * 
   * @param messages to assign to response
   */
  void setMessages(final List<Message> messages);

}
