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
}
