package net.rlviana.pricegrabber.context;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.rlviana.pricegrabber.model.repository.common.CountryRepository;
import net.rlviana.pricegrabber.model.repository.common.CurrencyRepository;
import net.rlviana.pricegrabber.model.repository.common.LanguageRepository;
import net.rlviana.pricegrabber.model.repository.core.ItemRepository;
import net.rlviana.pricegrabber.model.repository.core.ItemTypeRepository;
import net.rlviana.pricegrabber.model.repository.core.PromotionRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteItemDatumRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteItemRepository;
import net.rlviana.pricegrabber.model.repository.core.SiteRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(JPAPersistenceContext.class)
@EnableTransactionManagement
public class RepositoryContext {

  @PersistenceContext
  private EntityManager entityManager;

  @Bean
  public CountryRepository countryRepository() {
    CountryRepository repository = new CountryRepository();
    repository.setEntityManager(entityManager);
    return repository;
  }

  @Bean
  public LanguageRepository languageRepository() {
    LanguageRepository repository = new LanguageRepository();
    repository.setEntityManager(entityManager);
    return repository;
  }

  @Bean
  public CurrencyRepository currencyRepository() {
    CurrencyRepository repository = new CurrencyRepository();
    repository.setEntityManager(entityManager);
    return repository;
  }

  @Bean
  public SiteRepository siteRepository() {
    SiteRepository repository = new SiteRepository();
    repository.setEntityManager(entityManager);
    return repository;
  }

  /**
   * @return
   */
  @Bean
  public ItemRepository itemRepository() {
    ItemRepository repository = new ItemRepository();
    repository.setEntityManager(entityManager);
    return repository;

  }

  /**
   * @return
   */
  @Bean
  public ItemTypeRepository itemTypeRepository() {
    ItemTypeRepository repository = new ItemTypeRepository();
    repository.setEntityManager(entityManager);
    return repository;
  }

  /**
   * @return
   */
  @Bean
  public PromotionRepository promotionRepository() {
    PromotionRepository repository = new PromotionRepository();
    repository.setEntityManager(entityManager);
    return repository;
  }

  /**
   * @return
   */
  @Bean
  public SiteItemDatumRepository siteItemDatumRepository() {
    SiteItemDatumRepository repository = new SiteItemDatumRepository();
    repository.setEntityManager(entityManager);
    return repository;

  }

  /**
   * @return
   */
  @Bean
  public SiteItemRepository siteItemRepository() {
    SiteItemRepository repository = new SiteItemRepository();
    repository.setEntityManager(entityManager);
    return repository;

  }

}
