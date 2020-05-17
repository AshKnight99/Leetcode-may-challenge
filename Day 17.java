/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] letters = new int[26];
        
        for(int i = 0; i < p.length(); i++) {
            letters[p.charAt(i) - 'a']++;
        }
        
        int j = 0;
        int rem = p.length();
        List<Integer> result = new ArrayList();
        
        for(int i = 0; i < s.length(); i++) {
            while(j < s.length() && j - i < p.length()) {
                if(letters[s.charAt(j++) - 'a']-- > 0) {
                    rem--;
                }
            }
            if(rem == 0 && j - i == p.length()) 
                result.add(i);
            
            if(letters[s.charAt(i) - 'a']++ >= 0) 
                rem++;
        }
        
        return result;           
        
    }
}