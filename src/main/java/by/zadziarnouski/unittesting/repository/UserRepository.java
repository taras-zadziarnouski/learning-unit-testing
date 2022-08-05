package by.zadziarnouski.unittesting.repository;

import by.zadziarnouski.unittesting.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserRepository {

  public User findByUserId(Long userId) {
    return new User(userId, "Foo", "Bar", 15);
  }

  public User save(User user) {
    return new User(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
  }

  public User selectRandomUser(User userOne, User userTwo, User userThree) {
    List<User> selection = new ArrayList<>();
    selection.add(userOne);
    selection.add(userTwo);
    selection.add(userThree);
    Random random = new Random();
    return selection.get(random.nextInt(selection.size()));
  }
}
