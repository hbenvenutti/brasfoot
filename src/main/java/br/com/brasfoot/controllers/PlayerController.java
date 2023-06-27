package br.com.brasfoot.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// * ---------------------------------------------------------------------- * //

@Controller
@Component
public class PlayerController {

  // *** --- get -------------------------------------------------------- *** //
  @GetMapping("/brasfoot/players")
  @ResponseBody
  public String listPlayers() {
    return "Players";
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
