package springmvc.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springmvc.model.User;
import springmvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> findUsers() {
    return userRepository.findAll();
  }

  public void createUser(String login, String password) {
    log.info("Creating user {}", login);
    if (userRepository.findByLogin(login).isPresent()) {
      throw new RuntimeException("User already exists");
    }
    if (password.isEmpty()) {
      log.info("User password is empty");
      throw new RuntimeException("User password is empty");
    }
    final User user = new User(login, password);
    userRepository.save(user);
    log.info("User {} successfully create", login);
  }

  public Optional<User> getUser(String login) {
    return userRepository.findByLogin(login);
  }

  public List<User> getUsersOfAllOutgoingRequests(int senderId) {
    return userRepository.getOutcomingRequests(senderId);
  }

  public List<User> getAllFriends(int userId) {
    return userRepository.getAllFriends(userId);
  }

  public List<User> getUsersOfAllIncomingRequests(int recipientId) {
    return userRepository.getIncomingRequests(recipientId);
  }

}
