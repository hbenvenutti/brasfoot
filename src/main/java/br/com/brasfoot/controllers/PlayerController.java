package br.com.brasfoot.controllers;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.brasfoot.dao.PlayerRepository;
import br.com.brasfoot.models.Player;

// * ---------------------------------------------------------------------- * //

@Controller
@Component
public class PlayerController {
  private PlayerRepository repository;

  // *** --- constructor ------------------------------------------------ *** //

  public PlayerController(PlayerRepository repository) {
    this.repository = repository;
  }

  // *** --- get -------------------------------------------------------- *** //
  @GetMapping("/brasfoot/players")
  @ResponseBody
  public String listPlayers() {
    List<Player> players = repository.list();
    
    return players.toString();
  }

  // ------------------------------------------------------------------------ //

  @GetMapping("/brasfoot/players/{id}")
  @ResponseBody
  public String getPlayer(@PathVariable int id) {
    return "Player";
  }

  // ------------------------------------------------------------------------ //

  @PostMapping("/brasfoot/players/{id}")
  @ResponseBody
  public String createPlayer(@PathVariable int id) {
    return "Player";
  }

  // ------------------------------------------------------------------------ //

  @PutMapping("/brasfoot/players/{id}")
  @ResponseBody
  public String updatePlayer(@PathVariable int id) {
    return "Player";
  }

  // ------------------------------------------------------------------------ //

  @DeleteMapping("/brasfoot/players/{id}")
  @ResponseBody
  public String deletePlayer(@PathVariable int id) {
    return "Player";
  }
}
