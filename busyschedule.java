import java.util.*;
import java.lang.*;

class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int nDates;
        while ((nDates = in.nextInt()) != 0) {
            in.nextLine();
            List<String> dates = new ArrayList<>(nDates);
            for (int i = 0; i < nDates; i++) {
                String read = in.nextLine().trim();
                dates.add(read);
            }
            dates.sort(Comparator.comparingInt((a) -> {
                String[] stray = a.split(" ");
                String[] dray = stray[0].split(":");
                int hour = Integer.parseInt(dray[0]);
                int minute = Integer.parseInt(dray[1]);
                if (stray[1].trim().equals("p.m.") && hour != 12) {
                    hour += 12;
                } else if (stray[1].trim().equals("a.m.") && hour == 12) {
                    hour = 0;
                }
                return hour * 100 + minute;
            }));
            for (String date : dates) {
                System.out.println(date);
            }
            System.out.println();
        }
    }
}