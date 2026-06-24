package casestudy6;

import java.util.*;

public class LogisticsKnapsack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of consignments: ");
        int n = sc.nextInt();

        String[] items = new String[n];
        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nConsignment " + (i + 1));

            System.out.print("Enter Item Name: ");
            items[i] = sc.next();

            System.out.print("Enter Weight (tons): ");
            weights[i] = sc.nextInt();

            System.out.print("Enter Value (₹k): ");
            values[i] = sc.nextInt();
        }

        System.out.print("\nEnter Truck Capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                int skip = dp[i - 1][w];
                int take = skip;

                if (weights[i - 1] <= w) {
                    take = dp[i - 1][w - weights[i - 1]]
                            + values[i - 1];
                }

                dp[i][w] = Math.max(skip, take);
            }
        }

        // Backtracking
        List<String> selectedItems = new ArrayList<>();
        int totalWeight = 0;

        int w = W;

        for (int i = n; i >= 1; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                selectedItems.add(items[i - 1]);
                totalWeight += weights[i - 1];
                w -= weights[i - 1];
            }
        }

        Collections.reverse(selectedItems);

        System.out.println("\n===== Optimal Cargo Loading =====");
        System.out.println("Maximum Revenue: ₹" + (dp[n][W] * 1000));

        System.out.println("\nSelected Consignments:");
        for (String item : selectedItems) {
            System.out.println(item);
        }

        System.out.println("\nTotal Weight Loaded: " + totalWeight + " tons");

        sc.close();
    }
}