/*Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }        
        for(Map.Entry<Integer,Integer> ent:map.entrySet()){
            if(ent.getValue()>n/2)
                return ent.getKey();
        }
        return -1;        
    }
}