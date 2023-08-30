package springmvc.dto;


import lombok.Data;
import springmvc.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CreateUserDto {

  @NotEmpty(message = "Поле не может быть пустым")
  private String name;

  @NotEmpty()
  private String password;

  @NotEmpty(message = "Поле не может быть пустым")
  private String lastName;

  private String patronymic;

  @ValidEmail
  @NotEmpty(message = "Поле не может быть пустым")
  private String email;

  @NotNull(message = "Поле не может быть пустым")
  private int phone;

  @NotEmpty(message = "Поле не может быть пустым")
  private String login;

  @NotEmpty(message = "Поле не может быть пустым")
  private String role;
}
