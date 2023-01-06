package com.springmvc.repository;

import com.springmvc.model.FriendRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
@AllArgsConstructor
public class JdbcFriendRequestRepository implements FriendRequestRepository {

  private final Connection connection;

  private static final String CREATE_FRIEND_REQUEST = "insert invitations (inviter_id, user_id) values (?,?)";
  private static final String DELETE_FRIEND_REQUEST = "delete from invitations where inviter_id = ? and  user_id = ?";
  private static final String GET_FRIEND_REQUEST = "select inviter_id, user_id from invitations where" +
      " inviter_id = ? and user_id = ?";

  @Override
  public void createFriendRequest(int senderRequest, int recipientRequest) {
    try (PreparedStatement statement = connection.prepareStatement(CREATE_FRIEND_REQUEST)) {
      statement.setInt(1, senderRequest);
      statement.setInt(2, recipientRequest);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteFriendRequest(int senderRequest, int recipientRequest) {
    try (PreparedStatement statement = connection.prepareStatement(DELETE_FRIEND_REQUEST)) {
      statement.setInt(1, senderRequest);
      statement.setInt(2, recipientRequest);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean getFriendRequest(int senderRequest, int recipientRequest) {
    try (PreparedStatement statement = connection.prepareStatement(GET_FRIEND_REQUEST)) {
      statement.setInt(1, senderRequest);
      statement.setInt(2, recipientRequest);
      ResultSet resultSet = statement.executeQuery();
      return resultSet.next();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
