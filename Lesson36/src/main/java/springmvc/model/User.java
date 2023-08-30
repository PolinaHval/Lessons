package springmvc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.NonFinal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@NonFinal
@AllArgsConstructor
@Builder

public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @Column(name = "login")
  String login;

  @Column(name = "password")
  String password;

  @Column(name = "name")
  String name;

  @Column(name = "last_Name")
  String lastName;

  @Column(name = "patronymic")
  String patronymic;

  @Column(name = "email")
  String email;

  @Column(name = "phone")
  int phone;

  @Column(name = "role")
  String role;

  @ManyToOne
  @JoinColumn(name = "organization_Id", nullable = false)
  public Organization organization;


  public User(String login, String password, String name, String lastName, String patronymic, String email, int phone,
              String role, Organization organization) {
    this.login = login;
    this.password = password;
    this.name = name;
    this.lastName = lastName;
    this.patronymic = patronymic;
    this.email = email;
    this.phone = phone;
    this.role = role;
    this.organization = organization;
  }
}
