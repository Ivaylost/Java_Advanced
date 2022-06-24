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
        
        Paris paris = new Paris(field, parisEnergy);

        String[] commands = sc.nextLine().split("\\s+");

        while (true){
            field[Integer.parseInt(commands[1])][Integer.parseInt(commands[2])] = 'S';
            switch (commands[0]){
                case "up":
                    paris.up(field);
                    break;
                case "down":
                    paris.down(field);
                    break;
                case "left":
                    paris.left(field);
                    break;
                case "right":
                    paris.right(field);
                    break;
            }
            if (paris.isInactive) break;
            commands = sc.nextLine().split("\\s+");
        }

        System.out.println(paris);

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
        int energy;
        boolean isInactive;
        String message;

        public Paris(char[][] field, int energy) {
            this.energy = energy;
            this.isInactive = false;
            this.message = "";
            setUp(field);
        }

        void checkForHelen(char[][] field){
            if(field[rowP][colP] == 'H'){
                isInactive = true;
                message = String.format("Paris has successfully abducted Helen! Energy left: %d", energy);
                field[rowP][colP] = '-';
            }
        }

        void checkForSpartan(char[][] field){
            if (field[rowP][colP] == 'S'){
                energy -= 2;
                if (energy < 1){
                    isDead(field);
                }
            }
        }

        void isDead(char[][] field){
            isInactive = true;
            message = String.format("Paris died at %d;%d.", rowP, colP);
            field[rowP][colP] = 'X';
        }

        void up(char[][] field){
            field[rowP][colP] = '-';
            if(rowP > 0){
                rowP--;
                energy--;
                if(energy <= 0){
                    isDead(field);
                }
            } else {
                energy--;
                if(energy < 1) {
                    isDead(field);
                }
            }
            checkForHelen(field);
            checkForSpartan(field);
        }

        void down(char[][] field){
            field[rowP][colP] = '-';
            if(rowP < field.length - 2){
                rowP++;
                energy--;
                if(energy <= 0){
                    isDead(field);
                }
            } else {
                energy--;
                if(energy < 1) {
                    isDead(field);
                }
            }
            checkForHelen(field);
            checkForSpartan(field);
        }

        void left(char[][] field){
            field[rowP][colP] = '-';
            if(colP > 0){
                colP--;
                energy--;
                if(energy <= 0){
                    isDead(field);
                }
            } else {
                energy--;
                if(energy < 1) {
                    isDead(field);
                }
            }
            checkForHelen(field);
            checkForSpartan(field);
        }

        void right(char[][] field){
            field[rowP][colP] = '-';
            if(colP < field[0].length - 2){
                colP++;
                energy--;
                if(energy <= 0){
                    isDead(field);
                }
            } else {
                energy--;
                if(energy < 1) {
                    isDead(field);
                }
            }
            checkForHelen(field);
            checkForSpartan(field);
        }
        
        void setUp(char[][] field){
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[0].length; j++) {
                    if(field[i][j] == 'P') {
                        rowP = i;
                        colP = j;
                    }
                }
            }
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
