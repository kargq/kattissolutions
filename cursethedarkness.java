import java.util.*;
import java.lang.*;

class Solution {

    double r = 8;
    Scanner in = new Scanner(System.in);

    Solution() {
        int cases = in.nextInt();
        for (int cas = 0; cas < cases; cas++) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            int candles = in.nextInt();

            boolean lit = false;

            for (int i = 0; i < candles; i++) {
                double cx = in.nextDouble();
                double cy = in.nextDouble();

                double dist = Math.sqrt((cy - y) * (cy - y) + (cx - x) * (cx - x));

                if (dist <= r) {
                    lit = true;
                }
            }

            if (!lit) {
                System.out.println("curse the darkness");
            } else {
                System.out.println("light a candle");
            }
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}