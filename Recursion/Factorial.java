import java.util.*;
import java.io.*;
public class Factorial {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
     	  System.out.println(factorial(N));
    }

    private static int factorial(int N){
    	return tailRecursion(1,N);
    }

    private static int tailRecursion(int acc,int N){
    	if(N <= 1) return acc;
    	return tailRecursion(acc * N,N-1);
    }
}
