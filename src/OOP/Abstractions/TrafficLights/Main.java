package OOP.Abstractions.TrafficLights;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());
        List<TrafficLight> result = new ArrayList<>();

        for(String item : input){
            result.add(new TrafficLight(Lights.valueOf(item)));
        }

        for (int i = 0; i < n; i++) {
            result.forEach(x -> x.setState(x.getState().next()));
            for (TrafficLight item : result) {
                System.out.print(item.getState() + " ");
            }
            System.out.println();
        }
    }
}
