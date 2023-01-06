package com.springmvc.repository;

import lombok.RequiredArgsConstructor;
import com.springmvc.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {

  private final Connection connection;

  private static final String FIND_USERS = "select login, password, id from users";
  private static final String CREATE_USER = "insert into users (login, password) values (?, ?)";
  private static final String GET_LOGIN_USER = "select login, password, id from users where login = ?";
  private static final String GET_ID_USER = "select id, login, password from users where id = ?";

  @Override
  public List<User> findUsers() {
    try (Statement statement = connection.createStatement()) {
      ResultSet resultSet = statement.executeQuery(FIND_USERS);
      final List<User> users = new ArrayList<>();
      while (resultSet.next()) {
        users.add(User.builder()
            .login(resultSet.getString("login"))
            .password(resultSet.getString("password"))
            .userId(Integer.parseInt(resultSet.getString("id"))).build());
      }
      return users;
    } catch (SQLException e) {
//      log.error("Users not found");
      throw new RuntimeException(e);
    }
  }

  @Override
  public void createUser(String login, String password) {
    try (PreparedStatement statement = connection.prepareStatement(CREATE_USER)) {
      statement.setString(1, login);
      statement.setString(2, password);
      statement.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Optional<User> getUser(String login) {
    try (PreparedStatement statement = connection.prepareStatement(GET_LOGIN_USER)) {
      statement.setString(1, login);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return Optional.of(User.builder()
            .login(resultSet.getString("login"))
            .password(resultSet.getString("password")).build());
      }
      return Optional.empty();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<User> getIncomingRequests(int recipientId) {
    ResultSet resultSet;
    try (PreparedStatement statement = connection.prepareStatement(
        "select inviter_id, user_id from invitations where user_id = ?")) {
      statement.setInt(1, recipientId);

      List<User> userList = new ArrayList<>();
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        userList.add(User.builder()
            .userId(Integer.parseInt(resultSet.getString("id")))
            .login(resultSet.getString("login")).build());
      }
      return userList;
    } catch (SQLException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public List<User> getOutcomingRequests(int senderId) {
    try (PreparedStatement statement = connection.prepareStatement(
        "select inviter_id, user_id from invitations where inviter_id = ?")) {
      statement.setInt(1, senderId);

      List<User> userList = new ArrayList<>();
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        userList.add(User.builder()
            .userId(Integer.parseInt(rs.getString("user_id")))
            .login(rs.getString("login")).build()
        );
      }
      return userList;
    } catch (SQLException e) {
      return new ArrayList<>();
    }
  }


  @Override
  public List<User> getAllFriends(int userId) {
    try (PreparedStatement statement = connection.prepareStatement(
        "select user_id, friend_id from friends where user_id = ?")) {
      statement.setInt(1, userId);
      statement.setInt(2, userId);

      List<User> userList = new ArrayList<>();
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        userList.add(User.builder().userId(Integer.parseInt(rs.getString("user_id")))
            .login(rs.getString("login")).build()
        );
      }
      return userList;
    } catch (SQLException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public Optional<User> getUserById(int userId) {
    try (PreparedStatement statement = connection.prepareStatement(GET_ID_USER)) {
      statement.setInt(1, userId);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }
}
