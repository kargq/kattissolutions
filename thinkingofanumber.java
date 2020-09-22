import java.util.*;
import java.lang.*;

class Solution {

    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static int alsoLcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int lcm(Integer... nums) {
        if (nums.length == 0) {
            return 1;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return alsoLcm(nums[0], nums[1]);
        }

        Set<Integer> lcms = new HashSet<>();
        int i;
        for (i = 0; i + 1 < nums.length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            lcms.add(alsoLcm(a, b));
        }

        if (nums.length % 2 != 0) {
            // Missed 1
            lcms.add(nums[nums.length - 1]);
        }

        Integer[] lcmArray = lcms.toArray(new Integer[0]);
//        System.out.println(lcms);
        return lcm(lcmArray);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nCmds;
        while ((nCmds = in.nextInt()) != 0) {
            int lowerBound = 0;
            Integer upperBound = null;
            ArrayList<Integer> divisors = new ArrayList<>();
//            System.out.println("Process ");
            for (int i = 0; i < nCmds; i++) {
                String command = in.next();
                String _$ = in.next();
                int num = in.nextInt();

                switch (command) {
                    case "less": {
                        upperBound = num;
                        break;
                    }
                    case "greater": {
                        lowerBound = num;
                        break;
                    }
                    case "divisible": {
                        divisors.add(num);
                        break;
                    }

                }
            }
            if (upperBound == null) {
                // Welp, infinite values
                System.out.println("infinite");
            } else if (upperBound <= lowerBound || Math.abs(upperBound - lowerBound) <= 1) {
                System.out.println("none");
            } else {
                // Check if divisors work

                Integer lcm = divisors.size() > 0 ? lcm(divisors.toArray(new Integer[0])) : null;

//                System.out.println("LCM: " + lcm + " in (" + lowerBound + "," + upperBound + ")");

                if (lcm == null) {
                    for (int n = lowerBound + 1; n < upperBound; n++) {
                        System.out.print(n + " ");
                    }
                    System.out.println();
                } else if (lcm >= upperBound) {
                    // Does not work
                    System.out.println("none");
                } else {
                    boolean printed = false;
                    // lcm * x = lowerBound + 1
//                    int x = (int) Math.ceil((double) (lowerBound + 1) / (double) lcm);
                    int x = lowerBound / lcm;
//                    System.out.println(x);
//                    int start = x * lcm;
                    for (int i = x; lcm * i < upperBound; i++) {
                        int n = lcm * i;
                        if (n > lowerBound) {
                            printed = true;
                            System.out.print(n + " ");
                        }
                    }
                    if (printed) {
                        System.out.println();
                    } else {
                        System.out.println("none");
                    }
                }
            }
        }
    }
}
