package springmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.dto.UserDto;
import springmvc.model.User;
import springmvc.service.UserService;
import springmvc.session.AuthContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

  private final AuthContext authContext;
  private final UserService userService;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("userDto", new UserDto());
    return "login";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String doPost(@ModelAttribute("userDto") @Valid final UserDto userDto, HttpServletResponse response) throws IOException {
    final String login = userDto.getLogin();
    final String password = userDto.getPassword();
    Optional<User> user = userService.findUser(login);
    if (user.isPresent() && userService.validatePassword(password, user.get().getPassword())) {
      authContext.setLoggedInUserId(user.get().getId());
      authContext.setOrganizationId(user.get().getOrganization().getId());
      return "redirect:/homePage";
    } else {
      PrintWriter out = response.getWriter();
      out.println("Username or password error");
      return "login";
    }
  }


}


//  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//  protected String authorizeUser(@Valid @ModelAttribute("dto") final UserDto userDto, HttpServletResponse response,
//                                 final BindingResult bindingResult) throws IOException {
//    if (bindingResult.hasFieldErrors()) {
//      return "login";
//    }
//    final String login = userDto.getLogin();
//    final String password = userDto.getPassword();
//    Optional<User> user = userService.findUser(login);
//    if (user.isPresent() && userService.validatePassword(password, user.get().getPassword())) {
//      User userLoggedIn = userService.getUserByLogin(login);
//      final String token = jwt.generateToken(userLoggedIn.getLogin());
//      final Cookie cookie = new Cookie("myToken", token);
//      response.addCookie(cookie);
//      return "redirect:/homePage";
//    } else {
//      response.setCharacterEncoding("utf-8");
//      final PrintWriter out = response.getWriter();
//      out.println(" Логин или пароль введены неверно");
//      return "login";
//    }
//  }
