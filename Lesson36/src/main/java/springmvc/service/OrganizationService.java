package springmvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springmvc.model.Organization;
import springmvc.model.User;
import springmvc.repository.OrganizationRepository;
import springmvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrganizationService {

  private final OrganizationRepository organizationRepository;

  public void createOrganization(int unp, String fullName, String shortName, String legalAddress, String actualAddress) {
    if (organizationRepository.findByUnp(unp).isPresent()) {
      throw new RuntimeException("Компания с таким УНП уже существует");
    }
    final Organization organization = Organization.builder().unp(unp).fullName(fullName).shortName(shortName)
        .legalAddress(legalAddress).actualAddress(actualAddress).build();
    organizationRepository.save(organization);

  }

  public Organization getOrganizationById(long organizationId) {
    return organizationRepository.getOrganizationById(organizationId);
  }

  public Optional<Organization> findOrganizationById(long organizationId) {
    return organizationRepository.findOrganizationById(organizationId);
  }

  public Optional<Organization> getOrganizationByUnp(int unp) {
    return organizationRepository.findByUnp(unp);
  }


}
