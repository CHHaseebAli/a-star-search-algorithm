# A* Search Algorithm

## Description

The **A* Search Algorithm** (pronounced "A-star") is a popular and efficient pathfinding algorithm widely used in computer science, robotics, and AI for finding the shortest path between a starting point and a goal point. The algorithm combines aspects of both **Dijkstra's Algorithm** (which focuses on exploring the shortest known path) and **Greedy Best-First Search** (which uses a heuristic to estimate the best path).

This project provides an implementation of the A* algorithm for solving grid-based pathfinding problems. The grid can include obstacles, varying costs, and a heuristic to help guide the search. The primary goal is to find the most efficient path from a given starting point to a destination point on a grid.

### Key Features:
- **Pathfinding on Grid Layouts:** The algorithm works on grid-based layouts with obstacles and varying movement costs.
- **Heuristic Approach (Manhattan Distance):** The algorithm uses the Manhattan Distance heuristic to estimate the cost of reaching the goal from any given point on the grid.
- **Grid Exploration:** The algorithm explores neighboring nodes, expanding to adjacent nodes that offer the lowest total estimated cost (`f = g + h`).
- **Step-by-Step Visualization:** The project includes a visualization of how the A* algorithm explores the grid, expands nodes, and traces the final path.
- **Multiple Grid Layouts:** Several different grid layouts are provided to demonstrate the algorithm’s application in various scenarios, including obstacles, open paths, and different start/end positions.

### Problem Solved:
The project demonstrates how to efficiently navigate a grid, avoiding obstacles and selecting the optimal path. It is particularly useful for game development, robotics, and AI systems where navigation is required on a 2D map or grid.

## How the A* Algorithm Works

### Key Components of A*:
1. **Start and Goal Nodes:** These are the initial and destination points on the grid.
2. **Open List:** A list of nodes that need to be explored. Initially, only the start node is added to this list.
3. **Closed List:** A list of nodes that have already been explored. The algorithm will not re-examine these nodes.
4. **Cost (g):** The actual cost to move from the start node to the current node.
5. **Heuristic (h):** A heuristic estimate of the cost to move from the current node to the goal node. In this project, we use the **Manhattan Distance** as the heuristic.
6. **Total Cost (f = g + h):** This is the sum of the actual cost and the heuristic estimate. The algorithm always explores the node with the lowest `f` value first.
   
### Steps of the A* Search:
1. **Initialization:** Place the start node in the open list and begin exploring.
2. **Explore Nodes:** Expand nodes in the open list. For each node, calculate its `f`, `g`, and `h` values.
3. **Node Expansion:** Move the node from the open list to the closed list once it has been explored. Add its valid neighbors to the open list.
4. **Reaching the Goal:** The algorithm continues exploring until it finds the goal node. Once found, the path is constructed by following the parent nodes from the goal back to the start.
5. **Termination:** If the goal node is reached, the algorithm traces back the path. If the open list is empty, it means no path exists.

### Heuristic Explanation (Manhattan Distance):
The Manhattan Distance is a simple heuristic that calculates the sum of the horizontal and vertical distances between two points on a grid, making it suitable for grid-based pathfinding. The formula is:

h = |x2 - x1| + |y2 - y1|

### Key Steps to Follow:
1. **Clone the repository**
2. Open the project in **NetBeans** and run the `Main.java` file to start visualizing the A* algorithm.


