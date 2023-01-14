package com.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Access;

@AllArgsConstructor
@Builder
public class Friend {
  int userId;
  int friendId;
}
