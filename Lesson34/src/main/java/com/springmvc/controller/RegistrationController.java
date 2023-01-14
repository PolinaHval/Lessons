package com.springmvc.controller;

import com.springmvc.dto.CreateUserDto;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import com.springmvc.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

  private final UserService userService;
  private final AuthContext authContext;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("dto", new CreateUserDto());
    return "registration";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createUser(@Valid @ModelAttribute("dto") final CreateUserDto dto,
                              final BindingResult result,
                              final Model model) {
    if (!result.hasErrors()) {
      userService.createUser(dto.getLogin(), dto.getPassword());
      authContext.setAuthorized(true);
    }
    final List<User> users = userService.findUsers();
    model.addAttribute("users", users);
    return "users";
  }
}