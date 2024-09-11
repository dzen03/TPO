package com.dzen;

public class Main {

    public static void main(String[] args) {
        double epsilon = 1e-5, step = 0.1;

        // logarithmic
        CsvExporter.exportToCsv(x -> LogarithmicFunctions.ln(x, epsilon), step, 10, step, "csv/ln.csv");
        CsvExporter.exportToCsv(x -> LogarithmicFunctions.log2(x, epsilon), step, 10, step, "csv/log2.csv");
        CsvExporter.exportToCsv(x -> LogarithmicFunctions.log3(x, epsilon), step, 10, step, "csv/log3.csv");


        CsvExporter.exportToCsv(x -> SystemOfFunctions.computeLogarithmic(x, epsilon), step, 10, step, "csv/all_log.csv");


        // trigonometric
        CsvExporter.exportToCsv(x -> TrigonometricFunctions.sin(x, epsilon), -2 * Math.PI, 0, step, "csv/sin.csv");
        CsvExporter.exportToCsv(x -> TrigonometricFunctions.cos(x, epsilon), -2 * Math.PI, 0, step, "csv/cos.csv");
        CsvExporter.exportToCsv(x -> TrigonometricFunctions.sec(x, epsilon), -2 * Math.PI, 0, step, "csv/sec.csv");


        CsvExporter.exportToCsv(x -> SystemOfFunctions.computeTrigonometric(x, epsilon), -2 * Math.PI, 0, step, "csv/all_trig.csv");


        // final
        CsvExporter.exportToCsv(x -> SystemOfFunctions.compute(x, epsilon), -Math.PI, 10, step, "csv/func.csv");
    }
}
