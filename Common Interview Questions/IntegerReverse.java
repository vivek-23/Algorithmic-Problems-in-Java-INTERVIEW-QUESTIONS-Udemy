import java.util.*;
import java.io.*;
public class IntegerReverse {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(reverseInteger(s));
    }

    private static String reverseInteger(String s){
        StringBuilder res = new StringBuilder(s);
        return removeLeadingZeroes(res.reverse().toString());
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
