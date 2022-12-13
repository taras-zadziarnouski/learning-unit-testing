package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {

    /**
     * Just disabled
     */
    @Test
    @Disabled("Do not run until JIRA #123 is resolved")
    void basicTest() {
//        some code
    }

    /**
     * Enable depending on OS
     */
    @Test
//    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnOs(OS.LINUX)
    void testForSpecificOS() {
//        some code
    }

    /**
     * Enable depending on JRE version
     */
    @Test
    @EnabledOnJre(JRE.JAVA_18)
    void testOnlyForJava18() {
//        some code
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_15)
    void testOnlyForJavaRange() {
//        some code
    }

    /**
     * Enable depending on system property or environment variable
     */
    @Test
    @EnabledIfSystemProperty(named = "user.timezone", matches = "Europe/Warsaw")
    void testOnlyForSystemProperty() {
//        some code
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "HOME", matches = "/home/taraszadziarnouski")
    void testOnlyForEnvironmentVariable() {
//        some code
    }
}
