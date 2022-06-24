package ExamPreparation2.ThroneConquering;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        char[] input = sc.nextLine().toCharArray();
        char[][] field = new char[n][input.length];

        for (int i = 0; i < n; i++) {
            if(i != 0){
                input = sc.nextLine().toCharArray();
            }
            for (int j = 0; j < input.length; j++) {
                field[i][j] = input[j];
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static class Paris {
        int rowP;
        int colP;
        int energyP;

    }
}
