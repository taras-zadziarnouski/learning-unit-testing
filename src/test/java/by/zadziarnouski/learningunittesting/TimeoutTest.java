package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class TimeoutTest {

    @Test
    @Timeout(1)
    void testTimeout() {
        // fails if execution time exceeds 1 seconds
    }

    @Test
    void testTimeoutPreemptively() {
        Utils utils = new Utils();

        // fails if execution time exceeds 3 seconds
        assertTimeoutPreemptively(Duration.ofSeconds(3), utils::checkTimeout, "Method should execute in 3 seconds");
    }
}
