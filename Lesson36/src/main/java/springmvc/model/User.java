package springmvc.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {

  @Column(name = "login")
  String login;
  @Column(name = "password")
  String password;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public int getId() {
    return id;
  }
}
