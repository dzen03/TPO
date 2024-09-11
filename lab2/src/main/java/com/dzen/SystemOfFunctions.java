package com.dzen;

public class SystemOfFunctions {

    public static double compute(double x, double epsilon) {
        if (x <= 0) {
            return computeTrigonometric(x, epsilon);
        } else {
            return computeLogarithmic(x, epsilon);
        }
    }

    // Тригонометрическая часть для x <= 0
    // (-pi, 0), (-3pi/4, 1), (-pi/2, 0), (-pi/4, -1/3), (0, NaN)
    public static double computeTrigonometric(double x, double epsilon) {
        double sinX = TrigonometricFunctions.sin(x, epsilon);
        double secX = TrigonometricFunctions.sec(x, epsilon);
        return ((Math.pow(sinX, 2)) / (secX - sinX)) / sinX;
    }

    // Логарифмическая часть для x > 0
    // (0.1, 2.03589), (0.35, 0.513127), (0.5, 0.297645), (1.5, 0.017232), (3, 0), (5, -0.0068973)
    public static double computeLogarithmic(double x, double epsilon) {
        double log2X = LogarithmicFunctions.log2(x, epsilon);
        double log3X = LogarithmicFunctions.log3(x, epsilon);
        double lnX = LogarithmicFunctions.ln(x, epsilon);
        return Math.pow(((log2X / log2X) - log3X) * (log3X / (log3X / lnX)) / (log2X + lnX), 3);
    }
}

