package springmvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springmvc.model.Organization;
import springmvc.model.Tender;
import springmvc.model.User;
import springmvc.repository.TenderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenderService {

  private final TenderRepository tenderRepository;
  private final OrganizationService organizationService;

  public void createTender(String subject, String shortDescription, String valuta, int price, String termsOfPayment,
                           String deliveryConditions, Organization organization) {
    final Tender tender = Tender.builder().subject(subject).shortDescription(shortDescription).valuta(valuta).price(price)
        .termsOfPayment(termsOfPayment).deliveryConditions(deliveryConditions).organizationTenders(organization).build();
    tenderRepository.save(tender);
  }

  public List<Tender> getAllTenders() {
    return tenderRepository.findAll();
  }

  public List<Tender> getListTenders(long organizationId) {
    return organizationService.findOrganizationById(organizationId).orElseThrow().getTenders();
  }

  public Tender getTenderById(int tenderId) {
    return tenderRepository.findTenderById(tenderId);
  }

  public void deleteTender(Tender tender) {
    tenderRepository.delete(tender);
  }

}
