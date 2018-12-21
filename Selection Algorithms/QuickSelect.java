import java.util.*;
import java.io.*;
public class QuickSelect {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("\\s");
        int[] arr = new int[s.length];
        for(int i=0;i<arr.length;++i) arr[i] = Integer.parseInt(s[i]);
        int kth_smallest = Integer.parseInt(br.readLine());
        System.out.println(quickSelect(arr,kth_smallest));
    }

    private static int quickSelect(int[] arr,int kth_smallest){
        return quickSelectHelper(arr,0,arr.length-1,kth_smallest);
    }

    private static int quickSelectHelper(int[] arr,int low,int high,int kth_smallest){
        if(low == high) return arr[low];
        int pivot = low + (high - low) / 2;
        swap(arr,pivot,high);
        int idx = low;
        for(int i=low;i<high;++i){
            if(arr[i] < arr[high]){
                swap(arr,idx++,i);
            }
        }
        swap(arr,idx,high);
        if(idx + 1 == kth_smallest) return arr[idx];
        else if(idx + 1 > kth_smallest) return quickSelectHelper(arr,low,idx-1,kth_smallest);
        return quickSelectHelper(arr,idx + 1,high,kth_smallest);
    }

    private static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
