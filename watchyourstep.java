import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class watchyourstep {

    Scanner in;
    List<BitSet> matrix;
    int dim;

    watchyourstep(InputStream is) {
        in = new Scanner(is);
        dim = in.nextInt();
        matrix = new ArrayList<>();

        int origPathCount = 0;

        for (int row = 0; row < dim; row++) {
            BitSet rowset = new BitSet(dim);
            matrix.add(rowset);
            for (int col = 0; col < dim; col++) {
                boolean val = in.nextInt() == 1;
                rowset.set(col, val);
                if (val) origPathCount++;
            }
        }

//        printmatrix();

        for (int j = 0; j < dim; j++) {
            for (int i = 0; i < dim; i++) {
                if (matrix.get(i).get(j)) {
                    matrix.get(i).or(matrix.get(j));
                }
            }
        }

        for(int i = 0; i< dim; i++) {
            matrix.get(i).set(i, false);
        }

//        printmatrix();


        int totalCount = 0;
        for (BitSet rowset : matrix) {
            for (int i = 0; i < dim; i++) {
                if (rowset.get(i)) {
                    totalCount++;
                }
            }
        }

        System.out.println(Math.max(totalCount - origPathCount, 0));


    }

    void printmatrix() {
        for (BitSet rowset : matrix) {
            for (int i = 0; i < dim; i++) {
                System.out.print(rowset.get(i) ? 1 : 0);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            new watchyourstep(System.in);
        } catch (Exception e) {
            System.out.println("0");
        }
    }
}
