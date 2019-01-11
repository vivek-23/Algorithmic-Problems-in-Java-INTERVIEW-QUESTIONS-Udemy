import java.util.*;
import java.io.*;
public class GraphColoring {
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

        int[] colors_assigned = colorGraph(adj);
        System.out.println(Arrays.toString(colors_assigned));
        Arrays.sort(colors_assigned);
        System.out.println("Minimum no. of colors required: " + (colors_assigned[colors_assigned.length-1] + 1));
    }

    private static int[] colorGraph(int[][] adj){
        int[] colors_assigned = new int[adj.length];
        boolean[] visited = new boolean[adj.length];
        Arrays.fill(colors_assigned,-1);
        assignColors(adj,colors_assigned,0,visited);
        return colors_assigned;
    }

    private static boolean assignColors(int[][] adj,int[] colors_assigned,int node,boolean[] visited){
        Set<Integer> color_set = new HashSet<Integer>();
        visited[node] = true;
        for(int i=0;i<adj.length;++i){
            if(adj[node][i] == 1){
                if(colors_assigned[i] != -1) color_set.add(colors_assigned[i]);                
            }
        }

        int color_received = getUnusedColor(adj.length,color_set);
        if(color_received == -1) return false;
        colors_assigned[node] = color_received;

        for(int i=0;i<adj.length;++i){
            if(!visited[i] && adj[node][i] == 1){
                if(assignColors(adj,colors_assigned,i,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static int getUnusedColor(int n,Set<Integer> color_set){
        for(int i=0;i<n;++i){
            if(color_set.contains(i)) continue;
            return i;
        }
        return -1;
    }
}
