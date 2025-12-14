package com.matrixCalculator;

import java.util.ArrayList;

/**
 * Класс, содержащий статические методы для выполнения операций над матрицами.
 */
public class MatrixOperations {

    /**
     * Проверяет, имеют ли две матрицы одинаковые размеры.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     * @return true, если размеры совпадают, иначе false
     */
    public static boolean haveSameDimensions(Matrix firstMatrix, Matrix secondMatrix) {
        return (firstMatrix.getRows() == secondMatrix.getRows() &&
                firstMatrix.getCols() == secondMatrix.getCols());
    }

    /**
     * Складывает две матрицы.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     * @return новая матрица — результат сложения
     * @throws IllegalArgumentException если матрицы некорректны или имеют разные размеры
     */
    public static Matrix addition(Matrix firstMatrix, Matrix secondMatrix) {
        if (!firstMatrix.isValid() || !secondMatrix.isValid()) {
            throw new IllegalArgumentException("Одна из матриц некорректна, проверьте файлы.");
        }

        if (!MatrixOperations.haveSameDimensions(firstMatrix, secondMatrix)) {
            throw new IllegalArgumentException("Для сложения и вычитания матриц необходимо, " +
                    "чтобы они были одинакового размера.");
        }

        ArrayList<ArrayList<Double>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < firstMatrix.getRows(); i++) {
            ArrayList<Double> newRow = new ArrayList<>();
            for (int j = 0; j < firstMatrix.getCols(); j++) {
                newRow.add(firstMatrix.getElement(i, j) + secondMatrix.getElement(i, j));
            }
            resultMatrix.add(newRow);
        }
        return new Matrix(resultMatrix);
    }

    /**
     * Вычитает вторую матрицу из первой.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     * @return новая матрица — результат вычитания
     * @throws IllegalArgumentException если матрицы некорректны или имеют разные размеры
     */
    public static Matrix subtract(Matrix firstMatrix, Matrix secondMatrix) {
        if (!firstMatrix.isValid() || !secondMatrix.isValid()) {
            throw new IllegalArgumentException("Одна из матриц некорректна, проверьте файлы.");
        }

        if (!MatrixOperations.haveSameDimensions(firstMatrix, secondMatrix)) {
            throw new IllegalArgumentException("Для сложения и вычитания матриц необходимо, " +
                    "чтобы они были одинакового размера.");
        }

        ArrayList<ArrayList<Double>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < firstMatrix.getRows(); i++) {
            ArrayList<Double> newRow = new ArrayList<>();
            for (int j = 0; j < firstMatrix.getCols(); j++) {
                newRow.add(firstMatrix.getElement(i, j) - secondMatrix.getElement(i, j));
            }
            resultMatrix.add(newRow);
        }
        return new Matrix(resultMatrix);
    }

    /**
     * Умножает первую матрицу на вторую.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     * @return новая матрица — результат умножения
     * @throws IllegalArgumentException если матрицы некорректны или размеры несовместимы
     */
    public static Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) {
        if (!firstMatrix.isValid() || !secondMatrix.isValid()) {
            throw new IllegalArgumentException("Одна из матриц некорректна, проверьте файлы.");
        }

        if (firstMatrix.getCols() != secondMatrix.getRows()) {
            throw new IllegalArgumentException("Для перемножения матриц необходимо, " +
                    "чтобы количество столбцов первой матрицы было равно количеству строк второй матрицы");
        }

        ArrayList<ArrayList<Double>> resultMatrix = new ArrayList<>();
        for (int i = 0; i < firstMatrix.getRows(); i++) {
            ArrayList<Double> newRow = new ArrayList<>();
            for (int j = 0; j < secondMatrix.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < firstMatrix.getCols(); k++) {
                    sum += firstMatrix.getElement(i, k) * secondMatrix.getElement(k, j);
                }
                newRow.add(sum);
            }
            resultMatrix.add(newRow);
        }
        return new Matrix(resultMatrix);
    }

    /**
     * Возвращает минор матрицы, полученный удалением заданной строки и столбца.
     *
     * @param matrix      исходная матрица
     * @param excludedRow индекс строки, которую нужно исключить
     * @param excludedCol индекс столбца, который нужно исключить
     * @return новая матрица — минор
     */
    public static Matrix getMinor(Matrix matrix, int excludedRow, int excludedCol) {
        ArrayList<ArrayList<Double>> minorMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.getRows(); i++) {
            if (i == excludedRow) {
                continue;
            }
            ArrayList<Double> newRow = new ArrayList<>();
            for (int j = 0; j < matrix.getCols(); j++) {
                if (j == excludedCol) {
                    continue;
                }
                newRow.add(matrix.getElement(i, j));
            }
            minorMatrix.add(newRow);
        }
        return new Matrix(minorMatrix);
    }

    /**
     * Вычисляет определитель квадратной матрицы.
     *
     * @param matrix квадратная матрица
     * @return значение определителя
     * @throws IllegalArgumentException если матрица некорректна или не квадратная
     */
    public static double determinant(Matrix matrix) {
        if (!matrix.isValid()) {
            throw new IllegalArgumentException("Матрица некорректна, проверьте файл.");
        }

        if (!matrix.isSquare()) {
            throw new IllegalArgumentException("Для нахождения определителя матрицы необходимо, " +
                    "чтобы матрица была квадратная");
        }

        int numRows = matrix.getRows();

        if (numRows == 1) {
            return matrix.getElement(0, 0);
        }

        double determinant = 0;
        for (int i = 0; i < numRows; i++) {
            Matrix minorMatrix = getMinor(matrix, 0, i);
            double c = Math.pow(-1, i) * matrix.getElement(0, i);
            determinant += c * determinant(minorMatrix);
        }
        return determinant;
    }
}
