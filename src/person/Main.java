package person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> birthable = new ArrayList<>();
        List<Identifiable> identifiable = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthable.add(citizen);
                    identifiable.add(citizen);
                    break;
                case "Robot":
                    identifiable.add(new Robot(tokens[2], tokens[1]));
                    break;
                case "Pet":
                    birthable.add(new Pet(tokens[1], tokens[2]));
                    break;
            }

            input = scanner.nextLine();
        }

        String date = scanner.nextLine();

        boolean x = true;

        for(Birthable item:birthable){
            if(item.getBirthDate().contains(date)){
                System.out.println(item.getBirthDate());
                x = false;
            }
        }

        if (x){
            System.out.println("<no output>");
        }
    }
}
