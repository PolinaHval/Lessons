package com.springmvc.service;

import lombok.RequiredArgsConstructor;
import com.springmvc.model.User;
import com.springmvc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<User> findUsers() {
    return userRepository.findUsers();
  }

  public void createUser(String login, String password) {
    log.info("Creating user {}", login);
    if (userRepository.getUser(login).isPresent()) {
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
    return userRepository.getUser(login);
  }

}
