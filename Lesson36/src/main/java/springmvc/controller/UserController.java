package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  protected String listUsers(Model model,
                             @RequestParam(defaultValue = "1", name = "page", required = false) Integer pageNo,
                             @RequestParam(defaultValue = "5", name = "pageSize", required = false) Integer pageSize) {
    final Page<User> page = userService.findPaginated(pageNo, pageSize);
    List<User> listUsers = page.getContent();
    model.addAttribute("users", listUsers);
    model.addAttribute("currentPage", pageNo);
    model.addAttribute("pageSize", pageSize);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    return "users";
  }
}
