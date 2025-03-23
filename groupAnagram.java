import java.util.*;

// Approach
// For the given array of strings
// We need to sort the current string and check if it exists in HashMap
// If yes then we can store this store inside a list
// If no then we can add that to the HashMap

// Time Complexity: O(N * K Log K)
// Space Complexity: O(N)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs) { // O(N)
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr); // O(K Log K)
            String sortedString = String.valueOf(charArr);

            if(!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }

            map.get(sortedString).add(str);
        }

        return new ArrayList<>(map.values());
    }
}