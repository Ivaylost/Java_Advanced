package Advance.HasMap;

import java.util.*;
import java.util.stream.Collectors;

public class Important {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> inp = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        //===========================================================
        Map<Double, Integer> map = new LinkedHashMap<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(key -> {
                    if(map.containsKey(key)){
                        int oldCount = map.get(key);
                        int newCount = oldCount+1;
                        map.put(key, newCount);
                    } else {
                        map.put(key,1);
                    }

                    // Or this way
                    map.putIfAbsent(key, 0);
                    int oldCount = map.get(key);
                    int newCount = oldCount+1;
                    map.put(key, newCount);
                });

        //================================================================

        System.out.println(Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
