package br.com.brasfoot.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.brasfoot.models.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// * ---------------------------------------------------------------------- * //

@Component
public class TeamRepository {
  @PersistenceContext
  private EntityManager manager;

  // ------------------------------------------------------------------------ //

  public List<Team> list(){
    TypedQuery<Team> query = 
      manager.createQuery("from Team", Team.class);
        
    return query.getResultList();
  }

  // ------------------------------------------------------------------------ //

  @Transactional
  public Team save(Team team) {
  // create and update;

    return manager.merge(team);
  }

  // ------------------------------------------------------------------------ //

  @Transactional
  public void delete(Team team) {
    team = findByCode(team.getCode());
    manager.remove(team);
  }

  // ------------------------------------------------------------------------ //

  public Team findByCode(int code) {
    return manager.find(Team.class, code);
  }
}
