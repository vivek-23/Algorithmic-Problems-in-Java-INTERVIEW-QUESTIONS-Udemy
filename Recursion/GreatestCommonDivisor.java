import java.util.*;
import java.io.*;
public class GreatestCommonDivisor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
     	System.out.println(GCD(num1,num2));
    }

    private static int GCD(int a,int b){
    	if(a%b == 0) return b;
    	return GCD(b,a%b);
    }
}
