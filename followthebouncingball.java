import java.util.ArrayList;
import java.util.Scanner;

class followthebouncingball {

    Scanner in = new Scanner(System.in);
    int w, h, n, m, r, s;
    double l;

    public followthebouncingball() {
        w = in.nextInt(); // Viewport width
        h = in.nextInt(); // Viewport height
        n = in.nextInt(); // Number of balls
        m = in.nextInt(); // Number of objects
        l = in.nextDouble(); // Distance of gun from origin
        r = in.nextInt(); // Base
        s = in.nextInt(); // Height

        ArrayList<Shape> shapes = new ArrayList<>(m);

        for (int line = 0; line < m; line++) {
            int p = in.nextInt();
            int[][] points = new int[p][2];
            for (int point = 0; point < p; point++) {
                points[point][0] = in.nextInt();
                points[point][1] = in.nextInt();
            }
            int q = in.nextInt();
            shapes.add(new Shape(points, q));
        }

        ArrayList<Ball> balls = new ArrayList<>(n);

        long currTime = 0;
        for (int i = 0; i < n; i++) {
            balls.add(new Ball(currTime += 1000, l, 0.0));
        }

        // Need to figure out which ball will get into a collision first, update the
        // ball, do it agin.

        while (balls.size() > 0) {
            // Figure out which ball will get into a collision first.
        }

        // Determine path
        // Determine which object goes out first

        // Timer: After each collission, update position and values for everyone?

        // After collision, determine the next

        // List of balls

        // Time starts at 0

        // Go through list in order of time after each collision?

    }

    class Ray {
        // y = m x + b
        Ray(Point start, Point direction) {

        }
    }

    class LineSegment extends Line {
        LineSegment(Point start, Point end) {
            super()
        }
    }

    class Line {

        double slope;
        double c;

        Line(double slope, double c) {
            this.slope = slope;
            this.c = c;
        }

        Point intersection(Line l2) {
            Double x = (c - l2.c) / (l2.slope - slope);
            Double y = slope * x + c;
            return new Point(x, y);
        }
    }

    class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

    }

    class Shape {
        int[][] points;
        int q;

        Shape(int[][] points, int q) {
            this.points = points;
            this.q = q;
        }
    }

    class Ball {
        long time;
        Double x;
        Double y;

        Ball(long time, Double x, Double y) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println("Elo wyrld");
        new followthebouncingball();
    }

}