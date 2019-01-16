/*

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of four lines. The first line consists of N the number of items. The second line consists of W, the maximum capacity of the knapsack. In the next  line are N space separated positive integers denoting the values of the N items and in the fourth line are N space separated positive integers denoting the weights of the corresponding items.

For example:

1
3
4
1 2 3
4 5 1


*/

import java.util.*;
import java.io.*;

class Knapsack {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
		    int N = Integer.parseInt(br.readLine());
		    int W = Integer.parseInt(br.readLine());
		    int[] vals = new int[N];
		    int[] weig = new int[N];
		    String[] s = br.readLine().split("\\s");
		    for(int i=0;i<N;++i){
		        vals[i] = Integer.parseInt(s[i]);
		    }
		    s = br.readLine().split("\\s");
		    for(int i=0;i<N;++i){
		        weig[i] = Integer.parseInt(s[i]);
		    }
		    System.out.println(maxProfit(vals,weig,W,N));
		}
	}
	
	private static int maxProfit(int[] vals,int[] weig,int W,int N){
	    int[][] dp = new int[N + 1][W + 1];
	    for(int i=0;i<weig.length;++i){
	        for(int j=1;j<=W;++j){
	            if(weig[i] > j) dp[i+1][j] = dp[i][j];
	            else dp[i+1][j] = Math.max(dp[i][j],vals[i] + dp[i][j-weig[i]]);
	        }
	    }
	    
	    return dp[N][W];
	}
	
}
