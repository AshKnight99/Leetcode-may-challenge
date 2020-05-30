/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
*/
class Solution {
    class Node{
        int distance,index;
        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue <Node> pq = new PriorityQueue<>((a,b) -> (a.distance - b.distance));
        for(int i = 0;i < points.length; i++){
            int dist = (int) (Math.pow((double)points[i][0],2.0) + Math.pow((double)points[i][1],2.0));
            pq.add(new Node(i,dist));
        }
        int arr [][] = new int[K][2];
        for(int i = 0 ;i < K; i++){
            Node temp = pq.poll();
            arr[i][0] = points[temp.index][0];
            arr[i][1] = points[temp.index][1];
        }
        return arr;           
    }
}