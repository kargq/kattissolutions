import java.util.*;
import java.lang.*;

class Solution {
    Scanner in = new Scanner(System.in);
    HashMap<String, Integer> vars = new HashMap<>();

    Solution() {
        while (in.hasNext()) {
            String[] line = in.nextLine().split(" ");
            String command = line[0];
            if (command.equals("def")) {
                def(line[1], Integer.parseInt(line[2]));
            } else if (command.equals("calc")) {
                int result = 0;
                boolean someNull = false;
                int sign = 1;
                int start = 1;
//                if (line[1].equals("-")) {
//                    start = 2;
//                    sign = -1;
//                    System.out.print("- ");
//                }
                for (int i = start; i < line.length; i += 2) {
                    String varName = line[i];
                    System.out.print(varName);
                    Integer val = get(varName);
                    if (val == null) {
                        someNull = true;
                    } else {
                        result += sign * val;
                    }
                    String nSign = line[i + 1];
                    if (nSign.equals("=")) {
                        System.out.print(" = " + findName(someNull ? null : result));
                        break;
                    } else if (nSign.equals("+")) {
                        System.out.print(" + ");
                        sign = 1;
                    } else if (nSign.equals("-")) {
                        System.out.print(" - ");
                        sign = -1;
                    }
                }
                System.out.println();

            } else if (command.equals("clear")) {
                vars.clear();
            }
        }
    }

    String findName(Integer value) {
        if (value == null) {
            return "unknown";
        }
        for (String key : vars.keySet()) {
            if (vars.get(key).equals(value)) {
                return key;
            }
        }
        return "unknown";
    }

    void def(String name, Integer value) {
        vars.put(name, value);
    }

    Integer get(String name) {
        return vars.getOrDefault(name, null);
    }

    public static void main(String[] args) {
        new Solution();
    }
}