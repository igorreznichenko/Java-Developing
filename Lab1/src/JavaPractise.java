import java.util.Scanner;

public class JavaPractise {
    public static void main(String[] args) {

        task3();
    }
    public static void task3(){
        Scanner s = new Scanner(System.in);
        String str = "";
        int option;


        do{
            System.out.println("1 : Input new val");
            System.out.println("2 : Output all words");
            System.out.println("3 : Exit");
            option = s.nextInt();

            switch (option) {
                case 1 -> {
                    String line = s.next();
                    char op = line.toCharArray()[0];
                    if (op == '+') {
                        str += str.length() > 0 ? ", " + line.substring(1) : line.substring(1);
                    } else {
                        if (op == '-') {
                            if (str.contains(", " + line.substring(1)))
                                str = str.replace(", " + line.substring(1), "");
                            else if (str.contains(line.substring(1) + ", "))
                                str = str.replace(line.substring(1) + ", ", "");
                            if (str.contains(line.substring(1)))
                                str = str.replace(line.substring(1), "");
                            else
                                System.out.println("Line doesn't contain this word");
                        } else
                            System.out.println("Not valid Input");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println(str);
                    break;
                }
                case 3 -> {
                    System.out.println("Exit");
                    return;
                }
                default -> {
                    System.out.println("Not valid input");
                }
            }

        }while(true);
    }
    public static void task2(){
        Scanner s = new Scanner(System.in);
        System.out.println("Input size of array");
        int n = s.nextInt();
        int[] arr = new int[n];
        int i, j;
        for(i = n/2; i>= 0; i--){
            arr[i] = i-n/2;
        }
        for(i =n/2 + 1;i < arr.length; i++)
            arr[i] = i-n/2;

        for(i = 0; i< n; i++)
            System.out.print(arr[i] + " ");


    }
    public static void task1(){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int i = 0;
        double res;
        String numb = "";
        char[] arr = str.toCharArray();
        while(i < arr.length && arr[i] >= '0' && arr[i] <= '9'){
            numb+=arr[i];
            i++;
        }

        res = Float.parseFloat(numb);

        while(i < arr.length){
            numb = "";
            char oper = arr[i];
            i++;
            while(i < arr.length && arr[i] >= '0' && arr[i] <= '9'){
                numb+=arr[i];
                i++;
            }
            switch(oper){
                case '+' : {
                    res += Float.parseFloat(numb);
                    break;
                }
                case '-' : {
                    res-= Float.parseFloat(numb);
                    break;
                }
                case '*' : {
                    res*= Float.parseFloat(numb);
                    break;
                }
                case '/' : {
                    res/=Float.parseFloat(numb);
                    break;
                }
            }

        }
        System.out.println(res);
    }
}
