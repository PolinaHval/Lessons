package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.dto.CreateUserDto;
import springmvc.model.User;
import springmvc.service.UserService;
import springmvc.session.AuthContext;

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
      userService.createUser(dto.getLogin(), dto.getPassword(), dto.getId());
      authContext.setAuthorized(true);
      final List<User> users = userService.findUsers();
      model.addAttribute("users", users);
      return "redirect:/users";
    } else {
      return "registration";
    }
  }
}
