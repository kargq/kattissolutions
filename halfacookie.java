import java.util.*;
import java.lang.*;

class Solution {
    Scanner in;
    Double r, x, y, cSlope, offset, chordLength, sectorArea, sectorAngle, arcLength, chordArea, circleArea;

    Solution() {
        in = new Scanner(System.in);

        while (in.hasNext()) {
            r = in.nextDouble();
            x = in.nextDouble();
            y = in.nextDouble();

            offset = Math.sqrt(x * x + y * y);

            if (offset > r) {
                System.out.println("miss");
            } else {

                // 2 r sin(theta / 2)

                // Area of sector = 1/2 arc length *

                chordLength = 2 * Math.sqrt(r * r - offset * offset);

                sectorAngle = 2 * Math.atan((chordLength * 0.5) / offset);

                arcLength = r * sectorAngle;

                sectorArea = (0.5) * arcLength * r;

                chordArea = sectorArea - (chordLength * (0.5) * (offset));

                circleArea = Math.PI * r * r;

                System.out.println((circleArea - chordArea) + " " + chordArea);
            }
        }

    }

    public static void main(String[] args) {
        new Solution();
    }
}