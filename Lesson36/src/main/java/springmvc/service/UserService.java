package springmvc.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springmvc.model.User;
import springmvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public Page<User> findPaginated(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    return userRepository.findAll(pageable);
  }

  public List<User> findUsers() {
    return userRepository.findAll();
  }

  public void createUser(String login, String password, int userId) {
    if (userRepository.findByLogin(login).isPresent()) {
      throw new RuntimeException("User already exists");
    }
    if (password.isEmpty()) {
      throw new RuntimeException("User password is empty");
    }
    final User user = new User(login, password);
    userRepository.save(user);
  }

  public Optional<User> getUser(String login) {
    return userRepository.findByLogin(login);
  }
}
