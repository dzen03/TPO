package com.dzen;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TrigonometricFunctionsTest {
    double epsilon = 1e-5;

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI / 2, 0})
    public void testSin(double x) {
        assertEquals(Math.sin(x), TrigonometricFunctions.sin(x, epsilon), epsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -3 * Math.PI / 4, -3 * Math.PI / 5, -2 * Math.PI / 5, -Math.PI / 4, 0})
    public void testSec(double x) {
        assertEquals(1 / Math.cos(x), TrigonometricFunctions.sec(x, epsilon), epsilon);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI / 2, 0})
    public void testCos(double x) {
        assertEquals(Math.cos(x), TrigonometricFunctions.cos(x, epsilon), epsilon);
    }
}

