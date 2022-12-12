package com.springmvc.repository;

import com.springmvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  List<User> findUsers();

  void createUser(String login, String password);

  Optional<User> getUser(String login);

  List<User> getIncomingRequests(int recipientId);

  List<User> getOutcomingRequests(int senderId);

  List<User> getAllFriends(int userId);
}
