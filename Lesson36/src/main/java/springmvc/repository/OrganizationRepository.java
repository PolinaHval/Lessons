package springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springmvc.model.Organization;
import springmvc.model.User;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

  Optional<Organization> findByUnp(int unp);

  Optional<Organization> findOrganizationById(long organizationId);

  Organization getOrganizationById(long organizationId);


}
