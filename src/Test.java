import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {

        Test1 t1 = new Test1("abc", 10);
        Test1 t2 = new Test1("abcd", 20);
        Test1 t3 = new Test1("abcd1", 30);
        List<Test1> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);

        int reduce = list.stream().mapToInt(Test1::getNum).reduce(0, Integer::sum);
       list.stream().filter(x -> x.getNum() > 11)
                        .forEach(x-> System.out.println(x.getName()));
       List<Test1> x = list.stream().filter(b->b.getName().equals("abc")).collect(Collectors.toList());
        System.out.println();


//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(7);
//        numbers.add(3);
//        numbers.add(2);
//        numbers.add(1);
//
//        Function<List<Integer>, String> countFormatter = l -> "Count="+l.size();
//
//        Function<List<Integer>, Integer> sumElement = l->l.stream().reduce(0, Integer::sum);
//
//        Function<Integer, String> sumFormatter = s->"Sum = " + s;
//
//        System.out.println(countFormatter.apply(numbers));

        //========================================================
//        String date = "6/01/2022";
//
//        Date x = new Date(System.currentTimeMillis());
//        Date a = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
//        try{
//            a = sdf.parse(date);
//        } catch (Exception e){
//            System.out.println(e);
//        }
//        List<Integer> i = new ArrayList<>();
//
//        System.out.println(a.toString());

        //========================================================
    }
}
class Test1{
    String name;
    int num;

    public Test1(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}