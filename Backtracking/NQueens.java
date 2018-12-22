import java.util.*;
import java.io.*;
public class Solution {
    static char queen = 'Q';
    static char empty = '-';
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for(int i=0;i<board.length;++i) Arrays.fill(board[i],empty);
        if(placeNQueens(board,N)){
            printBoard(board);
        }else{
            System.out.println("No solution found");
        }
    }

    private static boolean placeNQueens(char[][] board,int N){
        if(N == 0) return true;
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board.length;++j){
                if(verticalClear(board,j) && horizontalClear(board,i) && diagonalLeftClear(board,i,j) && diagonalRightClear(board,i,j)){
                    board[i][j] = queen;
                    if(placeNQueens(board,N-1)){
                        return true;
                    }
                    board[i][j] = empty;
                }
            }
        }

        return false;
    }

    private static void printBoard(char[][] board){
        for(int i=0;i<board.length;++i){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private static boolean verticalClear(char[][] board,int col){
        for(int i=0;i<board.length;++i){
            if(board[i][col] == queen) return false;
        }
        return true;
    }

    private static boolean horizontalClear(char[][] board,int row){
        for(int i=0;i<board.length;++i){
            if(board[row][i] == queen) return false;
        }
        return true;
    }

    private static boolean diagonalLeftClear(char[][] board,int row,int col){
        for(int i=row,j=col;i<board.length && j < board.length;++i,++j){
            if(board[i][j] == queen) return false;
        }

        for(int i=row,j=col;i>=0 && j >= 0;--i,--j){
            if(board[i][j] == queen) return false;
        }

        return true;
    }

    private static boolean diagonalRightClear(char[][] board,int row,int col){
        for(int i=row,j=col;i>=0 && j < board.length;--i,++j){
            if(board[i][j] == queen) return false;
        }

        for(int i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j] == queen) return false;
        }
        
        return true;
    }
}
