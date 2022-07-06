package Advance.ExamPreparation1.Bomb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[][] field = new String[n][n];
        List<String> commands = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            System.arraycopy(input, 0, field[i], 0, n);
        }

        Bomb bomb = new Bomb(field);

        for(String command : commands){
            if(bomb.isInactive()){
                break;
            }
            switch (command) {
                case "up":
                    bomb.commandUp(field);
                    break;
                case "down":
                    bomb.commandDown(field);
                    break;
                case "left":
                    bomb.commandLeft(field);
                    break;
                case "right":
                    bomb.commandRight(field);
                    break;
            }
        }

        if(bomb.getBombs() == bomb.getTotalBomb()){
            System.out.println("Congratulations! You found all bombs!");
        } else if(bomb.isInactive()) {
            System.out.printf("END! %d bombs left on the field%n", bomb.getTotalBomb()- bomb.getBombs());
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bomb.getTotalBomb()- bomb.getBombs(), bomb.getRow(), bomb.getCol());
        }
    }

    public static class Bomb {
        private int row;
        private int col;
        private int bombs;
        private int length;
        private int totalBomb;
        private boolean isInactive;

        public Bomb(String[][] field) {
            this.bombs = 0;
            this.totalBomb = 0;
            this.length = field.length;
            setPosition(field);
            this.isInactive = false;
        }

        private void checkForBomb(String x){
            if(x.equals("B")){
                bombs++;
                System.out.println("You found a bomb!");
            }
        }

        private void checkInactive(String x){
            if(x.equals("e")){
                isInactive = true;
            }
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getBombs() {
            return bombs;
        }

        public int getTotalBomb() {
            return totalBomb;
        }

        public boolean isInactive() {
            return isInactive;
        }

        public void commandUp(String[][] field){
            field[row][col] = "+";
            if(row - 1 >= 0){
                row--;
                checkForBomb(field[row][col]);
                checkInactive(field[row][col]);
                field[row][col] = "+";
            }
        }

        public void commandDown(String[][] field){
            field[row][col] = "+";
            if(row + 1 < length){
                row++;
                checkForBomb(field[row][col]);
                checkInactive(field[row][col]);
                field[row][col] = "+";
            }
        }

        public void commandLeft(String[][] field){
            field[row][col] = "+";
            if(col -1 >= 0){
                col--;
                checkForBomb(field[row][col]);
                checkInactive(field[row][col]);
                field[row][col] = "+";
            }
        }

        public void commandRight(String[][] field){
            field[row][col] = "+";
            if(col + 1 < length){
                col++;
                checkForBomb(field[row][col]);
                checkInactive(field[row][col]);
                field[row][col] = "+";
            }
        }

        public void setPosition(String[][] field){
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if(field[i][j].equals("s")) {
                        this.row = i;
                        this.col = j;
                    }
                    if(field[i][j].equals("B")) {
                        this.totalBomb++;
                    }
                }

            }
        }
    }
}
