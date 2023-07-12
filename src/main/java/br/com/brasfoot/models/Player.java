package br.com.brasfoot.models;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// * ---------------------------------------------------------------------- * //

@Entity
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, length = 50)
  private String nationality;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private LocalDate birthday;

  private String nickname;
  private String position;
  private int stats = 1;
  private int cardsReceived = 0;
  private boolean isSuspended = false;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  // *** --- constructors ----------------------------------------------- *** //

  public Player() {}

  // ------------------------------------------------------------------------ //

  public Player(String name, String nationality, String position, LocalDate birth, int stats) {
    setName(name);
    setPosition(position);
    setNationality(nationality);
    setBirthday(birth);
    setStats(stats);
  }

  // ------------------------------------------------------------------------ //

  public Player(String name, String nationality, String position, LocalDate birth, 
    int stats, int id, String nickname, int cards, boolean isSuspended, Team team) {
      setName(name);
      setNationality(nationality);
      setPosition(position);
      setBirthday(birth);
      setStats(stats);
      setCode(id);
      setNickname(nickname);
      setCards(cards);
      setSuspended(isSuspended);
      setTeam(team);
  }

  // *** --- overrides -------------------------------------------------- *** //

  @Override
  public String toString() {
    String str = "Player: " + this.name + '\n'
    + "id: " +  this.id + '\n'
    + "nationality: " + this.nationality + '\n'
    + "birthday: " + this.birthday + '\n'
    + "nickname: " + this.nickname + '\n'
    + "position: " + this.position + '\n'
    + "stats: " + this.stats + '\n'
    + "cardsReceived: " + this.cardsReceived + '\n'
    + "isSuspended: " + this.isSuspended + '\n';
    
    return str;
  }

  // *** --- getters ---------------------------------------------------- *** //
  
  public int getCards() {
    return cardsReceived;
  }

  // ------------------------------------------------------------------------ //

  public long getCode() {
    return id;
  }

  // ------------------------------------------------------------------------ //

  public LocalDate getBirthday() {
    return birthday;
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

  public String getNationality() {
    return nationality;
  }

  // ------------------------------------------------------------------------ //

  public String getPosition() {
    return position;
  }

  // ------------------------------------------------------------------------ //

  public int getStats() {
    return stats;
  }

  // ------------------------------------------------------------------------ //

  public boolean isSuspended() {
    return isSuspended;
  }

  // ------------------------------------------------------------------------ //

  public Team getTeam() {
    return team;
  }

  // *** --- setters ---------------------------------------------------- *** //
  
  public void setCards(int cardsReceived) {
    if (cardsReceived < 0) return;

    this.cardsReceived = cardsReceived;
  }

  // ------------------------------------------------------------------------ //

  public void setCode(int id) {
    this.id = id;
  }

  // ------------------------------------------------------------------------ //

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  // ------------------------------------------------------------------------ //

  public void setName(String name) {
    if (name == null || name == "") return;
    this.name = name;
  }

  // ------------------------------------------------------------------------ //

  public void setNickname(String nickname) {
    if (nickname == null || nickname == "") return;
    this.nickname = nickname;
  }

  // ------------------------------------------------------------------------ //

  public void setNationality(String nationality) {
    if(nationality == null || nationality == "") return;
    this.nationality = nationality;
  }

  // ------------------------------------------------------------------------ //

  public void setPosition(String position) {
    if (position == null || position == "") return;
    this.position = position;
  }

  // ------------------------------------------------------------------------ //

  public void setStats(int stats) {
    if (stats < 0) return;
    this.stats = stats;
  }

  // ------------------------------------------------------------------------ //

  public void setSuspended(boolean isSuspended) {
    this.isSuspended = isSuspended;
  }

  // ------------------------------------------------------------------------ //

  public void setTeam(Team team) {
    if (team == null) return;
    this.team = team;
  }

  // *** --- methods ---------------------------------------------------- *** //
  
  public void addCard() {
    this.cardsReceived++;
  }

  // ------------------------------------------------------------------------ //

  public void applyRedCard() {
    this.cardsReceived = 0;
    this.isSuspended = true;
  }

  // ------------------------------------------------------------------------ //

  public boolean canPlay() {
    if (this.cardsReceived > 3) return false;

    return this.isSuspended;
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
		Player other = (Player) obj;
		return id == other.id;
	}
}
