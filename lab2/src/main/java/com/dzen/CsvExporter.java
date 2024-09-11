package com.dzen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class CsvExporter {

    public static void exportToCsv(Function<Double, Double> func, double startX, double endX, double step, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("X,Result\n");  // Заголовки CSV файла
            for (double x = startX; x <= endX; x += step) {
                double result;
                try {
                    result = func.apply(x);
                } catch (Exception e) {
                    result = Double.NaN;  // Если функция не определена на данном X
                }
                writer.write(x + "," + result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

