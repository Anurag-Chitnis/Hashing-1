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