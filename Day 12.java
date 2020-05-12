/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){                        
            int mid = (left + right) / 2;
           // System.out.print("\nMid:" + mid + "Element is:" + nums[mid] );            
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid + 1])
                    left = mid + 2;
                else
                    right = mid-1;
            }
            else if(mid % 2 == 1){
                if(nums[mid] == nums[mid - 1])
                    left = mid + 1;                    
                else
                    right = mid - 1;                    
            }
        }
        return nums[left];        
    }
}