package springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springmvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


  Optional<User> findByLogin(String login);

  List<User> getIncomingRequests(int recipientId);

  List<User> getOutcomingRequests(int senderId);

  List<User> getAllFriends(int userId);
}
