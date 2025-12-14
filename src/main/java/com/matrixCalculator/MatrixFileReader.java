package com.matrixCalculator;

import java.io.*;
import java.util.ArrayList;

/**
 * Класс для чтения матрицы из текстового файла.
 */
public class MatrixFileReader {

    /**
     * Считывает матрицу из указанного файла.
     *
     * @param fileName имя файла, содержащего матрицу
     * @return матрица в виде двумерного списка (ArrayList<ArrayList<Double>>)
     * @throws IOException если файл не найден или ошибка ввода-вывода
     * @throws IllegalArgumentException если в файле содержатся некорректные данные
     */
    public static ArrayList<ArrayList<Double>> readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Файл " + fileName + " не найден.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<ArrayList<Double>> matrix = new ArrayList<>();

            String line;
            String[] values;


            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                ArrayList<Double> row = new ArrayList<>();
                values = line.split("\\s+");
                for (int i = 0; i < values.length; i++) {
                    double num = Double.parseDouble(values[i]);
                    row.add(num);
                }

                matrix.add(row);
            }
            return matrix;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректные данные в файле " + fileName, e);
        }
    }
}
