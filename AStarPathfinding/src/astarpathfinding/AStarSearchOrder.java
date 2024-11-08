package astarpathfinding;

import java.util.PriorityQueue;

public class AStarSearchOrder {
    private PriorityQueue<GridState> fringe;

    public AStarSearchOrder() {
        fringe = new PriorityQueue<>((a, b) -> Integer.compare(a.getTotalCost(), b.getTotalCost()));
    }

    public void addToFringe(GridState state) {
        fringe.add(state);
    }

    public GridState removeFromFringe() {
        return fringe.poll();
    }

    public boolean isEmpty() {
        return fringe.isEmpty();
    }
}
