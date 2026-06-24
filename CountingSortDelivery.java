package casestudy5;

import java.util.*;

class Delivery {
    int over, ball;

    Delivery(int over, int ball) {
        this.over = over;
        this.ball = ball;
    }
}

public class CountingSortDelivery {

    static Delivery[] countingSortByOver(Delivery[] in) {

        final int K = 50;
        int[] count = new int[K + 1];

        // Count occurrences
        for (Delivery d : in) {
            count[d.over]++;
        }

        // Prefix sums
        for (int i = 1; i <= K; i++) {
            count[i] += count[i - 1];
        }

        Delivery[] out = new Delivery[in.length];

        // Reverse traversal for stability
        for (int i = in.length - 1; i >= 0; i--) {
            Delivery d = in[i];
            out[--count[d.over]] = d;
        }

        return out;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of deliveries: ");
        int n = sc.nextInt();

        Delivery[] deliveries = new Delivery[n];

        System.out.println("Enter Over and Ball Number:");

        for (int i = 0; i < n; i++) {
            int over = sc.nextInt();
            int ball = sc.nextInt();

            deliveries[i] = new Delivery(over, ball);
        }

        Delivery[] sorted = countingSortByOver(deliveries);

        System.out.println("\nSorted Deliveries:");

        for (Delivery d : sorted) {
            System.out.println("(" + d.over + "," + d.ball + ")");
        }

        sc.close();
    }
}