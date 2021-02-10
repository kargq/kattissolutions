import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    Scanner in;

    Solution(InputStream inp) {
        in = new Scanner(inp);

        int a = in.nextInt();
        int m = in.nextInt();

        // 𝐴𝑛=𝐴𝑛−1+𝑑, where 𝑑 is the smallest positive integer not yet appearing
        // as a value in the sequence or as a difference between two values already in
        // the sequence.

        // smallest n for m as a value or difference.

        // HashSet<Integer> found = new HashSet<>(m);
        boolean[] found = new boolean[m + 1];
        ArrayList<Integer> nums = new ArrayList<>(10000);

        int d = 1;
        nums.add(a);
        // found.add(a);
        if (a <= m)
            found[a] = true;

        while (!found[m]) {
            // while(!found.contains(m)) {
            while (found[d]) {
                // while(found.contains(d)) {
                d++;
            }
            int nw = nums.get(nums.size() - 1) + d;
            // System.out.println(nums);
            // System.out.println(found);
            if (nw <= m) {
                found[nw] = true;
                // found.add(nw);
            }
            nums.add(nw);
            for (int num : nums) {
                int diff = Math.abs(num - nw);
                if (diff <= m) {
                    found[diff] = true;
                }
                // found.add(Math.abs(num - nw));
            }
        }

        System.out.println(nums.size());
    }

    public static void main(String[] args) {
        new Solution(System.in);
    }
}
