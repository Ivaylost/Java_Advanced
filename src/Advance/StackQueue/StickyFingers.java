package Advance.StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> commands = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                field[i][j] = input[j].charAt(0);
            }
        }
        Thieve thieve = new Thieve(field);

        for(String command:commands){
            switch (command){
                case "up":
                    thieve.up(field);
                    break;
                case "down":
                    thieve.down(field);
                    break;
                case "left":
                    thieve.left(field);
                    break;
                case "right":
                    thieve.right(field);
                    break;
            }
            if(thieve.isInactive) break;
        }

        if(!thieve.isInactive){
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", thieve.money);
            field[thieve.row][thieve.col] = 'D';
        }

        List<String> x = new ArrayList<>();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                x.add(String.valueOf(field[i][j]));
            }
            System.out.print(String.join(" ", x));
            x.clear();
            System.out.println();
        }
    }

    public static class Thieve {
       public int row;
       public int col;
       public int money;
       public boolean isInactive;
       public String messageOutside = "You cannot leave the town, there is police outside!";

        public Thieve(char[][] field) {
            this.money=0;
            isInactive = false;
            setPosition(field);
        }

        public void checkForHouse(char[][] field){
            if(field[row][col] == '$'){
                money += row*col;
                System.out.printf("You successfully stole %d$.%n", row*col);
            }
        }

        public void checkForPolice(char[][] field){
            if(field[row][col] == 'P'){
                System.out.printf("You got caught with %d$, and you are going to jail.%n", money);
                isInactive = true;
                field[row][col] = '#';
            }
        }

        public void up(char[][] field){
            if(row == 0){
                System.out.println(messageOutside);
            } else {
                row--;
                checkForHouse(field);
                checkForPolice(field);
            }
            if (!isInactive) field[row][col] = '+';
        }

        public void down(char[][] field){
            if(row == field.length-1){
                System.out.println(messageOutside);
            } else {
                row++;
                checkForHouse(field);
                checkForPolice(field);
            }
            if (!isInactive) field[row][col] = '+';
        }

        public void left(char[][] field){
            if(col == 0){
                System.out.println(messageOutside);
            } else {
                col--;
                checkForHouse(field);
                checkForPolice(field);
            }
            if (!isInactive) field[row][col] = '+';
        }

        public void right(char[][] field){
            if(col == field.length-1){
                System.out.println(messageOutside);
            } else {
                col++;
                checkForHouse(field);
                checkForPolice(field);
            }
            if (!isInactive) field[row][col] = '+';
        }
        public void setPosition(char[][] field){
           for (int i = 0; i < field.length; i++) {
               for (int j = 0; j < field.length; j++) {
                   if(field[i][j] == 'D'){
                       row = i;
                       col = j;
                       field[row][col]='+';
                   }
               }
           }
       }
    }
}
