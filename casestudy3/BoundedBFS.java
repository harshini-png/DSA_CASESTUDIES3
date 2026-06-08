package casestudy3;

import java.util.*;

public class BoundedBFS {

    static Set<String> bfsBounded(Map<String, List<String>> adj, String source, int maxDepth) {

        Set<String> visited = new HashSet<>();
        Set<String> reached = new HashSet<>();

        Queue<Object[]> q = new LinkedList<>();

        visited.add(source);
        q.add(new Object[] { source, 0 });

        while (!q.isEmpty()) {

            Object[] curr = q.poll();
            String node = (String) curr[0];
            int depth = (int) curr[1];

            if (depth == maxDepth)
                continue;

            for (String nei : adj.getOrDefault(node, new ArrayList<>())) {

                if (!visited.contains(nei)) {
                    visited.add(nei);
                    q.add(new Object[] { nei, depth + 1 });
                    reached.add(nei);
                }
            }
        }

        return reached;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== X (Twitter) Reach Prediction System ===");

        System.out.print("Enter number of follow relationships: ");
        int e = sc.nextInt();

        Map<String, List<String>> adj = new HashMap<>();

        System.out.println("Enter relationships (X Y means X is followed by Y):");
        for (int i = 0; i < e; i++) {
            String u = sc.next();
            String v = sc.next();

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        System.out.print("\nEnter source user (tweet author): ");
        String source = sc.next();

        System.out.print("Enter max depth (e.g., 3): ");
        int d = sc.nextInt();

        Set<String> result = bfsBounded(adj, source, d);

        System.out.println("\n==============================");
        System.out.println("Tweet Reach Report");
        System.out.println("==============================");
        System.out.println("Source User: " + source);
        System.out.println("Max Depth: " + d);
        System.out.println("Total Reach: " + result.size());
        System.out.println("Reached Users: " + result);
        System.out.println("==============================");

        sc.close();
    }
}