// https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralMatrix = new ArrayList ();
        int rows = matrix.length;
        if(rows==0){
            return Collections.emptyList();
        }
        int columns = matrix[0].length;
        boolean[][] seen = new boolean[rows+2][columns+2];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int di = 0, row=0, column=0;
        for(int i=0; i<rows+2; i++){
            seen[i][0] = true;
            seen[i][columns+1] = true;
        }
        for(int i=0; i<columns+2; i++){
            seen[0][i] = true;
            seen[rows+1][i] = true;
        }
        for(int i=0; i<rows*columns; i++){
            spiralMatrix.add(matrix[row][column]);
            seen[row+1][column+1] = true;
            int newRow = row + dr[di];
            int newColumn = column + dc[di];
            if(!seen[newRow+1][newColumn+1]){
                row = newRow;
                column = newColumn;
            }else{
                di = (di+1)%4;
                row += dr[di];
                column += dc[di];
            }
        }
        return spiralMatrix;
    }
}