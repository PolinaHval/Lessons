package com.springmvc.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@AllArgsConstructor
@Repository
public class JdbcFriendRepository implements FriendRepository {

  private final Connection connection;

  private static final String ADD_FRIEND = "";

  @Override
  public void addFriend(int senderId, int recipientId) {

  }

  @Override
  public void deleteFriend(int senderId, int recipient) {

  }
}
