package ExamPreparation1.Bomb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[][] field = new String[5][5];
        List<String> commands = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            System.arraycopy(input, 0, field[i], 0, n);
        }

        Bomb bomb = new Bomb(field);

        for(String command : commands){
            switch (command) {
                case "up":
                    bomb.commandUp();
                    break;
                case "down":
                    bomb.commandDown();
                    break;
                case "left":
                    bomb.commandLeft();
                    break;
                case "right":
                    bomb.commandRight();
                    break;
            }
        }

        System.out.println();
    }

    public static class Bomb {
        private int row;
        private int col;
        private int bombs;

        public Bomb(String[][] field) {
            setPosition(field);
            this.bombs = 0;
        }

        public void commandUp(){

        }

        public void commandDown(){

        }

        public void commandLeft(){

        }

        public void commandRight(){

        }

        public void setPosition(String[][] field){
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if(field[i][j].equals("s")) {
                        this.row = i;
                        this.col = j;
                    }
                }

            }
        }
    }
}
