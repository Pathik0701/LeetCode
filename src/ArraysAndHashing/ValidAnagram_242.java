package ArraysAndHashing;

import java.util.*;

class ValidAnagram_242  {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        else{
            char[] s1 = s.toCharArray();
            Arrays.sort(s1);

            char[] t1 = t.toCharArray();
            Arrays.sort(t1);

            if(Arrays.equals(s1, t1)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}