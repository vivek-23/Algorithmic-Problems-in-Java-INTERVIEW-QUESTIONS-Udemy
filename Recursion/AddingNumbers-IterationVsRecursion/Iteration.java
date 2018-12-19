import java.util.*;
import java.io.*;
public class Iteration {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
     	for(int i=1;i<N;++i,sum+=i);
     	System.out.println(sum);
    }
}
