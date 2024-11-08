package astarpathfinding;

public class GridState {
    private int x;
    private int y;
    private int cost;
    private int goalX;
    private int goalY;
    private GridState parent; // To reconstruct the path
    private static int[][] grid; // Static grid shared across instances

    public GridState(int x, int y, int cost, int goalX, int goalY, GridState parent) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.goalX = goalX;
        this.goalY = goalY;
        this.parent = parent;
    }

    // Set the grid for all GridState objects
    public static void setGrid(int[][] grid) {
        GridState.grid = grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return cost;
    }

    public int getTotalCost() {
        return cost + getHeuristic();
    }

    // Manhattan distance heuristic
    public int getHeuristic() {
        return Math.abs(goalX - x) + Math.abs(goalY - y);
    }

    public GridState getParent() {
        return parent;
    }

    public boolean isGoal() {
        return x == goalX && y == goalY;
    }

    public boolean isValid() {
        // Check for grid boundaries and obstacles (-1 represents walls)
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != -1;
    }

    // Get neighboring valid states
    public GridState[] getNeighbors() {
        GridState[] neighbors = new GridState[4];
        int index = 0;

        // Possible movements: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            GridState neighbor = new GridState(newX, newY, cost, goalX, goalY, this);
            if (neighbor.isValid()) {
                // Determine the cost based on the type of square
                int newCost = grid[newX][newY] == 2 ? cost + 2 : cost + 1; // Grey squares (2) cost 2, white squares cost 1
                neighbors[index++] = new GridState(newX, newY, newCost, goalX, goalY, this);
            }
        }

        return java.util.Arrays.copyOf(neighbors, index); // Return only the valid neighbors
    }

    // Print the goal path by backtracking through parents
    public void printPath() {
        GridState current = this; // Start from goal state
        while (current != null) {
            System.out.print("(" + current.getX() + ", " + current.getY() + ") ");
            current = current.getParent();
        }
        System.out.println();
    }
}
