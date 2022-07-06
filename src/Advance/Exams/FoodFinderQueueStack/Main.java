package Advance.Exams.FoodFinderQueueStack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Character> vowel = new ArrayDeque<>();
        Stack<Character> consonant = new Stack<>();

        String vowels = sc.nextLine();
        String consonants = sc.nextLine();

        Arrays.stream(vowels.split("\\s+")).map(x -> x.charAt(0)).forEach(vowel::offer);
        Arrays.stream(consonants.split("\\s+")).map(x -> x.charAt(0)).forEach(consonant::push);

        while (!consonant.isEmpty()) {
            char x = vowel.poll();
            char y = consonant.pop();


            vowel.offer(x);
        }

    }
}
