import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class StreamTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s;
        char begin,end;
        System.out.println("Input string");
        s = scan.nextLine();
        System.out.println("Input begin letter");
        begin = scan.nextLine().toLowerCase().toCharArray()[0];
        System.out.println("Input end letter");
        end = scan.nextLine().toLowerCase().toCharArray()[0];
        s.chars().map(x->x>=begin && x <=end?x-32:x).forEach(x-> System.out.println((char)x));
    }
}
