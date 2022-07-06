package Advance.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int index = 0;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input[j];
            }
            index++;
        }

        int primary = primaryDiagonal(matrix, n);
        int secondary = secondaryDiagonal(matrix, n);

        System.out.println(Math.abs(primary-secondary));
    }

    private static int secondaryDiagonal(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[n-1-i][i];
        }

        return sum;
    }

    private static int primaryDiagonal(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
