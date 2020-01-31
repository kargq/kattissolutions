import java.util.Scanner;

public class runlengthencodingrun {
    Scanner in = new Scanner(System.in);
    char[] dataArray;

    runlengthencodingrun() {
        char type = in.next().toCharArray()[0];
        String data = in.next();
        dataArray = data.toCharArray();

        if (type == 'E') {
            encode();
        } else {
            decode();
        }
    }

    void decode() {
        Character currChar = null;
        StringBuilder result = new StringBuilder();
        for (char c : dataArray) {
            if (currChar == null) {
                currChar = c;
            } else if ('0' <= c && c <= '9') {
                for (int i = 0; i < c - '0'; i++) {
                    result.append(currChar);
                }
                currChar = null;
            } else if (currChar != c) {
                result.append(c);
                currChar = c;
            } else {
                currChar = c;
            }
        }
        System.out.println(result);
    }

    void encode() {
        Character currChar = null;
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (char c : dataArray) {
            if (currChar == null) {
                currChar = c;
                count = 1;
            } else if (c == currChar) {
                count++;
            } else {
                result.append(currChar);
                result.append(count);
                count = 1;
                currChar = c;
            }
        }
        result.append(currChar);
        result.append(count);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new runlengthencodingrun();
    }
}
