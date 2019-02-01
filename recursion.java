public class recursion{
    /*You may write additional private methods */
    /**
      *Recursively find the sqrt using Newton's approximation
      *tolerance is the allowed percent error the squared answer is away from n.
      *precondition: n is non-negative
      */

    public static double sqrt(double n){
      if (n == 0) { return 0; //could be moved down to helper tbh
      }else {
        return sqrtH(n, n/2);
      }
    }

    /*
    *@param n any non-negative non-zero value you want to take the sqrt of
    *@param guess is the guessed sqrt that recursively updates to get closer to real sqrt.
    *@return the approximate sqrt of n within a tolerance of 0.001%
    */
    private static double sqrtH(double n, double guess){
      if (Math.abs(Math.pow(guess, 2) - n) / n > .00001) {
        return sqrtH(n, (n / guess + guess) / 2);
      }
      else {
        return guess;
      }
    }

    /*Recursively find the n'th fibbonaci number in linear time
     *fib(0) = 1; fib(1) = 1; fib(5) = 5
     *precondition: n is non-negative
     */
  /*  public static int fib(int n){

  }*/

    /*As Per classwork*/
    /*public static ArrayList<Integer> makeAllSums(){
    }*/
    public static void main(String[]args){
      System.out.println(sqrt(0.0));
      System.out.println(sqrt(2.0));
      System.out.println(sqrt(100.0));
    }
}
