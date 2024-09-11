package com.dzen;

public class LogarithmicFunctions {

    // Функция ln(x) через разложение в ряд
    public static double ln(double x, double epsilon) {
        if (x <= 0) throw new IllegalArgumentException("x должен быть > 0");
        double result = 0;
        double term = (x - 1) / (x + 1);
        double termSq = term * term;
        double denom = 1;
        while (Math.abs(term / denom) > epsilon / 10) {
            result += term / denom;
            term *= termSq;
            denom += 2;
        }
        return 2 * result;
    }

    // Логарифм по основанию 2
    public static double log2(double x, double epsilon) {
        return ln(x, epsilon) / ln(2, epsilon);
    }

    // Логарифм по основанию 3
    public static double log3(double x, double epsilon) {
        return ln(x, epsilon) / ln(3, epsilon);
    }
}

