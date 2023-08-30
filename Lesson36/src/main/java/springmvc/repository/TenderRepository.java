package springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springmvc.model.Organization;
import springmvc.model.Tender;
import springmvc.model.User;

public interface TenderRepository extends JpaRepository<Tender, Integer> {

  Tender findTenderById(int tenderId);
}
