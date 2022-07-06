package OOP.Abstractions.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RankPower rank = RankPower.valueOf(sc.nextLine());
        SuitPower suitPower = SuitPower.valueOf(sc.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d", rank.name(), suitPower.name(), rank.getPower() + suitPower.getPower());
    }
}
