package br.com.brasfoot.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// * ---------------------------------------------------------------------- * //

@Entity
@Table(name = "people")
public class Person {
  // *** --- properties ------------------------------------------------- *** //

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false)
  @Temporal(TemporalType.DATE)
  private LocalDate birthday;

  @Column(nullable = false, length = 11, unique = true)
  public String cpf;

  // *** --- constructors ----------------------------------------------- *** //

  public Person() {}

  // *** --- getters ---------------------------------------------------- *** //

  // *** --- setters ---------------------------------------------------- *** //
}
