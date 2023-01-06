package com.springmvc.controller;

import com.springmvc.dto.CreateUserDto;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import com.springmvc.session.AuthContext;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final AuthContext authContext;
  private final UserService userService;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("dto", new CreateUserDto());
    return "login";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String doPost(@Valid @ModelAttribute("dto") final CreateUserDto createUserDto) {
    final String login = createUserDto.getLogin();
    final String password = createUserDto.getPassword();
    Optional<User> user = userService.getUser(login);
    if (user.isPresent()) {
      authContext.setLoggedInUserId(user.get().getUserId());
      return "redirect:/users";
    } else {
      return "login";
    }
  }


}
