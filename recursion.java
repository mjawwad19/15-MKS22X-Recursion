import java.util.*;
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

    /**Recursively find the n'th fibbonaci number in linear time
      *fib(0) = 0; fib(1) = 1; fib(5) = 5
      *precondition: n is non-negative
      *@param n is the position of the fibonacci number
      *@return the fibbonacci number in the nth spot.
      */
    public static int fib(int n){
      return fibH(n, 0, 1);
    }

    /**
      *findds the n'th fibbonacci number using tail recursion
      *@param n is the index of the fibonacci number we want
      *@param fNum is the first number in the sequence, usually 0
      *@param sNum is the second number in the sequence, usually 1
      *@return the fibonacci number in the nth spot given fNum and sNum
      */
    private static int fibH(int n, int fNum, int sNum) {
      if (n == 0){
        return fNum;
      }else{
        return fibH(n-1, sNum, sNum + fNum);
        //else move forward -> 1 less n by default then, your first number is now what was previously your second, and your second number has to be the sum of the previous two (by fib rules)
      }
    }

    /*As Per classwork*/
    /**
      *creates an arrayList of all subset totals of the numbers 1 to n inclusive.
      *@param n is the limit/starting point
      *@param partial is eiether 0 or the sum down (+n)
      *@param L is the arrayList containing the totals.
      */
    public static void msH(int n, int partial, ArrayList<Integer> L) {
      if (n == 0) L.add(partial);
      else {
        msH(n-1, n+partial, L); //add
        msH(n-1, partial, L); //don't add
      }
      //return L;
    }

    /**
      *@param n is the starting point/limit of the range.
      *@return an arrayList of all subset totals of the numbers 1 to n inclusive
      */
    public static ArrayList<Integer> makeAllSums(int n){
      ArrayList<Integer> sumL = new ArrayList<>();
      msH(n, 0, sumL);
      return sumL;
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

    public static void main(String[]args){
      System.out.println(sqrt(0.0, .001)); //0
      System.out.println(sqrt(2.0, .001)); //1.412...
      System.out.println(sqrt(100.0, .001)); ///roughly 10
      System.out.println(fib(5)); // 5
      System.out.println(fib(1)); //1
      System.out.println(fib(0)); //0
      System.out.println(fib(6)); //8
      testFib(5); //pass yes
      testSqrt(2); //pass yes
      System.out.println(closeEnough(sqrt(2.0, .001), Math.sqrt(2))); //true;
      /*System.out.println(msH(3, 0, new ArrayList<Integer>())); // [0,1,2,3,3,4,5,6]
      System.out.println(msH(2, 0, new ArrayList<Integer>())); // [0,1,2,3]*/
      System.out.println(makeAllSums(3)); // [0,1,2,3,4,5,6]
      System.out.println(makeAllSums(2)); //[0,1,2,3]
    }
}
