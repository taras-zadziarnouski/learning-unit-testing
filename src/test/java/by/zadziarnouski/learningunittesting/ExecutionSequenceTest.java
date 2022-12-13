package by.zadziarnouski.learningunittesting;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
public class ExecutionSequenceTest {

    @BeforeAll
    static void beforeAll() {
        log.info("@BeforeAll - executes once before all test methods in this class (by default must be static).");
    }

    @AfterAll
    static void afterAll() {
        log.info("@AfterAll - executed after all test methods (by default must be static).");
    }

    @BeforeEach
    void setUp() {
        log.info("@BeforeEach - executes before each test method in this class");
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - executed after each unittesting method.");
    }

    @Test
    void firstTest() {
        log.info("Running test: firstTest()");
    }

    @Test
    void secondTest() {
        log.info("Running test: secondTest()");
    }

    @Test
    void thirdTest() {
        log.info("Running test: thirdTest()");
    }
}
