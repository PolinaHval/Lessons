package com.springmvc.controller;

import com.springmvc.dto.CreateUserDto;
import com.springmvc.service.UserService;
import com.springmvc.session.AuthContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Slf4j
@Validated
@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

  private final UserService userService;
  private final AuthContext authContext;

  @GetMapping
  protected String doGet() {
    return "registration";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected RedirectView createUser(@Valid final CreateUserDto dto) {
    userService.createUser(dto.getLogin(), dto.getPassword());
    log.info("User {} registered", dto.getLogin());
    return new RedirectView("users");
  }
}
