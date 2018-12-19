import java.util.*;
import java.io.*;
public class HouseBuilding {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
     	buildHeight(N);
    }

    private static void buildHeight(int N){
    	if(N == 0) return;
    	buildHeight(N-1);
    	System.out.println(N);
    }
}
