package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThrowsAndDoesNotThrowTest {

    @Test
    void testThrowsAndDoesNotThrow() {
        Utils utils = new Utils();

        assertThrows(Exception.class, () -> utils.throwException(-1), "Should throw exception");
        assertDoesNotThrow(() -> utils.throwException(5), "Should throw exception");
    }
}
