package me.whiteship.demoquerydsl;

import jakarta.persistence.EntityManager;
import java.io.Serializable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SuppressWarnings("Spring")
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

  private final EntityManager entityManager;

  public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

  @Override
  public boolean contains(T entity) {
    return false;
  }
}
