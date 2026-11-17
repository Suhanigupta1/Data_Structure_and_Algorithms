import java.util.*;
class Solution {
    class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest; 
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        if(n==0 ){
            return true;
        }
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n] ;
        boolean[] stack = new boolean[n];
        for(int i=0; i<prerequisites.length; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph[u].add(new Edge(u, v));
        }
        for(int k=0; k<n; k++){
            if(!visited[k]){
                if(detectCycle(numCourses, graph, visited, k , stack)){
                    return false;
                }
            }
        }
        return  true;
    }

    public boolean detectCycle(int numCourses, ArrayList<Edge>[] graph, boolean[] visited,int src, 
    boolean[] stack ){ 
        visited[src] = true;
        stack[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if (stack[e.dest]){
                return true;
            }
            else if(!visited[e.dest] && detectCycle(numCourses, graph, visited, e.dest, stack)){
                return true;  
            } 
        }
        stack[src] = false;
        return false;
    }
}