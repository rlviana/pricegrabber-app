/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.common;

import net.rlviana.pricegrabber.model.entity.common.Currency;
import net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.common.CurrencySearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ramon
 * 
 */
public class CurrencyRepositoryIT extends AbstractReadOnlyRepositoryIT<Currency, String> {

  protected static final String OK_KEY = "EU";
  protected static final String KO_KEY = "CA";

  private CurrencyRepository repository;

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected CurrencySearchCriteria getCriteria() {
    CurrencySearchCriteria criteria = getCriteriaEmpty();
    criteria.setId(OK_KEY);
    criteria.setIdLike(OK_KEY);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected CurrencySearchCriteria getCriteriaEmpty() {
    return new CurrencySearchCriteria();
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyOK()
   */
  @Override
  protected String getKeyOK() {
    return OK_KEY;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getKeyKO()
   */
  @Override
  protected String getKeyKO() {
    return KO_KEY;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getRepository()
   */
  @Override
  protected CurrencyRepository getRepository() {
    return repository;
  }

  @Autowired
  protected void setRepository(CurrencyRepository repository) {
    this.repository = repository;
  }

}
