package springmvc.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import springmvc.error.UserAlreadyExistException;
import springmvc.model.Organization;
import springmvc.model.User;

import springmvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final OrganizationService organizationService;

  private final HashPassword hashPassword;

  public String hashingPassword(String password) {
    return hashPassword.hashingPassword(password);
  }

  public boolean validatePassword(String password, String hashedPassword) {
    return hashPassword.validatePassword(password, hashedPassword);
  }

  public User createUser(String login, String password, String name, String lastname, String patronymic,
                         String email, int phone, String role, Organization organization) {

    if (userRepository.findByEmail(email).isPresent()) {
      throw new UserAlreadyExistException(" Пользователь с указанной почтой существует");
    }

    final User user = new User(login, hashingPassword(password), name, lastname, patronymic, email, phone, role, organization);
    return userRepository.save(user);
  }

  public Optional<User> findUser(String login) {
    return userRepository.findByLogin(login);
  }


  public User getUserById(long userId) {
    return userRepository.findUserById(userId);
  }

  public List<User> getUsers(long organizationId) {
    return organizationService.findOrganizationById(organizationId).orElseThrow().getUsers();
  }

  public void deleteUser(User user) {
    userRepository.delete(user);
  }
}