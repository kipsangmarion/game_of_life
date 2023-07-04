import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int rows = 10; // Number of rows in the grid
        int cols = 20; // Number of columns in the grid

        int[][] grid = new int[rows][cols]; // Initialize the grid with all cells dead

        // Set some initial live cells
        grid[3][5] = 1;
        grid[4][5] = 1;
        grid[5][5] = 1;
        grid[5][4] = 1;
        grid[4][3] = 1;

        // Number of iterations (generations) to simulate
        int iterations = 20;

        // Perform iterations and print the grid at each step
        for (int i = 0; i < iterations; i++) {
            System.out.println("Generation " + i);
            printGrid(grid);
            grid = getNextGeneration(grid);
            try {
                Thread.sleep(500); // delay to make the changes visible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper method to print the grid
    private static void printGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Helper method to compute the next generation based on the current state
    private static int[][] getNextGeneration(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] newGrid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countLiveNeighbors(grid, i, j);
                if (grid[i][j] == 1) {
                    // Any live cell with fewer than two live neighbors dies (underpopulation)
                    // Any live cell with more than three live neighbors dies (overpopulation)
                    newGrid[i][j] = (liveNeighbors == 2 || liveNeighbors == 3) ? 1 : 0;
                } else {
                    // Any dead cell with exactly three live neighbors becomes a live cell (reproduction)
                    newGrid[i][j] = (liveNeighbors == 3) ? 1 : 0;
                }
            }
        }

        return newGrid;
    }

    // Helper method to count the number of live neighbors of a cell
    private static int countLiveNeighbors(int[][] grid, int row, int col) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Neighbors' relative positions (8-connectivity)
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            // Check if the neighbor is within the grid boundaries and is alive
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                count++;
            }
        }

        return count;
    }
}
