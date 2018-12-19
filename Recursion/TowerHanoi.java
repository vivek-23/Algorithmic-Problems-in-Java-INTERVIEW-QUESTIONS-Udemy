import java.util.*;
import java.io.*;
public class TowerHanoi {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        towerOfHanoi(Integer.parseInt(br.readLine()),'A','B','C');    
    }

    private static void towerOfHanoi(int N,char from, char aux,char to){
    	if(1 == N){
    		System.out.println("Move " + N + " from " + from + " to " + to);
    		return;
    	}

    	towerOfHanoi(N-1,from,to,aux);
    	System.out.println("Move " + N + " from " + from + " to " + to);
    	towerOfHanoi(N-1,aux,from,to);
    }
}
