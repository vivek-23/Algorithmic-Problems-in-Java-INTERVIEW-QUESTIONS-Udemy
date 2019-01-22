import java.util.*;
import java.io.*;
public class TwoEggProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int eggs   = Integer.parseInt(br.readLine());
        int floors = Integer.parseInt(br.readLine());
        System.out.println(miniumNumberOfDrops(eggs,floors));
    }

    private static int miniumNumberOfDrops(int eggs,int floors){
        int[][] dp = new int[eggs + 1][floors + 1];
        for(int i=0;i<dp[0].length;++i) dp[0][i] = 1;
        for(int i=0;i<dp.length;++i) dp[i][0] = 1;

        for(int n = 1;n <= eggs; ++ n){
            for(int m = 1;m <= floors; ++m){
                if(n == 1){
                    dp[n][m] = m;
                    continue;
                }
                dp[n][m] = floors + 1;
                for(int k = 1; k <= m; ++k){
                    dp[n][m] = Math.min(dp[n][m], 1 + Math.max(dp[n-1][k-1],dp[n][m-k]));
                }
            }
        }

        return dp[eggs][floors];
    }
}
