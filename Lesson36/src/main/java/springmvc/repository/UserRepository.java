package springmvc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springmvc.model.Organization;
import springmvc.model.User;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  Optional<User> findByLogin(String login);

  User findUserById(long userId);


}
