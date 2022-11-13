package service;

import lombok.extern.slf4j.Slf4j;
import model.User;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findUsers() {
    return userRepository.findUsers();
  }

  public void createUser(String login, String password) {
    if (userRepository.getUser(login).isPresent()) {
      throw new RuntimeException("User already exists");
    }
    userRepository.createUser(login, password);
    log.info("User with login {} successfully create", login);
  }

  public Optional<User> getUser(String login) {
    return userRepository.getUser(login);
  }
}
