package br.com.brasfoot.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.brasfoot.models.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

// * ---------------------------------------------------------------------- * //

@Component
public class PlayerRepository {
  @PersistenceContext
  private EntityManager manager;

  // ------------------------------------------------------------------------ //

  public List<Player> list(){
        TypedQuery<Player> query = 
            manager.createQuery("from Player", Player.class);
        
        return query.getResultList();
    }

  // ------------------------------------------------------------------------ //

  @Transactional
  public Player save(Player player) {
  // create and update;

    return manager.merge(player);
  }

  // ------------------------------------------------------------------------ //

  @Transactional
  public void delete(Player player) {
    // find 
    player = findByCode(player.getCode());
    manager.remove(player);
  }

  // ------------------------------------------------------------------------ //

  public Player findByCode(long code) {
    return manager.find(Player.class, code);
  }
}
