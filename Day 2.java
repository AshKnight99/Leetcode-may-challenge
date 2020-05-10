/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character,Integer> map=new HashMap<>();
        int cnt=0;
        for(int i=1;i<=S.length();i++){
           // map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
            if(J.contains(S.substring(i-1,i)))
                cnt++;
        }
        return cnt;

    }
}
