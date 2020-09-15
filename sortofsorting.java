import java.util.*;
import java.lang.*;

class Solution {

    Scanner in = new Scanner(System.in);

    Solution() {
        int lines;
        while ((lines = in.nextInt()) != 0) {
            List<String> set = new ArrayList<>();
            for (int i = 0; i < lines; i++) {
                String word = in.next();
                set.add(word);
            }

            set.sort((a, b) -> {
                char[] aa = a.toCharArray();
                char[] ba = b.toCharArray();

                int diff1 = Integer.signum(((int) aa[0]) - ((int) ba[0]));
                int diff2 = Integer.signum(((int) aa[1]) - ((int) ba[1]));

                if(diff1 == 0) {
                    return diff2;
                } else {
                    return diff1;
                }

            });

            for (String value : set) {
                System.out.println(value);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}