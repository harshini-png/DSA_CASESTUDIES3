package casestudy4;

import java.util.*;

class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class BellmanFordUserInput {

    static void bellmanFord(List<Edge> edges, int V, int source) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (dist[edge.source] != Integer.MAX_VALUE &&
                        dist[edge.source] + edge.weight < dist[edge.destination]) {

                    dist[edge.destination] = dist[edge.source] + edge.weight;
                }
            }
        }

        // Negative cycle detection
        for (Edge edge : edges) {
            if (dist[edge.source] != Integer.MAX_VALUE &&
                    dist[edge.source] + edge.weight < dist[edge.destination]) {

                System.out.println("Negative Weight Cycle Detected!");
                return;
            }
        }

        System.out.println("\nShortest distances from Source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        System.out.println("Enter Source Destination Weight:");

        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();

            edges.add(new Edge(src, dest, wt));
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        bellmanFord(edges, V, source);

        sc.close();
    }
}
