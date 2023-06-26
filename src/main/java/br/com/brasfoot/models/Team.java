package br.com.brasfoot.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// * ---------------------------------------------------------------------- * //

public class Team {
  int code;
  String name;
  String nickname;
  Date foundation;
  String city;
  List<Player> players = new ArrayList<Player>();
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

  public Team(int code, String name, String nickname, Date foundation, String city, List<Player> players,
      List<Player> relatedPlayers) {
    this.code = code;
    this.name = name;
    this.nickname = nickname;
    this.foundation = foundation;
    this.city = city;
    this.players = players;
    this.relatedPlayers = relatedPlayers;
  }

  // *** --- getters ---------------------------------------------------- *** //
  
  public int getCode() {
    return code;
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
  
  public void setCode(int code) {
    this.code = code;
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

  public List<Player> relatePlayer(Player player) {
    this.relatedPlayers.add(player);
    return this.relatedPlayers;
  }
}
