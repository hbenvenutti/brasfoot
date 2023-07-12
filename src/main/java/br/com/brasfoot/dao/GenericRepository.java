package br.com.brasfoot.dao;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

// * ---------------------------------------------------------------------- * //

@NoRepositoryBean
public interface GenericRepository<Type, ID> extends Repository<Type, ID> {
  public <S extends Type> S save(S entity);
  public <S extends Type> Iterable<S> saveAll(Iterable<S> entities);

  public Optional<Type> findById(ID id);
  public boolean existsById(ID id);
  public Iterable<Type> findAll();
  public Iterable<Type> findAllById(Iterable<ID> ids);
  public long count();

  public void deleteById(ID id);
  public void delete(Type entity);
  public void deleteAll(Iterable<? extends Type> entities);
  public void deleteAll();
}
