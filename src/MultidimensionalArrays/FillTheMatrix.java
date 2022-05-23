package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pattern = sc.nextLine().split(", ");
        int n = Integer.parseInt(pattern[0]);
        int[][] result = new int[n][n];

        if (pattern[1].equals("A")) {
            result = patternA(n, result);
        } else {
            result = patternB(n, result);
        }

        print(n, result);
    }

    private static void print(int n, int[][] result) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                System.out.print(result[col][row] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] patternB(int n, int[][] result) {
        int index = 1;
        for (int i = 0; i < n; i++) {
            if(i%2 == 0) {
                for (int j = 0; j < n; j++) {
                    result[j][i] = index;
                    index++;
                }
            } else {
                for (int j = n-1; j >= 0 ; j--) {
                    result[j][i] = index;
                    index++;
                }
            }
        }
        return result;
    }

    private static int[][] patternA(int n, int[][] result) {
        int index = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = index;
                index++;
            }
        }
        return result;
    }
}
