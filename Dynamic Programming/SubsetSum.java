import java.util.*;
import java.io.*;
public class SubsetSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int[] nums = new int[s.length];
        for(int i=0;i<s.length;++i) nums[i] = Integer.parseInt(s[i]);
        int sum = Integer.parseInt(br.readLine());
        System.out.println(subsetExists(sum,nums));
    }

    private static boolean subsetExists(int sum,int[] nums){
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for(int i=0;i<dp.length;++i) dp[i][0] = true;

        for(int i=0;i<nums.length;++i){
            for(int j=1;j<=sum;++j){
                if(nums[i] > j){
                    dp[i + 1][j] = dp[i][j];
                }else{
                    dp[i + 1][j] = dp[i][j-nums[i]] || dp[i][j];
                }
                if(j == sum && dp[i + 1][j]){
                    showNumbers(dp,nums,i + 1,j);
                    System.out.print("\n");
                    return true;
                }
            }
        }

        return false;
    }

    private static void printTable(boolean[][] dp){
        for(int i=0;i<dp.length;++i){
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    private static void showNumbers(boolean[][] dp,int[] nums,int row,int col){
        if(col == 0 || row == 0) return;
        if(dp[row-1][col] == dp[row][col]) showNumbers(dp,nums,row-1,col);
        else{
            showNumbers(dp,nums,row-1,col - nums[row-1]);
            System.out.print(nums[row-1] + " ");
        }
    }
}
