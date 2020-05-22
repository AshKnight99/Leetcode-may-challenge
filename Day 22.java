/*
Given a string, sort it in decreasing order based on the frequency of characters.
Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

*/

class Solution {
    public String frequencySort(String s) {
        HashMap <Character,Integer> map = new HashMap <>();
        for(char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        PriorityQueue <Character> maxheap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));       
        maxheap.addAll(map.keySet());
        System.out.print(maxheap);
        
        StringBuilder result = new StringBuilder();
       
        while(maxheap.size() != 0){
            char value = maxheap.remove();
            for(int i = 0;i < map.get(value); i++)
                result.append(value);                
        }        
        return result.toString();        
    }
}