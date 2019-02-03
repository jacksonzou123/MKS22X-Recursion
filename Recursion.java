import java.util.ArrayList;
import java.util.List;

public class Recursion{
  /*
*@param n any non-negative value you want to take the sqrt of
*@return the approximate sqrt of n within a tolerance of 0.001%
*/
public static double sqrt(double n) {
  return sqrtH(n,n * 0.01);
}
public static double sqrtH(double n, double guess) {
  guess = (n / guess + guess) / 2;
  if (((guess * guess - n) / n) < 0.00001) {
    return guess;
  }
  return sqrtH(n, guess);
}

public static int fib(int n) {
  return fibH(n, 0, 1);
}
public static int fibH(int n, int first, int second) {
  if (n == 0) {
    return first;
  }
  if (n == 1) {
    return second;
  }
  int third = first + second;
  return fibH(n-1,second,third);
}

public static ArrayList<Integer> makeAllSums(int n) {
  ArrayList<Integer> f = new ArrayList<>();
  makeSumH(1, n, 0, f);
  return f;
}

public static void makeSumH(int index, int n, int sum, ArrayList<Integer> list) {
  if (index > n) {
    list.add(sum);
  }
  makeSumH(index + 1, n, sum + index, list);
  makeSumH(index + 1, n, sum, list);
}

public static void main(String args[]) {
  //System.out.println(sqrt(Integer.parseInt(args[0])));
  //System.out.println(Math.sqrt(Integer.parseInt(args[0])));
  System.out.println(fib(Integer.parseInt(args[0])));
}

}
