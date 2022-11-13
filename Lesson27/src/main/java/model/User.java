package model;

import lombok.Getter;

@Getter
public class User {
  private final String login;
  private final String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }
}
