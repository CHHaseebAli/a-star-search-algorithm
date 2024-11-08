package astarpathfinding;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearchMain {
    public static void main(String[] args) {
        // Example grid with 0s (path) and -1s (obstacles)
        int[][] grid = {
            {0, 0, 0, 0, 0}, // Row 0
            {0, -1, -1, 0, 0}, // Row 1
            {0, 0, 0, -1, 0}, // Row 2
            {0, -1, 0, 0, 0}, // Row 3
            {0, 0, 0, 0, 0}  // Row 4
        };

        GridState.setGrid(grid);

        // Define start and goal states
        GridState start = new GridState(0, 0, 0, 4, 4, null); // Start at (0, 0)
        AStarSearchOrder searchOrder = new AStarSearchOrder();
        Set<GridState> closedSet = new HashSet<>();
        StringBuilder expandedStates = new StringBuilder();
        
        searchOrder.addToFringe(start);
        expandedStates.append("[" + start.getX() + ", " + start.getY() + "]"); // Add starting state

        while (!searchOrder.isEmpty()) {
            GridState currentState = searchOrder.removeFromFringe();

            if (currentState.isGoal()) {
                System.out.println("Path found!");
                printPath(currentState);
                System.out.println("Goal Path: " + printPath(currentState));
                System.out.println("Total Cost: " + currentState.getCost());
                return;
            }

            closedSet.add(currentState);
            for (GridState neighbor : currentState.getNeighbors()) {
                if (closedSet.contains(neighbor)) continue;

                searchOrder.addToFringe(neighbor);
                expandedStates.append(" → [" + neighbor.getX() + ", " + neighbor.getY() + "]");
            }
        }

        System.out.println("No path found.");
    }

    private static String printPath(GridState state) {
        if (state == null) return "";
        return printPath(state.getParent()) + " → (" + state.getX() + ", " + state.getY() + ")";
    }
}
