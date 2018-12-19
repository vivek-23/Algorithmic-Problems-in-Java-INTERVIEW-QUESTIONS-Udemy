import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int[] nums = new int[s.length];
        for(int i=0;i<nums.length;++i) nums[i] = Integer.parseInt(s[i]);    
        // sort the array 
        Arrays.sort(nums);
        int search_number = Integer.parseInt(br.readLine());    
     	System.out.println("Linear Search: " + linearSearch(search_number,nums));
     	System.out.println("Binary Search: " + binarySearch(search_number,nums));
    }

    private static boolean linearSearch(int x,int[] nums){
    	for(int i=0;i<nums.length;++i){
    		if(nums[i] == x) return true;
    	}
    	return false;
    }	

    private static boolean binarySearch(int x,int[] nums){
    	int low = 0,high = nums.length-1;
    	int mid = 0;
    	while(low <= high){
    		mid = low + (high - low) / 2;
    		if(nums[mid] == x) return true;
    		else if(nums[mid] > x) high = mid - 1;
    		else low = mid + 1;
    	}
    	return false;
    }
}
