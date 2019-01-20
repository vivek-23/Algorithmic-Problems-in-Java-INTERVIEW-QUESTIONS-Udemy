import java.util.*;
import java.io.*;
public class Anagram {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(isAnagram(s1,s2));
    }

    private static boolean isAnagram(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        int[] hash = new int[255];
        for(int i=0;i<s1.length();++i){
            hash[(int)s1.charAt(i)]++;
            hash[(int)s2.charAt(i)]--;
        }

        for(int i=0;i<hash.length;++i){
            if(hash[i] != 0) return false;
        }

        return true;
    }
}
