package by.zadziarnouski.learningunittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EqualsAndNotEqualsArraysIterableLinesTest {

    Utils utils;

    @BeforeEach
    void setUp() {
        utils = new Utils();
    }

    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, utils.getFirstThreeLettersOfAlphabet(), "Arrays should be the same");
    }

    @Test
    void testIterableEquals() {
        List<String> list = List.of("foo", "bar");

        assertIterableEquals(list, utils.getFooBarInList(), "Expected list should be the same as actual list");
    }

    @Test
    void testLinesMatch() {
        List<String> list = List.of("foo", "bar");

        assertLinesMatch(list, utils.getFooBarInList(), "Lines should match");
    }
}
