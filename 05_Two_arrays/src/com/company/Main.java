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

    public static String task3FindIndexMinElementArray(int[][] a) {
        int min = a[0][0];
        int indexForMinI = 0;
        int indexForMinJ = 0;
        String indexMinIJ = null;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
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

    public static String task4FindIndexMaxElementArray(int[][] a) {
        int max = a[0][0];
        int indexForMaxI = 0;
        int indexForMaxJ = 0;
        String indexMaxIJ = null;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
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

    public static int task5findAmount(int[][] a, int N, int M) {
        int sum = 0;
        for (int i = 1; i < N - 1; i++) {                                               //для центральных элементов
            for (int j = 1; j < M - 1; j++) {
                if (a[i][j] > a[i - 1][j - 1] && a[i - 1][j] > a[i][j] && a[i][j] > a[i - 1][j + 1] &&
                        a[i][j] > a[i][j - 1] && a[i][j] > a[i][j + 1] &&
                        a[i][j] > a[i + 1][j - 1] && a[i + 1][j] > a[i][j] && a[i][j] > a[i + 1][j + 1]) {
                    sum++;
                }
            }
        }
        for (int i = 1; i < N - 1; i++) {                                        //для боковых элементов справа-слева
            if (a[i][0] > a[i - 1][0] && a[i][0] > a[i - 1][1] && a[i][0] > a[i][1] &&
                    a[i][0] > a[i + 1][0] && a[i][0] > a[i + 1][1] && N > 2) {
                sum++;
            }
            if (a[i][N - 1] > a[i - 1][N - 1] && a[i][N - 1] > a[i - 1][N - 2] && a[i][N - 1] > a[i][N - 2] &&
                    a[i][N - 1] > a[i + 1][N - 1] && a[i][N - 1] > a[i + 1][N - 2] && N > 2) {
                sum++;
            }
        }
        for (int i = 1; i < M - 1; i++) {                                        //для боковых элементов сверху-сниху
            if (a[0][i] > a[0][i - 1] && a[0][i] > a[1][i - 1] && a[0][i] > a[1][i] &&
                    a[0][i] > a[0][i + 1] && a[0][i] > a[1][i + 1] && N > 2) {
                sum++;
            }
            if (a[N - 1][i] > a[N - 1][i - 1] && a[N - 1][i] > a[N - 2][i - 1] && a[N - 1][i] > a[N - 2][i] &&
                    a[N - 1][i] > a[N - 1][i + 1] && a[N - 1][i] > a[N - 2][i + 1] && N > 2) {
                sum++;
            }
        }
        if (a[0][0] > a[0][1] && a[0][0] > a[1][0] && a[0][0] > a[1][1])                      //для угловых элементов
            sum++;
        if (a[N - 1][0] > a[N - 1][1] && a[N - 1][0] > a[N - 2][0] && a[N - 1][0] > a[N - 2][1])
            sum++;
        if (a[0][M - 1] > a[1][M - 1] && a[0][M - 1] > a[1][M - 2] && a[0][M - 1] > a[0][M - 2])
            sum++;
        if (a[N - 1][M - 1] > a[N - 1][M - 2] && a[N - 1][M - 1] > a[N - 2][M - 1] && a[N - 1][M - 1] > a[N - 2][M - 2])
            sum++;
        return sum;
    }


    public static int[][] task6ReflectArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                int temp = a[i][j];
                a[i][j] = a[a.length - 1 - j][a.length - 1 - i];
                a[a.length - 1 - j][a.length - 1 - i] = temp;
            }
        }
        return a;
    }

    public static void printVector(boolean[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static boolean[] task7getVectorA(int[][] a, int n, int m) {
        boolean[] vector = new boolean[m];
        boolean flag;
        for (int i = 0; i < m; i++) {
            flag = true;
            for (int j = 0; j < n; j++) {
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

    public static boolean[] task7getVectorB(int[][] a, int n, int m) {
        boolean[] vector = new boolean[n];
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 1; j < m; j++) {
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

    public static boolean[] task7getVectorC(int[][] a, int n, int m) {
        boolean[] vector = new boolean[n];
        boolean flag;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < m; j++) {
                if (a[i][j] != a[i][m - 1 - j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                vector[i] = true;
        }
        return vector;
    }

    public static int[] task8getArrayA(int[][] a, int n, int m) {
        int[] array = new int[n];
        int sum;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < m; j++) {
                sum += a[i][j];
            }
            array[i] = sum;
        }
        return array;
    }

    public static int[] task8getArrayB(int[][] a, int n, int m) {
        int[] array = new int[n];
        int increase;
        for (int i = 0; i < n; i++) {
            increase = 1;
            for (int j = 0; j < m; j++) {
                increase *= a[i][j];
            }
            array[i] = increase;
        }
        return array;
    }

    public static double[] task8getArrayC(int[][] a, int n, int m) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            double average = 0;
            for (int j = 0; j < m; j++) {
                average += a[i][j];
            }
            average /= n;
            array[i] = average;
        }
        return array;
    }

    public static void task9SaddlePoint(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
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

    public static void task11(int[][] a) {
        int maxI = 0, maxJ = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
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
            for (int j = 0; j < a.length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        int minI = 0, minJ = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (a[i][j] < a[minI][minJ]) {
                    minI = i;
                    minJ = j;
                }
        if (minI != 0 && minJ != 0) {
            System.out.println("минимальный элемент можно поместить таким же образом в нижний правый угол");
        }
    }

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
