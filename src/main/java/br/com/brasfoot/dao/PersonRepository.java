package br.com.brasfoot.dao;

import org.springframework.stereotype.Repository;

import br.com.brasfoot.models.Person;

// * ---------------------------------------------------------------------- * //

@Repository
public interface PersonRepository extends GenericRepository<Person, Long> {
  
}
