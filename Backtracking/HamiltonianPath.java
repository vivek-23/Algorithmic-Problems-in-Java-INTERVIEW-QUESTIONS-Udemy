import java.util.*;
import java.io.*;
public class HamiltonianPath {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        int no_of_edges = Integer.parseInt(br.readLine());
        int[][] adj = new int[vertices][vertices];

        // Edges for example, "0 1" => represents edge between node 0 and node 1 (undirected, of course)

        for(int i=0;i<no_of_edges;++i){
            String[] s = br.readLine().split("\\s");
            int v1 = Integer.parseInt(s[0]);
            int v2 = Integer.parseInt(s[1]);
            adj[v1][v2] = 1;
            adj[v2][v1] = 1;
        }

        System.out.println(Arrays.toString(hamiltonianPath(adj)));
    }

    private static int[] hamiltonianPath(int[][] adj){
        int[] cycle_path = new int[adj.length + 1];
        Arrays.fill(cycle_path,-1);
        boolean[] visited = new boolean[adj.length];
        boolean exists = hamiltonianPathHelper(adj,visited,0,cycle_path,0);
        if(exists) cycle_path[adj.length] = 0;
        return cycle_path;
    }

    private static boolean hamiltonianPathHelper(int[][] adj,boolean[] vis,int node,int[] cycle_path,int total_visited){
        vis[node] = true;
        cycle_path[total_visited] = node;
        for(int i=0;i<adj.length;++i){
            if(adj[node][i] == 1){
                if(vis[i]){
                    if(i == 0 && total_visited + 1 == adj.length) return true;
                }else if(hamiltonianPathHelper(adj,vis,i,cycle_path,total_visited + 1)){
                    return true;
                }
            }
        }
        vis[node] = false;
        cycle_path[total_visited] = -1;
        return false;
    }
}
