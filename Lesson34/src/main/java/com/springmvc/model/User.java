package com.springmvc.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
@Builder
public class User {

  String login;
  String password;
  int userId;

  public User(String login, String password, int userId) {
    this.login = login;
    this.password = password;
    this.userId = userId;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public int getUserId() {
    return userId;
  }
}
