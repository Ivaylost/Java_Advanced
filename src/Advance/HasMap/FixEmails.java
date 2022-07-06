package Advance.HasMap;

import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String name = sc.nextLine();
            if(name.equals("stop")){
                break;
            }
            String mail = sc.nextLine();
            String[] result = mail.split("\\.");
            String domain = result[result.length-1].toLowerCase();
            if(!domain.equals("com") && !domain.equals("uk") && !domain.equals("us")){
                System.out.printf("%s -> %s", name, mail);
                System.out.println();
            }
        }
    }
}
