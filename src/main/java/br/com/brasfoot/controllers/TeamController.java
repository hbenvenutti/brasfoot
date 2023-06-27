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
public class TeamController {
  
  @GetMapping("/brasfoot/teams")
  @ResponseBody
  public String listTeams() {
    return "Teams";
  }

  // ------------------------------------------------------------------------ //

  @GetMapping("/brasfoot/teams/{id}")
  @ResponseBody
  public String getTeam(@PathVariable int id) {
    return "Team";
  }

  // ------------------------------------------------------------------------ //

  @PostMapping("/brasfoot/teams/{id}")
  @ResponseBody
  public String createTeam(@PathVariable int id) {
    return "Team";
  }

  // ------------------------------------------------------------------------ //

  @PutMapping("/brasfoot/teams/{id}")
  @ResponseBody
  public String updateTeam(@PathVariable int id) {
    return "Team";
  }

  // ------------------------------------------------------------------------ //

  @DeleteMapping("/brasfoot/teams/{id}")
  @ResponseBody
  public String deleteTeam(@PathVariable int id) {
    return "Team";
  }
}
