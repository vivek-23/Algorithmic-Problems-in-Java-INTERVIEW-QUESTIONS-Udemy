import java.util.*;
import java.io.*;
public class KnightTourBacktracking {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] board = new int[N][M];
        if(isKnightTourPossible(board)){
            for(int i=0;i<board.length;++i){
                for(int j=0;j<board[0].length;++j){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("No solution Possible");
        }
    }

    private static boolean isKnightTourPossible(int[][] board){
        boolean[][] vis = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                if(isKnightTourPossibleHelper(board,i,j,vis,1)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isKnightTourPossibleHelper(int[][] board,int x,int y,boolean[][] vis,int curr_step){
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 

        vis[x][y] = true;
        board[x][y] = curr_step;
        
        if(curr_step == board.length * board[0].length) return true;// we got a way
        
        for(int i=0;i<xMove.length;++i){
            int new_x = x + xMove[i];
            int new_y = y + yMove[i];
            if(isValidIndex(new_x,new_y,board.length,board[0].length)){
                if(!vis[new_x][new_y] && isKnightTourPossibleHelper(board,new_x,new_y,vis,curr_step + 1)){
                    return true;
                }
            }
        }


        vis[x][y] = false;
        board[x][y] = 0;
        return false;
    }

    private static boolean isValidIndex(int x,int y,int N,int M){
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
