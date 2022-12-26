package springmvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Column(name = "login")
  private String login;

  @Column(name = "password")
  private String password;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int userId;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }
}
