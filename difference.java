import java.io.InputStream;
import java.util.Scanner;

public class difference {
    Scanner in;

    difference(InputStream inp) {
        in = new Scanner(inp);

        int a1 = in.nextInt();
        int a2 = in.nextInt();

        // 𝐴𝑛=𝐴𝑛−1+𝑑, where 𝑑 is the smallest positive integer not yet appearing as a value in the sequence or as a difference between two values already in the sequence.

        // smallest n for m as a value or difference.


    }


    public static void main(String[] args) {
        try {
         new difference(System.in);
        }
        catch (Exception e) {
            System.out.println("fuck");
        }
    }
}
