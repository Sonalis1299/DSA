class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            int[] count = new int[26];
            for(char ch: word.toCharArray()){
                count[ch - 'a']++;
            }
            StringBuilder str = new StringBuilder();
            for(int freq: count){
                str.append(freq).append("#");
            }
           String key = str.toString();
           map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
} 