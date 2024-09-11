package com.dzen;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArcsinTest {

    @ParameterizedTest
    @CsvSource({
            "0, 10, 0",
            "1, 10000000, 1.5708", // Math.PI / 2
            "-1, 10000000, -1.5708", // -Math.PI / 2
            "0.5, 10000000, 0.5236" // Math.PI / 6
    })
    public void testArcsin(double input, int terms, double expected) {
        assertEquals(expected, Arcsin.arcsin(input, terms), 1e-3);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2, -2})
    public void testArcsinOutsideRange(double input) {
        assertThrows(IllegalArgumentException.class, () -> Arcsin.arcsin(input, 10));
    }

    @ParameterizedTest
    @CsvSource({
            "0.5, 100",
            "0.1, 100"
    })
    public void testArcsinConvergence(double input, int terms) {
        assertEquals(Math.asin(input), Arcsin.arcsin(input, terms), 1e-9);
    }
}
