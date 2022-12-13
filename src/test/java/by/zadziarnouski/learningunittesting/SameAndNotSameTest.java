package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class SameAndNotSameTest {

    @Test
    void test() {
        String str = new String("foo");
        Utils utils = new Utils();

        assertSame(utils.getFoo(), utils.getFooDuplicate(), "Objects should refer to same object");
        assertNotSame(str, utils.getFoo(), "Objects should not refer to same object");
    }
}
