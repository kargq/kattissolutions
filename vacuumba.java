import java.util.*;
import java.lang.*;

class Solution {

    Scanner in = new Scanner(System.in);

    Solution() {

        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int lines = in.nextInt();
            double x = 0;
            double y = 0;
            double currAngle = 90;
            for (int j = 0; j < lines; j++) {
                currAngle += in.nextDouble();
//                Double angle = in.nextDouble();
                Double distance = in.nextDouble();

                double xDiff = distance * Math.cos(Math.toRadians(currAngle));
                double yDiff = distance * Math.sin(Math.toRadians(currAngle));

                x += xDiff;
                y += yDiff;
            }

            System.out.println(((float) x) + " " + ((float) y));
        }

    }


    public static void main(String[] args) {
        new Solution();
    }
}