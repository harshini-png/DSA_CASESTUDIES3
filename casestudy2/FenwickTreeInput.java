package casestudy2;

import java.util.*;

public class FenwickTreeInput {

    static int n;
    static int[] bit;

    // ---------- Update ----------
    static void update(int i, int delta) {
        while (i <= n) {
            bit[i] += delta;
            i += (i & -i);
        }
    }

    // ---------- Prefix Sum ----------
    static int prefixSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i & -i);
        }
        return sum;
    }

    // ---------- Range Sum ----------
    static int rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
    }

    // ---------- Main ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        n = sc.nextInt();

        bit = new int[n + 1];

        int[] arr = new int[n + 1];

        System.out.println("Enter daily spend values:");
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            update(i, arr[i]);
        }

        System.out.println("\nInitial setup complete!");

        System.out.print("\nEnter range query (l r): ");
        int l = sc.nextInt();
        int r = sc.nextInt();

        System.out.println("Total spend = " + rangeSum(l, r));

        System.out.print("\nEnter index and update value (i delta): ");
        int idx = sc.nextInt();
        int delta = sc.nextInt();

        update(idx, delta);

        System.out.println("After update, new range sum = " + rangeSum(l, r));

        sc.close();
    }
}