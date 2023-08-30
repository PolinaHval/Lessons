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

import springmvc.error.UserAlreadyExistException;
import springmvc.model.Organization;
import springmvc.service.OrganizationService;
import springmvc.service.UserService;
import springmvc.session.AuthContext;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationUserController {

  private final UserService userService;
  private final AuthContext authContext;
  private final OrganizationService organizationService;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("createUserDto", new CreateUserDto());
    return "registration";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createUser(@ModelAttribute("createUserDto") @Valid final CreateUserDto createUserDto,
                              final BindingResult result) {
    final long organization_id = authContext.getOrganizationId();
    final Organization organization = organizationService.getOrganizationById(organization_id);
    if (!result.hasErrors()) {
      try {
        userService.createUser(createUserDto.getLogin(), createUserDto.getPassword(), createUserDto.getName(),
            createUserDto.getLastName(), createUserDto.getPatronymic(), createUserDto.getEmail(),
            createUserDto.getPhone(), createUserDto.getRole(), organization);
        return "redirect:/login";
      } catch (UserAlreadyExistException exception) {
        System.out.println(exception.getMessage());
        return "registration";
      }
    } else {
      return "registration";
    }
  }
}

