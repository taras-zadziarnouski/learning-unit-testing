package by.zadziarnouski.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.answerVoid;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import by.zadziarnouski.unittesting.model.User;
import by.zadziarnouski.unittesting.repository.UserRepository;
import by.zadziarnouski.unittesting.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockitoTest {

  @InjectMocks
  private UserService userService;

  @Mock(answer = Answers.RETURNS_DEFAULTS)
  private UserRepository userRepository;

  @Captor
  ArgumentCaptor<User> userArgumentCaptor;


  @Test
  void givenSaveMethodMocked_whenSaveInvoked_ThenReturnFirstArgument_UnitTest() {
    //Given
    User user = new User(1L, "Tim", "Lee", 23);
    when(userRepository.save(any(User.class))).then(AdditionalAnswers.returnsFirstArg());


    //When
    User savedUser = userRepository.save(user);
    verify(userRepository).save(userArgumentCaptor.capture());

    //Then
    assertEquals(user, savedUser);
    assertEquals(user,userArgumentCaptor.getValue());
  }

  @Test
  void givenCheckifEqualsMethodMocked_whenCheckifEqualsInvoked_ThenReturnSecondArgument_UnitTest() {
    User user1 = new User(1L, "Jack", "Camus", 40);
    User user2 = new User(2L, "George", "Orwell", 26);
    User user3 = new User(3L, "William", "Shakespeare", 35);

    when(userRepository.selectRandomUser(any(User.class), any(User.class), any(User.class)))
        .then(AdditionalAnswers.returnsArgAt(1));

    User secondUser = userService.selectRandomUser(user1, user2, user3);

    assertEquals(secondUser, user2);
  }

  @Test
  void givenMockedMethod_whenMethodInvoked_thenReturnVoid() {
    Long id = 2L;
    when(userRepository.findByUserId(anyLong())).thenAnswer(answerVoid(MockitoTest::printUserId));

    userService.findUserById(id);

    verify(userRepository, times(1)).findByUserId(id);
  }

  private static void printUserId(Long userId) {
    System.out.println(userId);
  }
}