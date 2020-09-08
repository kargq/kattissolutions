import java.util.*;
import java.lang.*;

class Solution {
    Scanner in;
    TreeMap<String, TreeSet<String>> map = new TreeMap<>();

    Solution() {
        in = new Scanner(System.in);
        int num = in.nextInt();
        while (num != 0) {
            map.clear();
            in.nextLine();
            for (int count = 0; count < num; count++) {
                String line = in.nextLine();
                String[] vals = line.split(" ");

                String name = vals[0];

                for (int i = 1; i < vals.length; i++) {
                    String key = vals[i];
                    if (map.containsKey(key)) {
                        map.get(key).add(name);
                    } else {
                        TreeSet<String> nameSet = new TreeSet<>();
                        nameSet.add(name);
                        map.put(key, nameSet);
                    }
                }
            }
            for (String key : map.keySet()) {
                System.out.print(key);
                for (String aName : map.get(key)) {
                    System.out.print(" " + aName);
                }
                System.out.println();
            }
            num = in.nextInt();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution();
    }
}