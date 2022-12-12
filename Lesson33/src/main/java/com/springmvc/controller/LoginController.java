package com.springmvc.controller;

import com.springmvc.dto.CreateUserDto;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import com.springmvc.session.AuthContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Slf4j
@Validated
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final UserService userService;
  private final AuthContext authContext;

  @GetMapping
  protected String doGet() {
    return "registration";
  }

  @PostMapping
  protected String createUser(@Valid final CreateUserDto dto, HttpServletResponse response) throws IOException {
    final String login = dto.getLogin();
    final String password = dto.getPassword();
    Optional<User> user = userService.getUser(login);

    if (user.isPresent() && user.get().getPassword().equals(password)) {
      authContext.setLoggedInUserId(user.get().getUserId());
      return "redirect:/users";
    } else {
      PrintWriter out = response.getWriter();
      out.println("Username or password error");
      return "login";
    }
  }
}
