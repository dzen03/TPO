package com.dzen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LogarithmicFunctionsTest {
    double epsilon = 1e-5;

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.15, 0.4, 1, 2, 10})
    public void testLn() {
        assertEquals(Math.log(1), LogarithmicFunctions.ln(1, epsilon), epsilon);
        assertEquals(Math.log(2), LogarithmicFunctions.ln(2, epsilon), epsilon);
        assertEquals(Math.log(Math.E), LogarithmicFunctions.ln(Math.E, epsilon), epsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.15, 0.4, 0.5, 1, 10})
    public void testLog2(double x) {
        assertEquals(Math.log(x) / Math.log(2), LogarithmicFunctions.log2(x, epsilon), epsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.15, 1./3, 0.5, 1, 10})
    public void testLog3(double x) {
        assertEquals(Math.log(x) / Math.log(3), LogarithmicFunctions.log3(x, epsilon), epsilon);
    }
}

