import java.math.BigInteger;
import java.util.*;
import java.lang.*;

class Solution {

    static boolean equal(BigInteger a, Integer b) {
        return BigInteger.valueOf(b).compareTo(a) == 0;
    }

    static BigInteger gcd(BigInteger a, BigInteger b) {
        if (equal(a, 0)) return b;
        return gcd(b.mod(a), a);
    }

    static BigInteger alsoLcm(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide(gcd(a, b));
    }

    static BigInteger lcm(BigInteger... nums) {
        if (nums.length == 0) {
            return BigInteger.valueOf(1);
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return alsoLcm(nums[0], nums[1]);
        }

        Set<BigInteger> lcms = new HashSet<>();
        int i;
        for (i = 0; i + 1 < nums.length; i += 2) {
            BigInteger a = nums[i];
            BigInteger b = nums[i + 1];
            lcms.add(alsoLcm(a, b));
        }

        if (nums.length % 2 != 0) {
            // Missed 1
            lcms.add(nums[nums.length - 1]);
        }

        BigInteger[] lcmArray = lcms.toArray(new BigInteger[0]);
//        System.out.prlongln(lcms);
        return lcm(lcmArray);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String[] numStrs = in.nextLine().split(" ");
            BigInteger[] nums = new BigInteger[numStrs.length];

            for (int i = 0; i < numStrs.length; i++) {
                nums[i] = new BigInteger(numStrs[i]);
            }

            BigInteger lcm = lcm(nums);
            System.out.println(lcm);
        }

    }
}
