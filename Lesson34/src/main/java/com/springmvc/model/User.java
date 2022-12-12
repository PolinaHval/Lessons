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

}
