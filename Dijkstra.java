import java.util.*;

public class DijkstraSimple {

    private int[] distances;
    private boolean[] visited;
    private int[][] graph;
    private int numNodes;

    public DijkstraSimple(int numNodes) {
        this.numNodes = numNodes;
        distances = new int[numNodes];
        visited = new boolean[numNodes];
        graph = new int[numNodes][numNodes];
    }

    public void dijkstra(int source) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        for (int i = 0; i < numNodes; i++) {
            int u = getMinDistanceNode();
            visited[u] = true;

            for (int v = 0; v < numNodes; v++) {
                if (!visited[v] && graph[u][v] != Integer.MAX_VALUE &&
                    distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }
    }

    private int getMinDistanceNode() {
        int min = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i] && distances[i] < min) {
                min = distances[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scan.nextInt();

        DijkstraSimple ds = new DijkstraSimple(n);

        System.out.println("Enter the weighted adjacency matrix (0 if no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int weight = scan.nextInt();
                if (i == j) {
                    ds.graph[i][j] = 0;
                } else {
                    ds.graph[i][j] = (weight == 0) ? Integer.MAX_VALUE : weight;
                }
            }
        }

        System.out.print("Enter the source vertex (0-based index): ");
        int source = scan.nextInt();

        System.out.print("Enter the destination vertex (0-based index): ");
        int destination = scan.nextInt();

        ds.dijkstra(source);

        int distance = ds.distances[destination];
        if (distance == Integer.MAX_VALUE) {
            System.out.println("There is no path from source " + source + " to destination " + destination);
        } else {
            System.out.println("The Shortest Path from source " + source + " to " + destination + " is: " + distance);
        }

        scan.close();
    }
}
