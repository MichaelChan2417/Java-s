import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm that will check whether the given grid of numbers
 * represents a valid Sudoku puzzle according to the layout rules described above.
 * Note that the puzzle represented by grid does not have to be solvable.
 */
public class Sudoku {
    /**
     * Using Set to judge the duplicate. And for each element will value 3-type
     */
    boolean solution(char[][] grid) {
        int n = grid.length;

        Set<String> set = new HashSet<String>();

        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
                    return false;
                if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row/3 + " " + col/3))
                    return false;
            }
        }

        return true;
    }
}
