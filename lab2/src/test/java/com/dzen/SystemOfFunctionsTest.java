package com.dzen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemOfFunctionsTest {


    @ParameterizedTest
    @CsvSource({
            "0.1, 2.03589",
            "0.35, 0.513127",
            "0.5, 0.297645",
            "1.5, 0.017232",
            "3, 0",
            "5, -0.0068973"
    })
    public void computeLogarithmicTest(double x, double y) {
        double epsilon = 1e-5;
        assertEquals(y, SystemOfFunctions.computeLogarithmic(x, epsilon), epsilon);
    }

    @ParameterizedTest

    @MethodSource("generateData")
    public void computeTrigonometricTest(double x, double y) {
        double epsilon = 1e-5;
        assertEquals(y, SystemOfFunctions.computeTrigonometric(x, epsilon), epsilon);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(-Math.PI, 0),
                Arguments.of(-3 * Math.PI / 4, 1),
                Arguments.of(-Math.PI / 2, 0),
                Arguments.of(-Math.PI / 4, -1./3),
                Arguments.of(0, Double.NaN)
        );
    }
}
