package Advance.MultidimensionalArrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PawnWars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> inp = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        char[][] matrix = new char[8][8];
        int[] w = new int[2];
        int[] b = new int[2];
        for (int i = 0; i < 8; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                char x = input.charAt(j);
                matrix[i][j] = x;
                if(x == 'w'){
                    w[0] = i;
                    w[1] = j;
                }
                if(x == 'b'){
                    b[0] = i;
                    b[1] = j;
                }
            }
        }

        while (true){
            if(w[0]-1 == 0){

            }
            break;
        }

        System.out.println();
    }
}
