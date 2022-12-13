package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrueOrFalseTest {
    @Test
    void test() {
        Utils utils = new Utils();
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(utils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(utils.isGreater(gradeTwo, gradeOne), "This should return false");
    }
}
