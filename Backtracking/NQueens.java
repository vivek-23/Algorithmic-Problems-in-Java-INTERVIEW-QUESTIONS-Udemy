import java.util.*;
import java.io.*;
class Queen{
    int x;int y;
    Queen(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    static char queen = 'Q';
    static char empty = '-';
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for(int i=0;i<board.length;++i) Arrays.fill(board[i],empty);
        Map<Queen,Integer> map = new HashMap<>();
        if(placeNQueens(board,0,N,map)){
            printBoard(board);
        }else{
            System.out.println("No solution found");
        }
    }

    private static boolean placeNQueens(char[][] board,int row,int N,Map<Queen,Integer> map){
        if(N == 0) return true;
        for(int i=row;i<board.length;++i){
            for(int j=0;j<board.length;++j){
                if(noClash(i,j,map)){
                    board[i][j] = queen;
                    Queen q = new Queen(i,j);
                    map.put(q,1);
                    if(placeNQueens(board,i+1,N-1,map)){
                        return true;
                    }
                    map.remove(q);
                    board[i][j] = empty;
                }
            }
        }

        return false;
    }

    private static boolean noClash(int row,int col,Map<Queen,Integer> map){
        for(Map.Entry<Queen,Integer> m : map.entrySet()){
            Queen q = m.getKey();
            if(q.x == row || q.y == col || Math.abs(row-q.x) == Math.abs(col-q.y)){
                return false;
            }
        }
        return true;
    }

    private static void printBoard(char[][] board){
        for(int i=0;i<board.length;++i){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
