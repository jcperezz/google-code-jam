import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Solution {

    private static void resolve(InputStream in) throws Exception {
        Scanner sc = new Scanner(in);
        int testCase = 0;

        Vector<int[]> vector = null;

        sc.hasNext();
        sc.nextLine();

        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] ars = str.split(" ");
            
            if (ars.length > 1) {
                int[] row = toIntArray(ars);
                vector.add(row);
            } else {
                
                /*
                 * Case #x: k r c, where x is the test case number (starting from 1), k is the
                 * trace of the matrix, r is the number of rows of the matrix that contain
                 * repeated elements, and c is the number of columns of the matrix that contain
                 * repeated elements.
                 */
                if(testCase > 0){
                    print(vector, testCase);
                }

                testCase++;
                vector = new Vector<>();
            }
        }

        print(vector, testCase);

        sc.close();
    }

    private static void print(Vector<int[]> vector, int testCase){
        int kTrace = 0;
        int rRows = 0;
        int cColumns = 0;
        
        int k = 0;
        int i = 0;
        for (int[] is : vector) {
            kTrace += is[k++];
            rRows = containsRepeated(is) ? rRows + 1 : rRows;
            int[] colu = extractColumn(vector, i++);
            cColumns = containsRepeated(colu) ? cColumns + 1 : cColumns;
        }

        System.out.println(String.format("Case #%s: %s %s %s", testCase, kTrace, rRows, cColumns));
    }

    private static boolean containsRepeated(int[] pArray){
        for(int i=0;i<pArray.length-1;i++){

            for(int j=i+1;j<pArray.length;j++){
                if(pArray[i]==pArray[j]){
                    return true;
                }
            }
        }

        return false;
    }

    private static int[] extractColumn(Vector<int[]> vector, int col){
        int[] colu = new int[vector.size()];
        int i = 0;
        for (int[] is : vector) {
            colu[i++] = is[col];
        }

        return colu;
    }

    private static int[] toIntArray(String... args) {
        int[] intarr = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            intarr[i] = Integer.valueOf(args[i]);
        }

        return intarr;
    }

    public static void main(String[] args) throws Exception {
        // InputStream in = new ByteArrayInputStream(originalString.getBytes());
        resolve(System.in);
    }

    /**
     *         String originalString = "3\n" 
                                + "4\n" 
                                + "1 2 3 4\n" 
                                + "2 1 4 3\n" 
                                + "3 4 1 2\n" 
                                + "4 3 2 1\n" 
                                + "4\n"
                                + "2 2 2 2\n" 
                                + "2 3 2 3\n" 
                                + "2 2 2 3\n" 
                                + "2 2 2 2\n" 
                                + "3\n" 
                                + "2 1 3\n" 
                                + "1 3 2\n" 
                                + "1 2 3";
     */

}
