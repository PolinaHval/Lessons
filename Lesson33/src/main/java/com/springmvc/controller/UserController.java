package com.springmvc.controller;

import com.springmvc.service.UserService;
import lombok.RequiredArgsConstructor;
import com.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  protected String getUser(Model model) {
    final List<User> users = userService.findUsers();
    model.addAttribute("users", users);
    return "users";
  }
}
