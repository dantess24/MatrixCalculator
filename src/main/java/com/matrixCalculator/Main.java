package com.matrixCalculator;

/**
 * Главный класс приложения, запускающий интерактивное меню для работы с матрицами.
 */
public class Main {

    /**
     * Отображает меню команд для пользователя.
     */
    private static void showMenu() {
        System.out.println("-----Список команд-----");
        System.out.println("1. Сложение.");
        System.out.println("2. Вычитание.");
        System.out.println("3. Умножение.");
        System.out.println("4. Нахождение определителя первой матрицы.");
        System.out.println("5. Нахождение определителя второй матрицы.");
        System.out.println("6. Загрузить новые матрицы.");
        System.out.println("7. Вывести матрицы на экран.");
        System.out.println("0. Выход.");
    }

    /**
     * Выводит обе матрицы на экран.
     *
     * @param firstMatrix  первая матрица
     * @param secondMatrix вторая матрица
     */
    private static void showMatrices(Matrix firstMatrix, Matrix secondMatrix) {
        System.out.println("Первая матрица: ");
        System.out.println(firstMatrix);
        System.out.println("Вторая матрица: ");
        System.out.println(secondMatrix);
    }

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        System.out.println("Перед началом работы необходимо загрузить матрицы. " + "\n" +
                "Переместите файлы с матрицами в одну папку с проектом.");

        System.out.println("Укажите название файла первой матрицы. Например \"firstMatrix.txt\"");
        Matrix firstMatrix = MatrixProcessing.loadMatrix();
        System.out.println("Теперь укажите название файла второй матрицы. Например \"secondMatrix.txt\"");
        Matrix secondMatrix = MatrixProcessing.loadMatrix();

        boolean flag = true;
        do {
            showMenu();
            switch (MatrixProcessing.getUserChoice()) {
                case 1:
                    MatrixProcessing.addition(firstMatrix, secondMatrix);
                    break;
                case 2:
                    MatrixProcessing.subtract(firstMatrix, secondMatrix);
                    break;
                case 3:
                    MatrixProcessing.multiply(firstMatrix, secondMatrix);
                    break;
                case 4:
                    MatrixProcessing.determinant(firstMatrix);
                    break;
                case 5:
                    MatrixProcessing.determinant(secondMatrix);
                    break;
                case 6:
                    System.out.println("Укажите название файла первой матрицы. Например \"firstMatrix.txt\"");
                    firstMatrix = MatrixProcessing.loadMatrix();
                    System.out.println("Теперь укажите название файла второй матрицы. Например \"secondMatrix.txt\"");
                    secondMatrix = MatrixProcessing.loadMatrix();
                    break;
                case 7:
                    showMatrices(firstMatrix, secondMatrix);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    flag = false;
                    break;
                default:
                    System.out.println("Неизвестная команда. Введите корректный номер команды 0-7.");
            }
        } while (flag);
    }
}
