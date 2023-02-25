package springmvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import springmvc.model.User;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByLogin(String login);


}
