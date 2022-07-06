package Advance;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws ParseException {
        String str = "7/1/2022";
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyy");
        long result = formatter.parse(str).getTime();
        System.out.println(String.valueOf(result));

        String x = String.valueOf(result);
        Date d = new Date(Long.parseLong(x));

        System.out.println(d.toLocalDate());
    }
}