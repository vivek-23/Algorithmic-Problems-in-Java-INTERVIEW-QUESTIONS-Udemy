import java.util.*;
import java.io.*;
public class FibonacciRecursive {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(recursiveFibonacci(N));
    }

    private static int recursiveFibonacci(int n){
        if(n <= 1) return n;
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }
}
