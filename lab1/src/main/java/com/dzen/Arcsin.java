package com.dzen;

public class Arcsin {
    public static double arcsin(double x, int terms) {
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("x должен быть в диапазоне [-1, 1]");
        }

        double result = x;
        double term = x;
        for (int n = 1; n < terms; n++) {
            term *= x * x * (2 * n - 1) / (2 * n);
            result += term / (2 * n + 1);
        }
        return result;
    }
}
