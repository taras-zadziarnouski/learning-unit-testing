package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderTest {
    @Test
    void firstTest() {

    }

    //    @Order() annotation does not override strategy below, because for the annotation has special strategy
    //    "MethodOrderer.OrderAnnotation.class". Lowest number has the highest priority.
    @Test
    @Order(-2)
    void secondTest() {

    }

    @Test
    void thirdTest() {

    }
}
