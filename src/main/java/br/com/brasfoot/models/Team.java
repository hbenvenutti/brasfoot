package br.com.brasfoot.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

// * ---------------------------------------------------------------------- * //

@Entity
public class Team {
  @Id
  int id;

  String name;
  String nickname;
  Date foundation;
  String city;

  @OneToMany(mappedBy = "team")
  List<Player> players = new ArrayList<Player>();

  @Transient
  List<Player> relatedPlayers = new ArrayList<Player>();

  // *** --- constructors ----------------------------------------------- *** //

  public Team() {}

  // ------------------------------------------------------------------------ //

  public Team(String name, Date foundation, String city) {
    setName(name);
    setFoundation(foundation);
    setCity(city);
  }

  // ------------------------------------------------------------------------ //

  public Team(int id, String name, String nickname, Date foundation, String city, List<Player> players,
      List<Player> relatedPlayers) {
    this.id = id;
    this.name = name;
    this.nickname = nickname;
    this.foundation = foundation;
    this.city = city;
    this.players = players;
    this.relatedPlayers = relatedPlayers;
  }

  // *** --- getters ---------------------------------------------------- *** //
  
  public int getCode() {
    return id;
  }

  // ------------------------------------------------------------------------ //

  public String getName() {
    return name;
  }

  // ------------------------------------------------------------------------ //

  public String getNickname() {
    return nickname;
  }

  // ------------------------------------------------------------------------ //

  public Date getFoundation() {
    return foundation;
  }

  // ------------------------------------------------------------------------ //

  public String getCity() {
    return city;
  }

  // ------------------------------------------------------------------------ //

  public List<Player> getPlayers() {
    return players;
  }

  // ------------------------------------------------------------------------ //

  public List<Player> getRelatedPlayers() {
    return relatedPlayers;
  }

  // *** --- setters ---------------------------------------------------- *** //
  
  public void setCode(int id) {
    this.id = id;
  }

  // ------------------------------------------------------------------------ //

  public void setName(String name) {
    this.name = name;
  }

  // ------------------------------------------------------------------------ //

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  // ------------------------------------------------------------------------ //

  public void setFoundation(Date foundation) {
    this.foundation = foundation;
  }

  // ------------------------------------------------------------------------ //

  public void setCity(String city) {
    this.city = city;
  }

  // ------------------------------------------------------------------------ //

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  // ------------------------------------------------------------------------ //

  public void setRelatedPlayers(List<Player> relatedPlayers) {
    this.relatedPlayers = relatedPlayers;
  }

  // *** --- methods ---------------------------------------------------- *** //

  public List<Player> relatePlayers() {
    int counter = 0;

    this.relatedPlayers.clear();
    
    Collections.sort(players, (player1, player2) -> 
      Integer.compare(player2.getStats(), player1.getStats()));
    
    for (Player player : players) {
        if (counter == 18) break;

        if (!player.canPlay()) continue;

        this.relatedPlayers.add(player);
        counter++;
    }

    return this.relatedPlayers;
  }

  // *** --- jakarta.persistence overrides ------------------------------ *** //
  @Override
	public int hashCode() {
		return Objects.hash(id);
	}

  @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return id == other.id;
	}
}
