import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(reverseInteger(s));
    }

    private static String reverseInteger(String s){
        boolean positive = true;
        if(s.charAt(0) == '-'){
            positive = false;
            s = s.substring(1);
        }
        StringBuilder res = new StringBuilder(s);
        String ans = removeLeadingZeroes(res.reverse().toString());
        return positive || ans.equals("0") ? ans : "-" + ans; 
    }

    private static String removeLeadingZeroes(String s){
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) != '0'){
                return s.substring(i);
            }
        }

        return "0";
    }
}
