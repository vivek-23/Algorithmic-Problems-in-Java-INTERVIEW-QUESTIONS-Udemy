import java.util.*;
import java.io.*;
public class RodCutting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_length = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("\\s");
        int[] lengths = new int[s.length];
        for(int i=0;i<s.length;++i) lengths[i] = Integer.parseInt(s[i]);
        s = br.readLine().split("\\s");
        int[] prices = new int[s.length];
        for(int i=0;i<s.length;++i) prices[i] = Integer.parseInt(s[i]);
        System.out.println(rodCutting(total_length,lengths,prices));
    }

    private static int rodCutting(int total_length,int[] lengths,int[] prices){
        int[][] dp = new int[lengths.length + 1][total_length + 1];
        for(int i=0;i<lengths.length;++i){
            for(int j=1;j<=total_length;++j){
                if(lengths[i] > j){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = Math.max(dp[i][j],prices[i] + dp[i + 1][j - lengths[i]]);
                }
            }
        }

        return dp[lengths.length][total_length];
    }
}
