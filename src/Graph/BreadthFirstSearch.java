package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    // The source or starting point is given
    void BFS(ArrayList<ArrayList<Integer>> adj, int V, int s){
        boolean[] visited = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if (!visited[v]){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    // No source is given and graph may be disconnected
    void BFS(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for(int v : adj.get(u)){
                if (!visited[v]){
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
    void BFSDis(ArrayList<ArrayList<Integer>> adj, int V){
        boolean[] visited = new boolean[V+1];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                BFS(adj, i, visited);
            }
        }
    }
}
