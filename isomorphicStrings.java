import java.util.*;

// Approach in solution 1:
// We are taking two hashmaps and maintain mapping of each character of str1 -> str2
// loop over first string and map each character of str1 to str2
// loop over second string and map each character of str2 to str1
// if the character is already mapped then check if the mapped character is equal to the current character in another string 
//    - If yes, then we move ahead otherwise it's not isomorphic string
// We repeat this process while looping over str2
// Time complexity: O(2N) -> O(N). Since this is two pass approach time complexity would be O(2N) but since constant does not matter it would be O(N)
// Space complexity: O(2 * 26) -> O(1). Since, we can only store at max 26 characters in each hashmap thus space would be O(1)


// Approach in solution 2:
// We are using HashMap and HashSet
// Note the time and space complexity in this approach woudln't change
// Even if we are using Single HashMap in approach 1, still the space complexity would be same and time too.

// In apporach two
// We check if current character in str1 is mapped to current character in str2 and is present in HashMap
// If it's present in HashMap
//      Check if character that current character in Str1 in mapped to is equal to str2's current character, if not then it's not isomorphic
// If it's not present in Hashmap
//      Check if it's present in hashset which means the character is already mapped to something that would mean it's not isomorphic
//      Otherwise just add the character to Hashmap and Hashset


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