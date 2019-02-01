public class recursion{
    /*You may write additional private methods */
    /**
      *Recursively find the sqrt using Newton's approximation
      *tolerance is the allowed percent error the squared answer is away from n.
      *precondition: n is non-negative
      *@param n is the number we are trying to sqrt
      *@param tolerance is the limit our sqrt can be inaccurate
      *@return the sqrt with a percent error less than tolerance.
    */
    public static double sqrt(double n, double tolerance){
      if (n == 0) { return 0; //could be moved down to helper tbh
      }else{
        return sqrtH(n, n/2, tolerance);
      }
    }

    /**
    *@param n any non-negative non-zero value you want to take the sqrt of
    *@param guess is the guessed sqrt that recursively updates to get closer to real sqrt.
    *@param tolerance is the limit to how inaccurate the guess can be.
    *@return the approximate sqrt of n within a tolerance
    */
    private static double sqrtH(double n, double guess, double tolerance){
      if (Math.abs(Math.pow(guess, 2) - n) / n > tolerance) {
        return sqrtH(n, (n / guess + guess) / 2, tolerance);
      }else {
        return guess;
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 0; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
    /*public static int fib(int n){
    }*/
    public static int fibH(int n, int fNum, int sNum) {
      if (n == 0){
        return fNum;
      }else{
        return fibH(n-1, sNum, sNum + fNum);
        //else move forward -> 1 less n by default then, your first number is now what was previously your second, and your second number has to be the sum of the previous two (by fib rules)
      }
    }

    /*As Per classwork*/
    /*public static ArrayList<Integer> makeAllSums(){
    }*/
    public static void main(String[]args){
      System.out.println(sqrt(0.0, .001));
      System.out.println(sqrt(2.0, .001));
      System.out.println(sqrt(100.0, .001));
      System.out.println(fibH(5, 0, 1)); // 5
      System.out.println(fibH(1, 0, 1)); //1
      System.out.println(fibH(0, 0, 1)); //0
    }
}
