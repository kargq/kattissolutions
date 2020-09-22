import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        while ((num = in.nextInt()) != 0) {
            boolean[] ques = {
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                    false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                    false, false
            };

            BitSet res = new BitSet(32);
            for (int i = 0; i < num; i++) {
                String command = in.next();
                int pos = in.nextInt();

//
//                System.out.print("Uhh ");
//                for(int j = 31; j >= 0; j--) {
//                    System.out.print(ques[j] ? "1" : "0");
//                }
//                System.out.println();

                switch (command) {
                    case "SET": {
                        ques[pos] = true;
                        res.set(pos, true);
                        break;
                    }
                    case "CLEAR": {
                        ques[pos] = true;
                        res.set(pos, false);
                        break;
                    }
                    case "AND": {
                        int pos2 = in.nextInt();
                        if (ques[pos] && ques[pos2]) {
//                            System.out.println("Set and " + pos2);
                            res.set(pos, res.get(pos) && res.get(pos2));
                        } else if (ques[pos2] && !res.get(pos2)) {
                            ques[pos] = true;
                            res.set(pos, false);
                        } else if (ques[pos] && !res.get(pos)) {
                        } else {
                            ques[pos] = false;
                        }
                        break;
                    }
                    case "OR": {
                        int pos2 = in.nextInt();
                        if (ques[pos] && ques[pos2]) {
//                            System.out.println("Set or " + pos2);
                            res.set(pos, res.get(pos) || res.get(pos2));
                        } else if (ques[pos2] && res.get(pos2)) {
                            ques[pos] = true;
                            res.set(pos, true);
                        } else if (ques[pos] && res.get(pos)) {

                        } else {
                            ques[pos] = false;
                        }
                        break;
                    }
                }
            }

            StringBuilder bld = new StringBuilder();

            for (int i = 31; i >= 0; i--) {
                bld.append(ques[i] ? (res.get(i) ? "1" : "0") : "?");
            }

            System.out.println(bld.toString());
        }
    }
}