package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.model.Tender;
import springmvc.model.User;
import springmvc.service.TenderService;
import springmvc.service.UserService;
import springmvc.session.AuthContext;

import java.util.List;

@Controller
@RequestMapping("/tender")
@RequiredArgsConstructor
public class TenderController {
  private final TenderService tenderService;
  private final UserService userService;
  private final AuthContext authContext;


  @GetMapping("/{tenderId}")
  protected String Tender(@PathVariable("tenderId") int tenderId, Model model) {
    final long userId = authContext.getLoggedInUserId();
    User user = userService.getUserById(userId);
    model.addAttribute("user", user);
    Tender tender = tenderService.getTenderById(tenderId);
    model.addAttribute("tender", tender);
    return "/tender";
  }
}
