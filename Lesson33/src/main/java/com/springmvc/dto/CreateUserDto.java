package com.springmvc.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateUserDto {
  @NotEmpty
  private final String login;
  @NotEmpty
  private final String password;

}
