package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NullAndNotNullTest {

    @Test
    void test() {
//        given
        String str1 = null;
        String str2 = "foo";
        Utils utils = new Utils();

//        when & then
        assertNull(utils.checkNull(str1), "Object should be null");
        assertNotNull(utils.checkNull(str2), "Object should not be null");
    }
}
