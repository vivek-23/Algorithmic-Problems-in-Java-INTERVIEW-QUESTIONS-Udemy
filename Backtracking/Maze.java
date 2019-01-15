import java.util.*;
import java.io.*;
class Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Maze {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split("\\s");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] board = new int[N][M];
        for(int i=0;i<N;++i){
            s = br.readLine().trim().split("\\s");
            for(int j=0;j<M;++j){
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        List<Point> moves = solveMaze(board);
        if(moves.size() == 0){
            System.out.println("No solution exists");
        }else{
            for(int i=0;i<moves.size();++i){
                Point p = moves.get(i);
                if(i == moves.size()-1){
                    System.out.print("(" + p.x + "," + p.y + ")");
                }else{
                    System.out.print("(" + p.x + "," + p.y + ") => ");
                }
            }
            System.out.println();
        }
    }

    private static List<Point> solveMaze(int[][] board){
        List<Point> ans = new ArrayList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        solveMazeHelper(board,0,0,vis,ans);//Here, (0,0) is the seed we are considering
        Collections.reverse(ans);
        return ans;
    }

    private static boolean solveMazeHelper(int[][] board,int x,int y,boolean[][] vis,List<Point> ans){
        if(board[x][y] == 1) return false;
        vis[x][y] = true;
        Point curr = new Point(x,y);
        if(x == board.length-1 && y == board[0].length-1){ //reached final destination  (bottom right corner)
            ans.add(curr);
            return true;
        }   
        
        // move in all 4 directions
        if(isValidIndex(x-1,y,board.length,board[0].length) && !vis[x-1][y] && solveMazeHelper(board,x-1,y,vis,ans)){
            ans.add(curr);
            return true;
        }

        if(isValidIndex(x+1,y,board.length,board[0].length) && !vis[x+1][y] &&  solveMazeHelper(board,x+1,y,vis,ans)){
            ans.add(curr);
            return true;
        }

        if(isValidIndex(x,y-1,board.length,board[0].length) && !vis[x][y-1] &&  solveMazeHelper(board,x,y-1,vis,ans)){
            ans.add(curr);
            return true;
        }

        if(isValidIndex(x,y+1,board.length,board[0].length) && !vis[x][y+1] &&  solveMazeHelper(board,x,y+1,vis,ans)){
            ans.add(curr);
            return true;
        }

        return false;
    }

    private static boolean isValidIndex(int x,int y,int N,int M){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
