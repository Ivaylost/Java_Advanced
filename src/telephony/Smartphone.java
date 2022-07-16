package telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public void setNumbers(String numbers) {
        this.numbers.add(numbers);
    }

    public void setUrls(String urls) {
        this.urls.add(urls);
    }

    @Override
    public String browse() {

        StringBuilder sb = new StringBuilder();
        for (String item : urls) {
            boolean checker = true;
            char[] input = item.toCharArray();
            for(char x:input){
                if (Character.isDigit(x)){
                    checker = false;
                    break;
                }
            }

            if (checker) {
                sb.append(String.format("Browsing: %s!%n", item));
            } else {
                sb.append(String.format("Invalid URL!%n"));
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {

        StringBuilder sb = new StringBuilder();
        for (String item : numbers) {
            boolean checker = true;
            char[] input = item.toCharArray();
            for(char x:input){
                if (Character.isLetter(x)){
                    checker = false;
                    break;
                }
            }

            if (checker) {
                sb.append(String.format("Calling... %s%n", item));
            } else {
                sb.append(String.format("Invalid number!%n"));
            }
        }
        return sb.toString();
    }
}
