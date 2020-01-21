import java.io.InputStream;
import java.util.*;

public class bingoties {
    Scanner in;

    bingoties(InputStream input) {
        in = new Scanner(System.in);
        HashMap<Integer, LinkedHashSet<Integer>> found = new HashMap<>();

        int n = in.nextInt();
        LinkedHashSet<Integer>[][] cards = new LinkedHashSet[n][5];
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < 5; x++) {
                cards[i][x] = new LinkedHashSet<>();
                for (int y = 0; y < 5; y++) {
                    int value = in.nextInt();
                    cards[i][x].add(value);
                    if (found.containsKey(value)) {
                        found.get(value).add(i);
                    } else {
                        LinkedHashSet<Integer> list = new LinkedHashSet<>();
                        list.add(i);
                        found.put(value, list);
                    }
                }
            }
        }

        List<Integer> ties1 = new ArrayList<>();
        List<Integer> ties2 = new ArrayList<>();

        // Hash map of numbers next to a list of card numbers they are in
//        System.out.println(found);
        for (int num : found.keySet()) {
            if (found.get(num).size() > 1) {
                // For each one of these, if there's more than one card sharing the number, there's a possible tie.
//                System.out.println("Checking: " + num);
                LinkedHashSet<Integer> checked = new LinkedHashSet<>();
                for (int c1 : found.get(num)) {
                    checked.add(c1);
                    for (int c2 : found.get(num)) {
                        if (!checked.contains(c2)) {
                            if (!(ties1.contains(Math.min(c1, c2)) && ties2.contains(c2))) {


//                    System.out.println(c1);
//                    System.out.println(c2);
                                if (c1 != c2) {
//                                    System.out.println("Check pair: " + c1 + " " + c2);
                                    // Valid pair
                                    // Find row digit union of tie row
                                    // Number only occurs once so can only be one such set.

                                    LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

                                    for (LinkedHashSet<Integer> row : cards[c1]) {
                                        if (row.contains(num)) {
                                            numbers.addAll(row);
                                        }
                                    }
                                    for (LinkedHashSet<Integer> row : cards[c2]) {
                                        if (row.contains(num)) {
                                            numbers.addAll(row);
                                        }
                                    }

                                    numbers.remove(num);

                                    // Numbers is list of numbers that needs to be called out before the tie is caused.

                                    // now for all cards,

//                                    System.out.println(numbers);

                                    boolean flag = false;
                                    for (int i = 0; i < n; i++) {
                                        if (i != c1 && i != c2) {
                                            flag = flag || causesBingo(numbers, cards[i]);
                                        }
                                    }

                                    if (flag) {
                                        // Card does not cause a tie
                                    } else {
                                        ties1.add(Math.min(c1, c2));
                                        ties2.add(Math.max(c1, c2));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        System.out.println(ties1);
//        System.out.println(ties2);
        if (ties1.size() == 0) {
            System.out.println("no ties");
        } else {
            int min = Integer.MAX_VALUE;
            for (int num : ties1) {
                min = Math.min(num, min);
            }

            int min2 = Integer.MAX_VALUE;
            for (int i = 0; i < ties1.size(); i++) {
                if (ties1.get(i) == min) {
                    min2 = Math.min(min2, ties2.get(i));
                }
            }

            System.out.println(++min + " " + ++min2);
        }

//        for (int c1 = 0; c1 < n; c1++) {
//            for (int c2 = 0; c2 < n; c2++) {
//
//            }
//        }

        // If one number is repeated in any two rows, a tie is possible.
        // By extension, if any two cards have a common number, a tie is possible.

        // Is that all of the cases?

        // Now let's say two cards DO NOT have any common numbers, is a tie possible?
        // Actually, umm, no.

        // This should work?

        // But, this does not work if that sequence results in someone else winning first!

        // So one solution is find all such sequencues that can potentially tie, and see if saying them out loud results in someone else winning first.


    }

    boolean causesBingo(Collection<Integer> numbers, LinkedHashSet<Integer>[] card) {
        for (LinkedHashSet<Integer> row : card) {
            if (numbers.containsAll(row)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new bingoties(System.in);
    }

}
