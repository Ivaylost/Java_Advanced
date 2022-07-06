package Advance.ExamPreparation.MouseAndCheese;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            field[i] = sc.nextLine().toCharArray();
        }

        Mouse mouse = new Mouse(field);

        String command = sc.nextLine();

        while (!command.equals("end")) {
            switch (command){
                case "up":
                    field = mouse.commandUp(field);
                    if (mouse.hasBonus){
                        mouse.setHasBonusFalse();
                        field = mouse.commandUp(field);
                    }
                    break;
                case "down":
                    field = mouse.commandDown(field);
                    if (mouse.hasBonus){
                        mouse.setHasBonusFalse();
                        field = mouse.commandDown(field);
                    }
                    break;
                case "left":
                    field = mouse.commandLeft(field);
                    if (mouse.hasBonus){
                        mouse.setHasBonusFalse();
                        field = mouse.commandLeft(field);
                    }
                    break;
                case "right":
                    field = mouse.commandRight(field);
                    if (mouse.hasBonus){
                        mouse.setHasBonusFalse();
                        field = mouse.commandRight(field);
                    }
                    break;
            }
            if(mouse.isOut) break;
            command = sc.nextLine();
        }

        if (mouse.getCheese()< 5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - mouse.getCheese());
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", mouse.getCheese());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static class Mouse {
        private int row;
        private int col;
        private int cheese;
        private boolean isOut;
        private boolean hasBonus;

        public Mouse(char[][] field) {
            this.cheese = 0;
            setPosition(field);
            this.isOut = false;
            this.hasBonus = false;
        }

        public boolean isHasBonus() {
            return hasBonus;
        }

        public void setHasBonusFalse() {
            this.hasBonus = false;
        }

        public boolean isOut(int n) {
            this.isOut = !(row >= 0 && col >= 0 && row < n && col < n);
            return this.isOut;
        }

        public int getCheese() {
            return cheese;
        }

        private void checkForCheese(char[][] field) {
            if(field[row][col] == 'c'){
                cheese++;
            } else if(field[row][col] == 'B') {
                this.hasBonus = true;
            }
            field[row][col] = 'M';
        }

        public char[][] commandUp(char[][] field) {
            field[row][col] = '-';
            this.row -= 1;
            if (isOut(field.length)) {
                System.out.println("Where is the mouse?");
                return field;
            }
            checkForCheese(field);
            return field;
        }

        public char[][] commandDown(char[][] field) {
            field[row][col] = '-';
            this.row += 1;
            if (isOut(field.length)) {
                System.out.println("Where is the mouse?");
                return field;
            }
            checkForCheese(field);
            return field;
        }

        public char[][] commandLeft(char[][] field) {
            field[row][col] = '-';
            this.col -= 1;
            if (isOut(field.length)) {
                System.out.println("Where is the mouse?");
                return field;
            }
            checkForCheese(field);
            return field;
        }

        public char[][] commandRight(char[][] field) {
            field[row][col] = '-';
            this.col += 1;
            if (isOut(field.length)) {
                System.out.println("Where is the mouse?");
                return field;
            }
            checkForCheese(field);
            return field;
        }

        public void setPosition(char[][] field) {
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field.length; j++) {
                    if(field[i][j] == 'M'){
                        this.row = i;
                        this.col = j;
                    }
                }
            }
        }
    }
}


