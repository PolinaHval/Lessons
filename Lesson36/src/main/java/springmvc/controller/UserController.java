package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//  @GetMapping
//  public String getUsers(final Model model) {
//    final List<User> users = userService.findUsers();
//    model.addAttribute("users", users);
//    model.addAttribute("dto", new CreateUserDto());
//    return "users";
//  }

  @GetMapping("/page/{pageNo}")
  public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
    int pageSize = 3;
    final Page<User> page = userService.findPaginated(pageNo, pageSize);
    List<User> users = page.getContent();

    model.addAttribute("currentPage", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    model.addAttribute("users", users);
    return "users";
  }

  @GetMapping
  public String getUsers(final Model model) {
    return findPaginated(1, model);
  }

}
