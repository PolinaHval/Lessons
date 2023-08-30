package springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.model.Tender;
import springmvc.service.TenderService;

import java.util.List;

@Controller
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
  private final TenderService tenderService;

  @GetMapping()
  protected String getAllTenders(Model model) {
    List<Tender> tenders = tenderService.getAllTenders();
    model.addAttribute("tenders", tenders);
    return "search";
  }
}
