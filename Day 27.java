/*Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way. 
Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
*/
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List <List<Integer>> adjList = new ArrayList<>(N + 1); 
        for(int i = 0;i <= N; i++)
            adjList.add(new ArrayList<Integer> ());
        //Adjacency List creation
         for(int i = 0;i < dislikes.length; i++){
             adjList.get(dislikes[i][0]).add(dislikes[i][1]);
             adjList.get(dislikes[i][1]).add(dislikes[i][0]);
         }
        int group [] =new int [N+1];
        //BFS
        Queue <Integer> queue = new LinkedList<>();
        for(int i = 1;i <= N;i++){
            if(group[i] == 0){
            group[i] = 1;
            queue.add(i);
            while(!queue.isEmpty()){
                int n = queue.poll();
                for (int x : adjList.get(n)){
                    if(group[x] == 0){
                        if(group[n] == 1)
                            group[x] = 2;
                        else
                            group[x] = 1;
                        queue.add(x);
                    }
                    else if(group[x] == group[n])
                        return false;
                }                
                }
            }            
        }
        return true;                 
    }
}