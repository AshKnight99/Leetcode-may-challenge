/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
*/
//Using Topolgical sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree [] = new int[numCourses];
        //to check incoming edges;
        for(int i = 0;i < prerequisites.length; i++)
            indegree[prerequisites[i][0]]++;
        
        Stack <Integer> stack = new Stack <>();
        int count = 0;
        
        for(int i = 0; i < indegree.length; i++)
            if(indegree[i] == 0)
                stack.push(i);
        //System.out.print(stack);
        
        while(!stack.isEmpty()){
            int value = stack.pop();
            count++;            
            for(int i = 0; i < prerequisites.length;i++){
                if(prerequisites[i][1] == value){
                    indegree[prerequisites[i][0]]--;                
                    if(indegree[prerequisites[i][0]] == 0)
                        stack.push(prerequisites[i][0]);
                }                
            }                
        }
        return count == numCourses;        
    }
}