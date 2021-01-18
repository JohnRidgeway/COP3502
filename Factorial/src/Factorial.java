public class Factorial {

    //Calculates factorial using regular recursion and throws Illegal Argument Exception if non-positive number is inputted.
    public static long pureRecursive(int n) {
        if (n < 1){
            throw new IllegalArgumentException("The factorial function is undefined for non-positive numbers(including zero)!");
        }
        else if (n == 1) {
            return n;
        }
        else {
            return n * pureRecursive(n-1);
        }
    }

    //Calls tail method with first input of n and second input of 1  and throws Illegal Argument Exception if non-positive number is inputted.
    public static long tailRecursive(int n) {
        if (n < 1){
            throw new IllegalArgumentException("The factorial function is undefined for non-positive numbers(including zero)!");
        }
        else {
            return tail(n, 1);
        }
    }

    //Uses tail recursion to calculate factorial.
    private static long tail(int n, long m) {
        if (n == 0) {
            return m;
        }
        else {
            return tail(n-1, m * n);
        }
    }


    //Uses a for loop to calculate factorial.
    public static long iterative(int n) {
        if (n < 1){
            throw new IllegalArgumentException("The factorial function is undefined for non-positive numbers(including zero)!");
        }
        else {
            long factorial = 1;
            for (int i = 1; i <= n; i = i + 1) {
                factorial = factorial * i;
            }
            return factorial;
        }
    }
}
