import java.util.Arrays;
import java.util.List;
import java.util.Random;
import  java.util.Scanner;
import java.util.stream.Stream;

public class Lab2 {
    public static void main(String[] args) {

        List<String> myList = Arrays.asList("a1","a2","b1", "c2", "c1");
        myList.stream().filter(x->x.charAt(0) == 'c').sorted((x,y)->x.compareTo(y)).map(x->x.toUpperCase()).forEach(x-> System.out.println(x));
        String str = "esfraewfzsdfhrdhd";

        System.out.println("input length of array");
        int n;
        int arr[];
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
       arr = new int[n];
        fillArray(arr);
    }
    public static void fillArray(int arr[]){
        Random r = new Random();
        Double avg = Arrays.stream(arr).map(x->x=Math.abs(r.nextInt()%10)).filter(x->x%2==0).average().orElseThrow();
        System.out.println(avg);
    }
}

