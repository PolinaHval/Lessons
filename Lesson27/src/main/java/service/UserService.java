package service;

import lombok.extern.slf4j.Slf4j;
import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public class UserService {

  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  public List<User> findUsers() {
    return userRepository.findUsers();
  }

  public void createUser(String login, String password) {
    log.info("Creating user {}", login);
    if (userRepository.getUserLogin(login).isPresent()) {
      throw new RuntimeException("User already exists");
    }
    if (password.isEmpty()) {
      log.info("User password is empty");
      throw new RuntimeException("User password is empty");
    }
    userRepository.createUser(login, password);
    log.info("User {} successfully create", login);
  }

  public Optional<User> getUser(String login) {
    return userRepository.getUserLogin(login);
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
