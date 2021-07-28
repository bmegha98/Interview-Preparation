/*
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
*/
//need to validate only filled cells. unique numbers in each row, column and box.
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] A) {
        Set<String> aux = new HashSet<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++){
                char ch = A[i].charAt(j);
                if(ch == '.')
                    continue;
                int r = i/3, c = j/3;
                if(aux.contains("row_"+i+"_"+ch) || aux.contains("col_"+j+"_"+ch) ||
                    aux.contains("box_"+r+"_"+c+"_"+ch))
                    return 0;
                aux.add("row_"+i+"_"+ch);
                aux.add("col_"+j+"_"+ch);
                aux.add("box_"+r+"_"+c+"_"+ch);
            }
        }
        return 1;
    }
}
