import java.util.*;
import java.io.*;
public class PalindromeChecking {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        if(s == null) return false;
        int left = 0,right = s.length() - 1;
        while(left < right){
            if(s.charAt(left++) == s.charAt(right--)) continue;
            return false;
        }       
        return true;
    }
}
