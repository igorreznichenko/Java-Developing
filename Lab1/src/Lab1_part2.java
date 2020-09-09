import java.util.Scanner;

public class Lab1_part2 {
    public Lab1_part2() {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input begin");
        int begin = s.nextInt();
        System.out.println("Input end");

        int end;
        do {
            end = s.nextInt();
            if (end < begin) {
                System.out.println("Input end more than begin");
            }
        } while(end < begin);

        System.out.println("Input step");

        int step;
        do {
            step = s.nextInt();
            if (step <= 0) {
                System.out.printf("Input step more than zero");
            }
        } while(step <= 0);

        int[] arr = fillArray(begin, end, step);
        PrintArray(arr);
    }

    public static void PrintArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }

    }

    public static int[] fillArray(int begin, int end, int step) {
        int[] arr = new int[(end - begin) / step + 1];
        int i = 0;

        do {
            arr[i] = begin;
            begin += step;
            ++i;
        } while(begin <= end);

        return arr;
    }
}
