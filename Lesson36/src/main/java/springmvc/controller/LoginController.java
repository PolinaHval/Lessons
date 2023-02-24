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
  protected String doPost(@Valid @ModelAttribute("dto") final CreateUserDto createUserDto, final BindingResult result) {
    final String login = createUserDto.getLogin();
    Optional<User> user = userService.getUser(login);
    if (user.isPresent() && !result.hasErrors()) {
      authContext.setLoggedInUserId(user.get().getId());
      return "redirect:/users";
    } else {
      return "login";
    }
  }
}
