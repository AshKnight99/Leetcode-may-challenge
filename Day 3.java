/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.
Note:
You may assume that both strings contain only lowercase letters.
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map_ran=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            map_ran.put(ransomNote.charAt(i),map_ran.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> ent:map_ran.entrySet()){
            if(!map.containsKey(ent.getKey()))
                return false;
            System.out.print(ent.getKey()+":"+map.get(ent.getKey()));
            if(map.get(ent.getKey())<ent.getValue())
                return false;
        }
        return true;
    }
}
