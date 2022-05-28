package HasMap;

import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> set = new TreeSet<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] x = sc.nextLine().split("\\s+");
            set.addAll(Arrays.asList(x));
        }

        System.out.println(String.join(" ", set));
    }
}
