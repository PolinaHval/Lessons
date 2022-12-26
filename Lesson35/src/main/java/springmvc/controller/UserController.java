package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.dto.CreateUserDto;
import springmvc.model.User;
import springmvc.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  protected String getUser(Model model) {
    final List<User> users = userService.findUsers();
    model.addAttribute("users", users);
    model.addAttribute("dto", new CreateUserDto());
    return "users";

  }
}
