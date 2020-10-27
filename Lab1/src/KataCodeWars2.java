import javax.crypto.spec.PSource;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KataCodeWars2 {
    public static void main(String[] args)
    {
        Arrays.stream(reverseStrArray(new String[]{"Good", "Morning", "!"})).forEach(x-> System.out.println(x));

    }
    public static void toHumanTime(int seconds){
        if(seconds < 0 || seconds > 359999){
            System.out.println("Not valid input");
            return;
        }
        int h, m, s;
        s= seconds % 60;
        m = seconds/60%60;
        h = seconds/3600;
        System.out.printf("(%02o:%02o:%02o)",h,m,s);
    }
    public static int findSumOfNumer(int n)
    {
        int sum = 0;
        while(n != 0){
            sum+=n%10;
            n/=10;
        }
        if(sum > 9)
            return findSumOfNumer(sum);
        return sum;

    }
    public static String findLongestWorld(String sentence)
    {
        String res = "";
        String word;
        Pattern pattern = Pattern.compile("[а-яА-Я[a-zA-Z]]+");
        Matcher m = pattern.matcher(sentence);
        while(m.find()) {
            word = sentence.substring(m.start(), m.end());
            if(word.length() > res.length())
                res = word;
        }
        return res;
    }
    public static boolean hasNoneLetter(String blackList,String text)
    {
        Pattern pattern = Pattern.compile(String.format("[%s]",blackList),Pattern.CASE_INSENSITIVE);
        return pattern.matcher(text).find();
    }
    public static int[] findMultiples(int x,int n){
        int[] arr = new int[x];
         for(int i = 1; i<= x; i++){
             arr[i-1] = n*i;
         }
         return arr;
    }
    public static String[] reverseStrArray(String[] arr)
    {
     String str = "";
     int index = 0;
     for(int i = 0; i< arr.length; i++)
         str+=arr[i];
     str = Reverse(str.toCharArray());
     for(int i = 0; i < arr.length; i++){
         arr[i] = str.substring(index, index + arr[i].length());
         index+=arr[i].length();
     }
     return arr;
    }
    public static String Reverse(char[] o){
        for(int i = 0; i< o.length/2; i++){
            char c = o[i];
            o[i] = o[o.length - i - 1];
            o[o.length-i-1] = c;
        }
        return String.copyValueOf(o);
    }
    public static void Swap(Object a, Object b){
        Object c = a;
        a = b;
        b = c;
    }

}
