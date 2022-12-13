package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/***
 * Standard - Matches the standard display name generation behavior in place since JUnit Jupiter 5.0 was released.
 * Simple - Removes trailing parentheses for methods with no parameters (test() -> test).
 * ReplaceUnderscores - Replaces underscores with spaces (test_test_test -> test test test).
 * IndicativeSentences - Generates complete sentences by concatenating the names of the test and the enclosing classes. (test() -> ClassName, test())
 * */
@DisplayNameGeneration(DisplayNameTest.ReplaceCameCase.class)
public class DisplayNameTest {

    //@DisplayName manually set test name (override generation strategy below)
    @Test
    @DisplayName("First test - @DisplayName")
    void firstTest() {

    }

    @Test
    void secondTest() {

    }

    @Test
    void thirdTest() {

    }

    //    This is simple implementation of camel case strategy (by default - none)
    static class ReplaceCameCase extends DisplayNameGenerator.Standard {
        public String generateDisplayNameForClass(Class<?> testClass) {
            return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
        }

        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
        }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return this.replaceCapitals(testMethod.getName());
        }

        private String replaceCapitals(String name) {
            name = name.replaceAll("([A-Z])", " $1");
            name = name.replaceAll("([0-9]+)", " $1");
            return name;
        }
    }
}
