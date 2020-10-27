import java.lang.module.FindException;
import java.util.Scanner;
import java.util.Stack;

public class BracketsAndPriority {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(FindExpressionResult(s.nextLine()));
    }
    public static Double FindExpressionResult(String expression)
    {
        Stack<Integer> stack = new Stack<Integer>();
        if (expression.contains("(")) {
            int i = 0;
            while(i < expression.length()) {
                if (expression.charAt(i) == '(')
                    stack.push(i);
                else if (expression.charAt(i) == ')') {
                    expression = expression.replace(expression.substring(stack.peek(),i+1),FindResult(expression.substring(stack.peek()+1,i)));
                    i = stack.pop();
                }
                    i++;
            }
        }

        return Double.parseDouble(FindResult(expression));
    }


    public static String FindResult(String expression)
    {
        int i = 0;
        int j1, j2;
        char sign;
        double res;
        String numb1, numb2;
        while(i < expression.length()){
            numb1 = numb2 = "";
            if(expression.charAt(i) == '/'  || expression.charAt(i) == '*')
            {
              j1 = i-1;
              while(j1 >= 0 && (expression.charAt(j1)>='0' && expression.charAt(j1) <='9' || expression.charAt(j1)=='.'))
                  j1--;

              numb1 = expression.substring(j1+1,i);
              j2 = i+1;
              while (j2 < expression.length() && (expression.charAt(j2)>='0' && expression.charAt(j2) <='9' || expression.charAt(j2)=='.'))
                  j2++;
              numb2 = expression.substring(i+1,j2);
              if(expression.charAt(i) == '/')
                  res = Double.parseDouble(numb1)/Double.parseDouble(numb2);
              else
                  res = Double.parseDouble(numb1)*Double.parseDouble(numb2);
                  expression = expression.replace(expression.substring(j1+1, j2),Double.toString(res));
              i = j1+2;
            }
            i++;
        }
        i = 0;
        while(i < expression.length() && (expression.charAt(i)>='0' && expression.charAt(i) <='9' || expression.charAt(i)=='.'))
            i++;
        res = Double.parseDouble(expression.substring(0,i));
        while(i < expression.length()){
            sign = expression.charAt(i);
            j2 = i+1;
            while(j2 < expression.length() && (expression.charAt(j2)>='0' && expression.charAt(j2) <='9' || expression.charAt(j2)=='.'))
                j2++;
            numb2 = expression.substring(i+1, j2);
            res = sign =='+'?res + Double.parseDouble(numb2):res-Double.parseDouble(numb2);
            i = j2;
        }
        return Double.toString(res);
    }
}
