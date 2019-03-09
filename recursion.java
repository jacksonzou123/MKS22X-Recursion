import java.util.ArrayList;
import java.util.List;

public class recursion{
  /*
*@param n any non-negative value you want to take the sqrt of
*@return the approximate sqrt of n within a tolerance of 0.001%
*/
public static double sqrt(double n, double tolerance) {
  if (n == 0) {
    return 0;
  }
  return sqrtH(n,n * 0.01,tolerance);
}
public static double sqrtH(double n, double guess, double tolerance) {
  guess = (n / guess + guess) / 2;
  if (((guess * guess - n) / n) < tolerance) {
    return guess;
  }
  return sqrtH(n, guess, tolerance);
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
  makeSumH(n, n, 0, f);
  return f;
}

public static void makeSumH(int index, int n, int sum, ArrayList<Integer> list) {
  if (index == 0) {
    list.add(sum);
  }
  else {
    makeSumH(index-1, n, sum + index, list);
    makeSumH(index-1, n, sum, list);
  }
}

public static void main(String args[]) {
  //System.out.println(sqrt(Integer.parseInt(args[0])));
  //System.out.println(Math.sqrt(Integer.parseInt(args[0])));
  //System.out.println(fib(Integer.parseInt(args[0])));
  //System.out.println(makeAllSums(Integer.parseInt(args[0])));
  /*testFib(0);
  testFib(1);
  testFib(2);
  testFib(3);
  testFib(4);
  testFib(5);
  testSqrt(0);
  testSqrt(1);
  testSqrt(2);
  testSqrt(3);
  testSqrt(4);
  testSqrt(5);
  */
  System.out.println(makeAllSums(4));
}

public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{

      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}
}
