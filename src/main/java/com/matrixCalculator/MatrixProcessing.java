package com.matrixCalculator;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс, отвечающий за обработку пользовательского ввода и выполнение операций.
 */
public class MatrixProcessing {
    static Scanner scanner = new Scanner(System.in);

    /**
     * Выполняет сложение двух матриц и выводит результат.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     */
    public static void addition(Matrix firstMatrix, Matrix secondMatrix) {
        try {
            String sum = MatrixOperations.addition(firstMatrix, secondMatrix).toString();
            System.out.println("Результат сложения матриц.");
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Выполняет вычитание второй матрицы из первой и выводит результат.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     */
    public static void subtract(Matrix firstMatrix, Matrix secondMatrix) {
        try {
            String sub = MatrixOperations.subtract(firstMatrix, secondMatrix).toString();
            System.out.println("Результат вычитания матриц.");
            System.out.println(sub);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Выполняет умножение первой матрицы на вторую и выводит результат.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     */
    public static void multiply(Matrix firstMatrix, Matrix secondMatrix) {
        try {
            String mul = MatrixOperations.multiply(firstMatrix, secondMatrix).toString();
            System.out.println("Результат умножения матриц.");
            System.out.println(mul);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Вычисляет и выводит определитель заданной матрицы.
     *
     * @param matrix матрица, определитель которой нужно вычислить
     */
    public static void determinant(Matrix matrix) {
        System.out.println("Определитель вычисляется...");
        try {
            double det = MatrixOperations.determinant(matrix);
            System.out.println("Определитель матрицы: " + det);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Загружает матрицу из файла, указанного пользователем.
     *
     * @return загруженная матрица
     */
    public static Matrix loadMatrix() {
        do {
            try {
                String fileNameMatrix = scanner.nextLine();
                Matrix matrix = new Matrix(MatrixFileReader.readFromFile(fileNameMatrix));
                return matrix;
            } catch (IOException e) {
                System.out.println("Не удалось загрузить матрицу. " + e.getMessage() + " Попробуйте снова.");
            }
        } while (true);
    }

    /**
     * Считывает целочисленный выбор пользователя из консоли.
     *
     * @return выбор пользователя (целое число)
     */
    public static int getUserChoice() {
        while (true) {
            try {
                 int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Неизвестная команда. Введите корректный номер команды 0-7.");
                scanner.nextLine();
            }
        }
    }
}
