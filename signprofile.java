import java.util.*;
import java.lang.*;

class Solution {
    Scanner in = new Scanner(System.in);
    Double c0, c1, c2, c3;

    Solution() {
        readStuff();

        while (!(c0 == 0 && c1 == 0 && c2 == 0 && c3 == 0)) {
            double inner = 4 * c2 * c2 - 12 * c3 * c1;

            double rootThingy = Math.sqrt(4 * c2 * c2 - 12 * c3 * c1);

            double _x1, _x2;
            if (c3 == 0 && c2 == 0 && c1 == 0) {
                double f = f(0);
                if (f >= 0) System.out.println("+");
                else System.out.println("-");
                readStuff();
                continue;
            } else if (c3 == 0 && c2 == 0) {ugyj
                double df = df(0);
                if (df > 0) {
                    System.out.println("-+");
                } else {
                    System.out.println("+-");
                }
                readStuff();
                continue;
            } else if (c3 == 0) {
                _x1 = -c1 / (2 * c2);
                _x2 = _x1;
            } else if (inner < 0) {
                // No solutions...
                // Always just up or down
                // Hopefully...
                double df = df(0);
                if (df > 0) {
                    System.out.println("-+");
                } else {
                    System.out.println("+-");
                }
                readStuff();
                continue;
            } else {
                _x1 = (-2 * c2 - rootThingy) / (6 * c3);
                _x2 = (-2 * c2 + rootThingy) / (6 * c3);
            }

            double x1 = Math.min(_x1, _x2);
            double x2 = Math.max(_x1, _x2);

            double ddfx1 = ddf(x1);
            double fx1 = f(x1);
            double ddfx2 = ddf(x2);
            double fx2 = f(x2);

            //  p1 p2 x1 p3 x2 p4 p5
            String p1 = "";
            String p2 = "";
            String p3 = "";
            String p4 = "";
            String p5 = "";

            // Find pattern before x1
            if (ddfx1 > 0) {
                // U shaped
                if (fx1 < 0) {
                    p1 = "+";
                    p2 = "-";
                } else {
                    p1 = "+";
                    p2 = "";
                }
            } else if (ddfx1 < 0) {
                // A shaped
                if (fx1 > 0) {
                    p1 = "-";
                    p2 = "+";
                } else {
                    p1 = "-";
                    p2 = "";
                }
            } else {
                // It just go where it go
                double dxLeft = df(x1 - 1);
                if(dxLeft > 0) {
                    // _/-lkkkkk
                    if(f(x1) <= 0) {
                        p1 = "-";
                        p2 = "";
                    } else {
                        p1 = "-";
                        p2 = "+";
                    }

                } else {
                    // -|_
                    if(f(x1) >= 0) {
                        p1 = "+";
                        p2 = "";
                    } else {
                        p1 = "+";
                        p2 = "-";
                    }
                }
            }

            if (fx1 < 0 && fx2 > 0) {
                p3 = "-+";
            } else if (fx1 > 0 && fx2 < 0) {
                p3 = "+-";
            } else {
                p3 = "";
            }

            if (ddfx2 > 0) {
                // U shaped
                if (fx2 < 0) {
                    p4 = "-";
                    p5 = "+";
                } else {
                    p4 = "+";
                    p5 = "";
                }
            } else if (ddfx2 < 0) {
                // A shaped
                if (fx2 > 0) {
                    p4 = "+";
                    p5 = "-";
                } else {
                    p4 = "-";
                    p5 = "";
                }
            } else {
                // It just go where it go
                double dxRight = df(x1 + 1);
                if(dxRight > 0) {
                    // _/-lkkkkk
                    if(f(x2) >= 0) {
                        p4 = "";
                        p5 = "+";
                    } else {
                        p4 = "-";
                        p5 = "+";
                    }

                } else {
                    // -|_
                    if(f(x2) <= 0) {
                        p4 = "";
                        p5 = "-";
                    } else {
                        p4 = "+";
                        p5 = "-";
                    }
                }            }

            System.out.println(minimizeString(p1 + p2 + p3 + p4 + p5));
            readStuff();
        }
    }

    double oneOfTheRootsPlz() {
        double prev = -1;
        double xn = 0;
        double count = 200;
        while (xn != prev && count > 0) {
            prev = xn;
            double den = df(prev);
            if (den == 0) {
                System.out.println("Ahh shit");
                break;
            }
            xn = prev - f(prev) / den;
            count--;
        }
        return xn;
    }

    void readStuff() {
        c0 = in.nextDouble();
        c1 = in.nextDouble();
        c2 = in.nextDouble();
        c3 = in.nextDouble();
    }

    double f(double x) {
        return c0 + x * c1 + x * x * c2 + x * x * x * c3;
    }

    static String minimizeString(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        String result = "" + chars[0];
        char prev = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            if (curr != prev) {
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    double df(double x) {
        return c1 + 2 * c2 * x + 3 * c3 * x * x;
    }

    double ddf(double x) {
        return 2 * c2 + 6 * c3 * x;
    }

    public static void main(String[] args) {
        new Solution();
    }
}

/*

 */