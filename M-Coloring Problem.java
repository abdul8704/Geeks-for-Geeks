// You are given an undirected graph consisting of V vertices and E edges represented by a list edges[][], along with an integer m. Your task is to determine whether it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. Return true if the graph can be colored with at most m colors, otherwise return false.
// Note: The graph is indexed with 0-based indexing.

// Examples:
// Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
// Output: true
// Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:
// Vertex 0: Color 1
// Vertex 1: Color 2
// Vertex 2: Color 2
// Vertex 3: Color 3

// Input: V = 3, edges[][] = [[0, 1], [1, 2], [0, 2]], m = 2
// Output: false
// Explanation: It is not possible to color the given graph using only 2 colors because vertices 0, 1, and 2 form a triangle.

// Constraints:
// 1 ≤ V ≤ 10
// 1 ≤ E = edges.size() ≤ (V*(V-1))/2
// 0 ≤ edges[i][j] ≤ V-1
// 1 ≤ m ≤ V

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        HashMap<Integer, Set<Integer>> adjList = new HashMap<>();
        int[] colors = new int[v];
        
        for(int i=0; i<v; i++)
            colors[i] = -1;
        
        for(int[] node: edges){
            if(node[0] == node[1])
                continue;
            if(adjList.containsKey(node[0])){
                adjList.get(node[0]).add(node[1]);
            }
            else{
                adjList.put(node[0], new HashSet<>());
                adjList.get(node[0]).add(node[1]);
            }
            
            if(adjList.containsKey(node[1])){
                adjList.get(node[1]).add(node[0]);
            }
            else{
                adjList.put(node[1], new HashSet<>());
                adjList.get(node[1]).add(node[0]);
            }
            
        }

        return helper(v, adjList, m, 0, colors);
    }
    
    private static boolean helper(int V, HashMap<Integer, Set<Integer>> adjList, int m, int vertex, int[] colorMap){
        if(vertex == V)
            return true;
        
        for(int color=1; color<= m; color++){
            colorMap[vertex] = color;
            if(canUse(color, adjList, vertex, colorMap))
                if(helper(V, adjList, m, vertex+1, colorMap))
                    return true;
            
            colorMap[vertex] = -1;        
        }
        
        return false;
    }
    private static boolean canUse(int color, HashMap<Integer, Set<Integer>> adjList, int vertex, int[] colorMap){
        if(!adjList.containsKey(vertex))
            return true;
        
        for(int neighbour: adjList.get(vertex)){
            if(colorMap[neighbour] == color)
                return false;
        }
        
        return true;
    }
    
}