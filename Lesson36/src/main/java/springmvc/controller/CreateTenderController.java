package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.dto.CreateTenderDto;
import springmvc.model.Organization;
import springmvc.model.User;
import springmvc.service.OrganizationService;
import springmvc.service.TenderService;
import springmvc.service.UserService;
import springmvc.session.AuthContext;

import javax.validation.Valid;

@Controller
@RequestMapping("/createTender")
@RequiredArgsConstructor
public class CreateTenderController {

  private final TenderService tenderService;
  private final AuthContext authContext;
  private final UserService userService;
  private final OrganizationService organizationService;

  @GetMapping
  protected String doGet(final Model model) {
    final long userId = authContext.getLoggedInUserId();
    User user = userService.getUserById(userId);
    model.addAttribute("user", user);
    model.addAttribute("createTenderDto", new CreateTenderDto());
    return "createTender";
  }


  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  protected String createTender(@ModelAttribute("createTenderDto") @Valid final CreateTenderDto createTenderDto,
                                final BindingResult result) {
    final long organization_id = authContext.getOrganizationId();
    final Organization organization = organizationService.getOrganizationById(organization_id);
    if (!result.hasErrors()) {
      tenderService.createTender(createTenderDto.getSubject(), createTenderDto.getShortDescription(),
          createTenderDto.getValuta(), createTenderDto.getPrice(), createTenderDto.getTermsOfPayment(),
          createTenderDto.getDeliveryConditions(), organization);
    } else {
      return "/createTender";
    }
    return "redirect:/myTenders";
  }
}
