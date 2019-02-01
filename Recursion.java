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

public static void main(String args[]) {
  System.out.println(sqrt(Integer.parseInt(args[0])));
  System.out.println(Math.sqrt(Integer.parseInt(args[0])));
}

}
