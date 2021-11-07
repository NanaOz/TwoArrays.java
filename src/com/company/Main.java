package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        conclusion();
    }

    public static void conclusion() {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a;
        a = new int[n][m];
        a = fillWhithRandomeTwo(a, 0, 50);
        printArray(a);
        a = task6ReflectArray(a);
        printArray(a);


    }


    public static int[][] fillWhithRandomeTwo(int[][] a, int start, int end) {
        // write your code here
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                Random rnd = new Random();
                a[i][j] = rnd.nextInt(end - start) + start;
            }
        }
        return a;

    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + ", ");
            System.out.println();
        }
    }

    //Найти минимальный элемент массива
    public static int task1FindMinInArray(int[][] a) {
        // write your code here
        int min = a[0][0];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (a[i][j] < min) {
                    min = a[i][j];
                }
        return min;
    }

    //Найти максимальный элемент массива
    public static int task2FindMaxInArray(int[][] a) {
        // write your code here
        int max = a[0][0];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (a[i][j] > max) {
                    max = a[i][j];
                }
        return max;
    }

    //Найти индекс минимального элемента массива
    public static String task3FindIndexMinElementArray(int[][] a) {
        int min = a[0][0];
        int indexForMinI = 0;
        int indexForMinJ = 0;
        String indexMinIJ = null;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                    indexForMinI = i;
                    String indexMinI = String.valueOf(indexForMinI);
                    indexForMinJ = j;
                    String indexMinJ = String.valueOf(indexForMinJ);
                    indexMinIJ = "Строка [" + indexMinI + "], столбец [" + indexMinJ + "]";
                }
            }
        }
        return indexMinIJ;
    }

    //Найти индекс максимального элемента массива
    public static String task4FindIndexMaxElementArray(int[][] a) {
        int max = a[0][0];
        int indexForMaxI = 0;
        int indexForMaxJ = 0;
        String indexMaxIJ = null;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    indexForMaxI = i;
                    String indexMaxI = String.valueOf(indexForMaxI);
                    indexForMaxJ = j;
                    String indexMinJ = String.valueOf(indexForMaxJ);
                    indexMaxIJ = "Строка [" + indexMaxI + "], столбец [" + indexMinJ + "]";
                }
            }
        }
        return indexMaxIJ;
    }

    //Найти количество элементов массива, которые больше всех своих соседей одновременно
    public static int task5findAmount(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                boolean flag = true;
                if (i - 1 >= 0 && a[i - 1][j] > a[i][j]) flag = false;
                if (j - 1 >= 0 && a[i][j - 1] > a[i][j]) flag = false;
                if (i + 1 <= (a.length - 1) && a[i + 1][j] > a[i][j]) flag = false;
                if (j + 1 <= (a[i].length - 1) && a[i][j + 1] > a[i][j]) flag = false;
                if (flag) {
                    sum++;
                }
            }
        }
        return sum;
    }


    //Отразите массив относительно его главной диагонали
    public static int[][] task6ReflectArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        return a;
    }

    //Дана вещественная матрица размерности n * m.
    // По матрице получить логический вектор, присвоив его k-ому элементу значение True ,
    // если выполнено указанное условие и значение False иначе:
    // - все элементы k столбца нулевые;
    // - элементы k строки матрицы упорядочены по убыванию;
    // - k строка массива симметрична.
    public static void printVector(boolean[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static boolean[] task7getVectorA(int[][] a) {
        boolean[] vector = new boolean[a.length];
        boolean flag;
        for (int i = 0; i < a.length; i++) {
            flag = true;
            for (int j = 0; j < a[i].length; j++) {
                if (a[j][i] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                vector[i] = true;
        }
        return vector;
    }

    public static boolean[] task7getVectorB(int[][] a) {
        boolean[] vector = new boolean[a.length];
        boolean flag;
        for (int i = 0; i < a.length; i++) {
            flag = true;
            for (int j = 1; j < a[i].length; j++) {
                if (a[i][j] > a[i][j - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                vector[i] = true;
        }
        return vector;
    }

    public static boolean[] task7getVectorC(int[][] a) {
        boolean[] vector = new boolean[a.length];
        boolean flag;
        for (int i = 0; i < a.length; i++) {
            flag = true;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != a[i][a.length - 1 - j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                vector[i] = true;
        }
        return vector;
    }

    //Дан двухмерный массив A[1..m,1..n].
    // Написать программу построения одномерного массива B[1..m],
    // элементы которого соответственно равны
    // а) суммам элементов строк,
    // б) произведениям элементов строк,
    // в) наименьшим средних арифметических элементов строк.
    public static int[] task8getArrayA(int[][] a) {
        int[] array = new int[a.length];
        int sum;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
            array[i] = sum;
        }
        return array;
    }

    public static int[] task8getArrayB(int[][] a) {
        int[] array = new int[a.length];
        int increase;
        for (int i = 0; i < a.length; i++) {
            increase = 1;
            for (int j = 0; j < a[i].length; j++) {
                increase *= a[i][j];
            }
            array[i] = increase;
        }
        return array;
    }

    public static double[] task8getArrayC(int[][] a) {
        double[] array = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            double average = 0;
            for (int j = 0; j < a[i].length; j++) {
                average += a[i][j];
            }
            average /= a.length;
            array[i] = average;
        }
        return array;
    }

    //В массиве А[1..N,1..N] определить номера строки и столбца какой-нибудь седловой точки.
    // Некоторый элемент массива называется седловой точкой,
    // если он является одновременно наименьшим в своей строке
    // и наибольшим в своем столбце.
    public static void task9SaddlePoint(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                boolean flag = true;
                for (int k = 0; k < a.length; k++) {
                    if (a[i][k] < a[i][j]) {
                        flag = false;
                        break;
                    }
                }
                for (int k = 0; k < a.length; k++) {
                    if (a[k][j] > a[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Седловая точка [" + i + "][" + j + "]");
                }
            }
        }
    }

    //Массив А[1..5,1..7] содержит вещественные числа.
    // Требуется ввести целое число K и вычислить сумму элементов А[I,J],
    // для которых I+J=К.
    // Прежде, однако следует убедиться, что значение К позволяет найти решение,
    // в противном случае нужно напечатать сообщение об ошибке.
    public static void task10SumElement(int[][] a) {
        Scanner in = new Scanner(System.in);
        int n = 5, m = 7;
        int K = in.nextInt();
        if (n - 1 + n - 1 >= K) {
            double sum = 0.0;
            for (int i = 0; i < n && i <= K; i++)
                sum += a[i][K - i];
            System.out.println("Sum = " + sum);
        }
        else {
            System.out.println("Таких элементов нет");
        }
    }

    //Дана матрица NxM. Переставляя ее строки и столбцы,
    // переместить наибольший элемент в верхний левый угол.
    // Определить можно ли таким же образом поместить минимальный элемент в нижний правый угол.
    public static void task11(int[][] a) {
        int maxI = 0, maxJ = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] > a[maxI][maxJ]) {
                    maxI = i;
                    maxJ = j;
                }
        if (maxI != 0)
            for (int j = 0; j < a.length; j++) {
                int temp = a[0][j];
                a[0][j] = a[maxI][j];
                a[maxI][j] = temp;
            }
        if (maxJ != 0)
            for (int i = 0; i < a.length; i++) {
                int temp = a[i][0];
                a[i][0] = a[i][maxJ];
                a[i][maxJ] = temp;
            }
        System.out.println(" " + "Наибольший элемент в верхнем левый углу");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        int minI = 0, minJ = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] < a[minI][minJ]) {
                    minI = i;
                    minJ = j;
                }
        if (minI != 0 && minJ != 0) {
            System.out.println("минимальный элемент можно поместить таким же образом в нижний правый угол");
        }
    }

    //Заполнить двухмерный массив Т[1..n,1..n] последовательными целыми числами от 1,
    // расположенными по спирали, начиная с левого верхнего угла и продвигаясь по часовой стрелке:
    public static void task12(String[] args) {
        int n = 6;
        int a[][] = new int[n][n];
        int k = 1;
        int i = 0;
        int j = 0;
        while (k <= n * n) {
            a[i][j] = k;
            if (i <= j + 1 && i + j < n - 1) ++j;
            else if (i < j && i + j >= n - 1) ++i;
            else if (i >= j && i + j > n - 1) --j;
            else --i;
            ++k;
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
