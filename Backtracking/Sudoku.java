class Sudoku {
    public void solveSudoku(char[][] board) {
        if(solveSudokuHepler(board,0,0)){
          // print board
        }else{
          System.out.println("Not solvable");
        }
    }
    
    private boolean solveSudokuHepler(char[][] board,int row,int col){
        for(int i=row;i<board.length;++i){
            for(int j= i == row ? col : 0;j<board[0].length;++j){
                if(board[i][j] == '.'){
                    for(int k=1;k<=9;++k){
                        board[i][j] = (char)(48 + k);
                        if(rowClear(board,i) && columnClear(board,j) && cellClear(board,i,j)){
                            int[] res = nextCell(i,j,board.length,board[0].length);
                            if(solveSudokuHepler(board,res[0],res[1])){
                                return true;
                            }
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    
    private int[] nextCell(int i,int j,int rows,int cols){
        if(j + 1 == cols) return new int[]{i + 1,0};
        return new int[]{i,j+1};
    }
    
    private boolean cellClear(char[][] board,int x,int y){
        boolean[] visited = new boolean[10];
        int row = x / 3 * 3;
        int col = y / 3 * 3;
        for(int i=row;i<row + 3;++i){
            for(int j=col;j<col + 3;++j){
                if(board[i][j] != '.'){
                    if(visited[board[i][j] - '0']) return false;
                    visited[board[i][j] - '0'] = true;
                }
            }
        }
        return true;
    }
    
    private boolean columnClear(char[][] board,int col){
        boolean[] visited = new boolean[10];
        for(int i=0;i<board.length;++i){
            if(board[i][col] != '.'){
                if(visited[board[i][col] - '0']) return false;
                visited[board[i][col] - '0'] = true;
            }            
        }
        return true;
    }
    
    private boolean rowClear(char[][] board,int row){
        boolean[] visited = new boolean[10];
        for(int i=0;i<board[0].length;++i){
            if(board[row][i] != '.'){
                if(visited[board[row][i] - '0']) return false;
                visited[board[row][i] - '0'] = true;
            }            
        }
        return true;
    }
}
