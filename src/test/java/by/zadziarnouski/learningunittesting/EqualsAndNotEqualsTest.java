package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EqualsAndNotEqualsTest {

    @Test
    void addTest() {
//        given
        Utils utils = new Utils();
        int x = 1;
        int y = 2;

//        when
        int actual = utils.add(x, y);

//        then
        assertEquals(x + y, actual, "1+2 must be 3");

//        OR
//        when & then
//        assertEquals(x + y, demoUtils.add(x, y), "1+2 must be 3");
    }

    @Test
    void multiplyTest() {
//        given
        Utils utils = new Utils();
        int x = 3;
        int y = 5;

//        when
        int actual = utils.multiply(x, y);

//        then
        assertEquals(x * y, actual, "3*5 must be 15");
    }
}
