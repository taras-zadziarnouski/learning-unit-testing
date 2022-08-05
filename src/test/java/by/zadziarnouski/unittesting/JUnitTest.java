package by.zadziarnouski.unittesting;

import static by.zadziarnouski.unittesting.util.StringUtils.isPalindrome;
import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import by.zadziarnouski.unittesting.extension.CustomCallback;
import by.zadziarnouski.unittesting.extension.CustomExecutionCondition;
import by.zadziarnouski.unittesting.extension.CustomParameterResolver;
import by.zadziarnouski.unittesting.extension.CustomTestPostProcessor;
import by.zadziarnouski.unittesting.extension.IgnoreFileNotFoundExceptionHandler;
import by.zadziarnouski.unittesting.model.User;
import by.zadziarnouski.unittesting.util.MathUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Slf4j
@ExtendWith({
    CustomTestPostProcessor.class,
    CustomExecutionCondition.class,
    CustomCallback.class,
    IgnoreFileNotFoundExceptionHandler.class})
class JUnitTest {

  @BeforeAll
  static void setup() {
    log.info("@BeforeAll - executes once before all unittesting methods in this class");
  }

  @AfterAll
  static void done() {
    log.info("@AfterAll - executed after all unittesting methods.");
  }

  @BeforeEach
  void init() {
    log.info("@BeforeEach - executes before each unittesting method in this class");
  }

  @AfterEach
  void tearDown() {
    log.info("@AfterEach - executed after each unittesting method.");
  }

  @Test
  @DisplayName("Single unittesting successful")
  void simpleTest() {
    assertEquals(2, MathUtils.add(1, 1), "1 + 1 should equal 2");
  }

  @ParameterizedTest()
  @CsvSource({
      "0, 1, 1",
      "1, 2, 3",
      "49, 51, 100",
      "1, 100, 101"
  })
  void parameterizedTest(int first, int second, int expectedResult) {
    assertEquals(expectedResult, MathUtils.add(first, second),
        () -> first + " + " + second + " should equal " + expectedResult);
  }

  @Test
  void timeoutExceeded() {
    assertTimeout(ofMillis(10), () -> {
      Thread.sleep(9);
    });
  }

  @Test
  void timeoutExceededWithPreemptiveTermination() {
    assertTimeoutPreemptively(ofMillis(10), () -> {
      new CountDownLatch(1).await();
    });
  }

  @Test
  void shouldThrowException() {
    Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
      throw new UnsupportedOperationException("Not supported");
    });
    assertEquals("Not supported", exception.getMessage());
  }

  @Test
  void assertThrowsException() {
    String str = null;
    assertThrows(IllegalArgumentException.class, () -> {
      Integer.valueOf(str);
    });
  }

  @TestFactory
  Collection<DynamicTest> dynamicTestsFromCollection() {
    return Arrays.asList(
        dynamicTest("1st dynamic unittesting", () -> assertTrue(isPalindrome("madam"))),
        dynamicTest("2nd dynamic unittesting", () -> assertEquals(4, MathUtils.multiply(2, 2)))
    );
  }

  @Test
  void dependentAssertions() {
    assertAll("heading", () -> {
      assertTrue(isPalindrome("madam"));
      assertAll("heading", () -> {
        assertEquals(4, MathUtils.multiply(2, 2));
      });
    });
  }

  @Test
  void assertWithAssuming() {
    assumingThat("CI".equals(System.getenv("ENV")),
        () -> {
          assertEquals(4, MathUtils.add(2, 2));
        });
    assertEquals(42, MathUtils.multiply(6, 7));
  }

  @Test
  @ExtendWith(CustomParameterResolver.class)
  void paramResolverTest(User user) {
    assertEquals(1L, user.getId());
    assertEquals("Foo", user.getFirstName());
    assertEquals("Bar", user.getLastName());
  }

  @RepeatedTest(3)
  @Timeout(1)
  void repeatedTest() {
    assertEquals(2, MathUtils.add(1, 1));
  }

  @Test
  @Disabled("Not implemented yet")
  void disabledTest() {
  }
}