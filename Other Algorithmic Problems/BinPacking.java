import java.util.*;
import java.io.*;
public class BinPacking {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bin_volume = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("\\s");
        int[] volumes = new int[s.length];
        for(int i=0;i<s.length;++i) volumes[i] = Integer.parseInt(s[i]);
        binPacking(volumes,bin_volume);
    }

    private static void binPacking(int[] volumes,final int BIN_LIMIT){
        List<Integer> bins = new ArrayList<>();
        bins.add(0); // at least 1 bin will always be required

        /* following first fit decreasing alogithm */
        Arrays.sort(volumes);
        reverse(volumes,0,volumes.length-1);

        for(int i=0;i<volumes.length;++i){
            int size = bins.size();
            for(int j=0;j<size;++j){
                if(bins.get(j) + volumes[i] <= BIN_LIMIT){
                    bins.set(j, bins.get(j) + volumes[i]);
                    break;
                }else if(j == size - 1){                
                    bins.add(volumes[i]);
                }
            }
        }

        System.out.println("Total no. of bins required: "  + bins.size());
        System.out.println(bins.toString());
    }

    private static void reverse(int[] arr,int left,int right){
        while(left < right){
            swap(arr,left++,right--);
        }
    }

    private static void swap(int[] arr,int ptr1,int ptr2){
        int temp  = arr[ptr1];
        arr[ptr1] = arr[ptr2];
        arr[ptr2] = temp;
    }
}
