import java.util.*;
import java.lang.*;

class Solution {
    int num;
    Scanner in = new Scanner(System.in);

    List<Integer> factorize(int n) {
        List<Integer> result = new ArrayList<>();

        while (n % 2 == 0) {
            result.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                result.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            result.add(n);
        }

//        System.out.println(result);

        return result;
    }

    void questionStuff(int x, int num) {
//        System.out.println("Do " + x);
        //if x is prime, print x and stop

        //factor x into its prime factors p1,p2,…,pk
        List<Integer> factors = factorize(x);

        if (factors.size() == 1) {
            // It's prime
            System.out.println(x + " " + num);
            return;
        }

        int newX = 0;
        for (int factor : factors) {
            newX += factor;
        }

        questionStuff(newX, num + 1);


        //let x=p1+p2+⋯+pk

        // go back to step 1
    }

    Solution() {
        while ((num = in.nextInt()) != 4) {
//            System.out.println(num + ": " + factorize(num));
            questionStuff(num, 1);
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}