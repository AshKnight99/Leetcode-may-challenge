/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
*/
class Solution {
    public int findComplement(int num) {
        String s= new String(Integer.toBinaryString(num));
        String s1="";
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='0')
                s1+="1";
            else
                s1+="0";
        return Integer.parseInt(s1,2);       
    }
}