import java.util.*;
import java.io.*;
public class CoinChange {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_amount = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("\\s");
        int[] coins = new int[s.length];
        for(int i=0;i<s.length;++i) coins[i] = Integer.parseInt(s[i]);
        System.out.println(numberOfWays(coins,total_amount));
    }

    private static int numberOfWays(int[] coins,int total_amount){
        int[] dp = new int[total_amount + 1];
        dp[0] = 1;
        for(int i=0;i<coins.length;++i){
            for(int j=coins[i];j<=total_amount;++j){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[total_amount];
    }
}
