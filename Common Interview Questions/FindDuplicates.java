import java.util.*;
import java.io.*;
public class FindDuplicates {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split("\\s");
            int[] arr = new int[s.length];
            for(int i=0;i<arr.length;++i){
                arr[i] = Integer.parseInt(s[i]);
            }
        
        findDuplicates(arr);
    }

    private static void findDuplicates(int[] arr){
      // using map because I want to make it work for negative integers as well.
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<arr.length;++i){
            if(map.containsKey(arr[i])){
                System.out.println(arr[i]);
            }else{
                map.put(arr[i],1);
            }
       }
    }
}
