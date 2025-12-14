package com.matrixCalculator;

import java.util.ArrayList;

/**
 * Класс, представляющий матрицу вещественных чисел.
 */
public class Matrix {
    private ArrayList<ArrayList<Double>> data;

    /**
     * Конструктор, инициализирующий матрицу из двумерного списка.
     *
     * @param matrixData двумерный список, содержащий элементы матрицы
     */
    public Matrix(ArrayList<ArrayList<Double>> matrixData) {
        this.data = new ArrayList<>();
        for (ArrayList<Double> row : matrixData) {
            this.data.add(new ArrayList<>(row));
        }
    }

    /**
     * Проверяет, является ли матрица корректной (не пустая и все строки одинаковой длины).
     *
     * @return true, если матрица корректна, иначе false
     */
    public boolean isValid() {
        if (data.isEmpty()) {
            return false;
        }
        int cols = data.get(0).size();
        for (ArrayList<Double> row : data) {
            if (row.size() != cols) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет, является ли матрица квадратной.
     *
     * @return true, если количество строк равно количеству столбцов, иначе false
     */
    public boolean isSquare() {
        int numRows = data.size();
        for (ArrayList<Double> datum : data) {
            if (numRows != datum.size()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает элемент матрицы по индексам строки и столбца.
     *
     * @param row индекс строки (начиная с 0)
     * @param col индекс столбца (начиная с 0)
     * @return значение элемента матрицы
     */
    public double getElement(int row, int col) {
        return data.get(row).get(col);
    }

    /**
     * Возвращает количество столбцов в матрице.
     *
     * @return число столбцов
     * @throws NullPointerException если матрица пуста
     */
    public int getCols() {
        if (!data.isEmpty()) {
            return data.get(0).size();
        }
        throw new NullPointerException("Матрица пустая");
    }

    /**
     * Возвращает строковое представление матрицы.
     *
     * @return строка, содержащая элементы матрицы в табличном виде
     */
    public int getRows() {
        if (!data.isEmpty()) {
            return data.size();
        }
        throw new NullPointerException("Матрица пустая");
    }

    /**
     * Возвращает строковое представление матрицы.
     *
     * @return строка, содержащая элементы матрицы в табличном виде
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (ArrayList<Double> row : data) {
            for (double val : row) {
                builder.append(val).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
