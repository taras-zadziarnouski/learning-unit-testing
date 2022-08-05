package by.zadziarnouski.unittesting.service;

import by.zadziarnouski.unittesting.model.User;
import by.zadziarnouski.unittesting.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User findUserById(Long id) {
    return userRepository.findByUserId(id);
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User selectRandomUser(User user1, User user2, User user3) {
    return userRepository.selectRandomUser(user1, user2, user3);
  }
}

