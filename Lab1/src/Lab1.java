import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public Lab1() {
    }

    public static void main(String[] args) {
        System.out.println("Amount of row");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][];

        for(int i = 0; i < n; ++i) {
            arr[i] = new int[n];
        }

        RandomFillArray(n, arr);
        PrintArray(n, arr);
        PrintOddElement(n, arr);
    }

    public static void RandomFillArray(int n, int[][] arr) {
        Random r = new Random();

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                arr[i][j] = Math.abs(r.nextInt() % 10);
            }
        }

    }

    public static void PrintArray(int n, int[][] arr) {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static void PrintOddElement(int n, int[][] arr) {
        for(int i = 0; i < n; ++i) {
            if (arr[i][n - i - 1] % 2 == 0) {
                System.out.print(arr[i][n - i - 1] + " ");
            }
        }

    }
}
