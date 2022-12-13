package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamTest {

    Utils utils;

    @BeforeEach
    void setUp() {
        utils = new Utils();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @Order(1)
    void name(int x) {
        //some code
    }

    @DisplayName("Testing with csv data")
    @ParameterizedTest
//    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvSource({
            "1,1",
            "2,2",
            "3,3",
            "4,4",
            "5,5",
            "6,6",
            "7,7",
    })
    @Order(2)
    void testCsvData(int value, int expected) {
        assertEquals(expected, utils.multiply(value, 1));
    }

    @DisplayName("Testing with csv data from file")
    @ParameterizedTest
//    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/data.csv")
    @Order(3)
    void testCsvDataFromFile(int value, int expected) {
        assertEquals(expected, utils.multiply(value, 1));
    }
}
