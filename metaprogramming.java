import java.lang.*;
import java.util.*;

class Solution {

    HashMap<String, Integer> mem = new HashMap<>();
    Scanner in = new Scanner(System.in);

    Solution() {

        while (in.hasNext()) {
            String[] inp = in.nextLine().split(" ");
            switch (inp[0]) {
                case "define": {
                    mem.put(inp[2], Integer.parseInt(inp[1]));
                    break;
                }
                case "eval": {
                    Integer v1 = mem.getOrDefault(inp[1], null);
                    Integer v2 = mem.getOrDefault(inp[3], null);

                    if (v1 == null || v2 == null) {
                        System.out.println("undefined");
                    } else {

                        switch (inp[2]) {
                            case "<": {
                                System.out.println(v1 < v2);
                                break;
                            }
                            case ">": {
                                System.out.println(v1 > v2);
                                break;
                            }
                            case "=": {
                                System.out.println(v1.equals(v2));
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}