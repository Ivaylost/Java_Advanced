package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        String[] command;

        for (int i = 0; i < row; i++) {
            command = sc.nextLine().split("\\s+");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = command[j];
            }
        }

        command = sc.nextLine().split("\\s+");


            while (!command[0].equals("END")){
                try {
                    if(command[0].equals("swap")){
                        int row1 = Integer.parseInt(command[1]);
                        int col1 = Integer.parseInt(command[2]);
                        int row2 = Integer.parseInt(command[3]);
                        int col2 = Integer.parseInt(command[4]);
                        String first = matrix[row1][col1];
                        String second = matrix[row2][col2];
                        matrix[row2][col2] = first;
                        matrix[row1][col1] = second;
                        printMatrix(matrix, row, col);
                    } else {
                        System.out.println("Invalid input!");
                    }
                } catch (Exception e){
                    System.out.println("Invalid input!");
                }
                command = sc.nextLine().split("\\s+");
            }

        //printMatrix(matrix, row, col);
    }

    private static void printMatrix(String[][] matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
