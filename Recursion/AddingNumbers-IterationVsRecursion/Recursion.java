import java.util.*;
import java.io.*;
public class Recursion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
     	System.out.println(recursiveSum(N));
    }

    private static int recursiveSum(int N){
    	if(N == 0) return 0;
    	return N + recursiveSum(N-1);
    }
}
