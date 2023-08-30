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
import springmvc.dto.CreateOrganizationDto;
import springmvc.dto.UserDto;
import springmvc.model.Organization;
import springmvc.model.User;
import springmvc.service.OrganizationService;
import springmvc.session.AuthContext;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;


@Controller
@RequestMapping("/registration1")
@RequiredArgsConstructor
public class RegistrationOrganizationController {

  private final OrganizationService organizationService;
  private final AuthContext authContext;

  @GetMapping
  protected String doGet(final Model model) {
    model.addAttribute("createOrganizationDto", new CreateOrganizationDto());
    return "registration1";
  }

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createOrganization(@ModelAttribute("createOrganizationDto") @Valid final CreateOrganizationDto createOrganizationDto,
                                      final BindingResult result) {
    if (!result.hasErrors())
      organizationService.createOrganization(createOrganizationDto.getUnp(), createOrganizationDto.getFullName(),
          createOrganizationDto.getShortName(), createOrganizationDto.getLegalAddress(),
          createOrganizationDto.getActualAddress());

    Optional<Organization> organization = organizationService.getOrganizationByUnp(createOrganizationDto.getUnp());
    if (organization.isPresent()) {
      authContext.setOrganizationId(organization.get().getId());
    } else {
      return "registration1";
    }
    return "redirect:/registration";
  }
}

