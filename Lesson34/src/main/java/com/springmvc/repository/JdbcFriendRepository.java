package com.springmvc.repository;

import com.springmvc.model.Friend;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class JdbcFriendRepository implements FriendRepository {

  private final Connection connection;

  private static final String ADD_FRIEND = "insert into friends (user_id, friend_id) values (?,?)";
  private static final String GET_FRIEND_LIST = "select user_Id, friend_Id from friends where user_id = ?";

  @Override
  public void addFriend(int senderId, int recipientId) {
    try (PreparedStatement statement = connection.prepareStatement(ADD_FRIEND)) {
      statement.setInt(1, senderId);
      statement.setInt(2, recipientId);
      statement.execute();
      statement.setLong(1, senderId);
      statement.setLong(2, recipientId);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public List<Friend> getListFriends(int userId) {
    try (PreparedStatement statement = connection.prepareStatement(GET_FRIEND_LIST)) {
      statement.setInt(1, userId);
      ResultSet resultSet = statement.executeQuery();
      List<Friend> friends = new ArrayList<>();
      while (resultSet.next()) {
        friends.add(Friend.builder()
            .userId(resultSet.getInt("userId"))
            .friendId(resultSet.getInt("friendId")).build());
      }
      return friends;
    } catch (SQLException ex) {
      throw new RuntimeException(ex);
    }
  }
}
