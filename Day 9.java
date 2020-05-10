/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0)
            return false;
        if(num == 1)
            return true;
        long l = 1;
        long  r = num;
        while (l <= r) {
            long  mid = l + (r - l )/2;
            long  square_val  =  mid * mid;
        if (square_val == num) {
            return true;
        } else if (square_val > num) {
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    return false;
    }
}