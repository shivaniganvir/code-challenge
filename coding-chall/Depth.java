
import java.util.*;

class Depth {
    private int vertices; 
    private LinkedList<Integer>[] adjList; 

    
    Depth(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge between two vertices
    void addEdge(int v, int w) {
        adjList[v].add(w); // Add w to v's adjacency list
    }

    // Helper method for DFS traversal
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all vertices adjacent to this vertex
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // Method to perform DFS traversal starting from a given vertex
    void DFS(int startVertex) {
        // Array to keep track of visited vertices
        boolean[] visited = new boolean[vertices];

        // Call the recursive helper function to perform DFS traversal
        DFSUtil(startVertex, visited);
    }
    
    // Optional: Perform DFS for all components in case of a disconnected graph
    void DFSFullTraversal() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                System.out.println(); // To separate components in output
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph with 6 vertices
        Depth graph = new Depth(6);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform DFS traversal starting from vertex 0
        System.out.println("DFS traversal starting from vertex 0:");
        graph.DFS(0);

        // Perform DFS for full traversal (for disconnected graphs)
        System.out.println("\nDFS full traversal:");
        graph.DFSFullTraversal();
    }
}
