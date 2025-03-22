import java.util.*;

// Solution with two hashMaps
// With Using two loops and using single loop
class Solution1 {
    public boolean isIsomorphic(String str1, String str2) {
        HashMap<Character, Character> str1Map = new HashMap<>();
        HashMap<Character, Character> str2Map = new HashMap<>();

        if(str1.length() != str2.length()) return false;
        
        for(int i=0; i < str1.length(); i++) {
            char str1Char = str1.charAt(i);
            char str2Char = str2.charAt(i);

            if(!str1Map.containsKey(str1Char)) {
                str1Map.put(str1Char, str2Char);
            } else {
                if(str1Map.containsKey(str1Char) && str1Map.get(str1Char) != str2Char) {
                    return false;
                }
            }

            if(!str2Map.containsKey(str2Char)) {
                str2Map.put(str2Char, str1Char);
            } else {
                if(str2Map.containsKey(str2Char) && str2Map.get(str2Char) != str1Char) {
                    return false;
                }
            }
        }

        // WE can use two loops where we can go over str1 and then str2
        // for(int i=0; i < str2.length(); i++) {
        //     if(!str2Map.containsKey(str2.charAt(i))) {
        //         str2Map.put(str2.charAt(i), str1.charAt(i));
        //     } else {
        //         if(str2Map.containsKey(str2.charAt(i)) && str2Map.get(str2.charAt(i)) != str1.charAt(i)) {
        //             return false;
        //         }
        //     }
        // }

        return true;
    }
}

// Solution with HashMap + HashSet
class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(sMap.containsKey(sChar)) {
                if(sMap.get(sChar) != tChar) return false;
            } 
            // does not contain character
            else {
                if(set.contains(tChar)) return false;
                sMap.put(sChar, tChar);
                set.add(tChar);
            }
        }

        return true;
    }
}