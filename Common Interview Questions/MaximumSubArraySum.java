import java.util.*;
import java.io.*;
public class MaximumSubArraySum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int[] arr = new int[s.length];
        for(int i=0;i<arr.length;++i){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(largestSubarraySum(arr));
    }

    private static int largestSubarraySum(int[] arr){
        int max_sum = arr[0],sum = 0;

        for(int i=0;i<arr.length;++i){
            sum += arr[i];
            max_sum = Math.max(max_sum,sum);
            if(sum < 0) sum = 0;
        }

        return max_sum;
    }
}
