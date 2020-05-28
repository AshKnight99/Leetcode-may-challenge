/*
Given a non negative integer number num. For every numbers i in the range 0 ? i ? num calculate the number of 1's in their binary representation and return them as an array.
Example 1:
Input: 2
Output: [0,1,1]
Example 2:
Input: 5
Output: [0,1,1,2,1,2]
Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
*/
class Solution {
    public int[] countBits(int num) {
        int arr [] = new int [num + 1];
        // if num is even, bit count is same as num / 2
        // if odd, bit count is same as (num / 2) + 1
        for(int i = 1;i <= num;i++)
            arr[i] = arr[i/2] + (i % 2);
        return arr;        
    }
}