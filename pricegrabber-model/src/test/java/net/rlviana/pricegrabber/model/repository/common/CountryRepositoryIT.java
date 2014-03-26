/**
 * 
 */
package net.rlviana.pricegrabber.model.repository.common;

import net.rlviana.pricegrabber.model.entity.common.Country;
import net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT;
import net.rlviana.pricegrabber.model.search.entity.common.CountrySearchCriteria;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ramon
 * 
 */
public class CountryRepositoryIT extends AbstractReadOnlyRepositoryIT<Country, String> {

  protected static final String OK_KEY = "ES";
  protected static final String KO_KEY = "SE";

  private CountryRepository repository;

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteria()
   */
  @Override
  protected CountrySearchCriteria getCriteria() {
    CountrySearchCriteria criteria = getCriteriaEmpty();
    criteria.setId(OK_KEY);
    criteria.setIdLike(OK_KEY);
    return criteria;
  }

  /**
   * 
   * @see net.rlviana.pricegrabber.model.repository.AbstractReadOnlyRepositoryIT#getCriteriaEmpty()
   */
  @Override
  protected CountrySearchCriteria getCriteriaEmpty() {
    return new CountrySearchCriteria();
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
  protected CountryRepository getRepository() {
    return repository;
  }

  @Autowired
  protected void setRepository(CountryRepository repository) {
    this.repository = repository;
  }

}
