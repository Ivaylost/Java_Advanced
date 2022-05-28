package HasMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        String input = sc.nextLine();

        while (!"search".equals(input)){
            String[] phone = input.split("-");
            map.put(phone[0],phone[1]);
            input = sc.nextLine();
        }

        String name = sc.nextLine();
        System.out.println();
        while (!"stop".equals(name)){
            String  phone = map.get(name);

            if(map.get(name)==null){
                System.out.printf("Contact %s does not exist.", name);
                System.out.println();
            } else  {
                System.out.printf("%s -> %s", name, map.get(name));
                System.out.println();
            }
            name= sc.nextLine();
        }
    }
}
