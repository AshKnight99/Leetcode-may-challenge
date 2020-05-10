/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
*/
class Solution {
    private boolean isOnLine(int []p1,int[] p2,int []p3){
       int x = p1[0], y = p1[1], x1 = p2[0], y1 = p2[1], x2 = p3[0], y2 = p3[1];
        return ((y - y1) * (x2 - x1) == (y2 - y1) * (x - x1));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        for(int i = 2;i < coordinates.length; i++){
            
           
            if(!isOnLine(coordinates[i], coordinates[0], coordinates[1]))
                return false;
        }
        return true;
        
    }
}