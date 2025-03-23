import java.util.*;

// Approach 
// Check if the length of pattern is equal to number of words in string s
// Map each character to each word in string s
// Check if that character exists in HashMap
// If it exists in the HashMap then check if that string is equal to the current string, if not then return false
// If it does not exists, the we check if the word exists in Set if not then 
// Add string to HashMap and Set
// Else if the string exists in Set, if yes then that means the string is already mapped to some character thus return false

// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] strings = s.split(" ");


        if(pattern.length() != strings.length) return false;

        for(int i=0; i < pattern.length(); i++) {
            char chr = pattern.charAt(i);
            String word = strings[i];
            
            if(!map.containsKey(chr)) {
                if(set.contains(word)) return false;
                map.put(chr, word);
                set.add(word);
            }

            if(!map.get(chr).equals(word)) return false;
        }

        return true;
    }
}