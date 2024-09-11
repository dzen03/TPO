package com.dzen;

public class TrigonometricFunctions {

    // Функция sin(x) с помощью разложения в ряд Тейлора
    public static double sin(double x, double epsilon) {
        double term = x;  // Первое слагаемое в ряде
        double result = term;
        int n = 1;
        while (Math.abs(term) > epsilon / 10) {
            term *= (-1) * x * x / ((2 * n) * (2 * n + 1));
            result += term;
            n++;
        }
        return result;
    }

    // Функция sec(x) = 1 / cos(x) через разложение косинуса
    public static double sec(double x, double epsilon) {
        return 1 / cos(x, epsilon);
    }

    // Функция cos(x) = sin(x + pi/2)
    public static double cos(double x, double epsilon) {
        return sin(x + Math.PI / 2, epsilon);
    }
}

