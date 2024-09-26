import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();
        String[] asWords = new String[10];
        int iTargetIndex; // what we want
        String sTargetString;
        int iResultIndex; // what is actual
        BinarySearchTest oTest = new BinarySearchTest();
        long startTime;
        long elapsedTime;

        // hard code a string into each element
        asWords[0] = "Frank";
        asWords[1] = "Mary";
        asWords[2] = "Jane";
        asWords[3] = "Bob";
        asWords[4] = "Jack";
        asWords[5] = "Smith";
        asWords[6] = "John";
        asWords[7] = "Jane";
        asWords[8] = "Smith";
        asWords[9] = "Jack";
        // Built in class to sort our data so that binary search can be applied
        Arrays.sort(asWords);
        // Get a target number and its index to test the binary search methods accuracy
        iTargetIndex = oRand.nextInt(asWords.length);
        sTargetString = asWords[iTargetIndex];

        System.out.println("Target Index: " + iTargetIndex);

        // Binary Search
        System.out.println("BEGIN Binary Search");
//        System.currentTimeMillis();
        startTime = System.nanoTime();
        iResultIndex = oTest.findNumberBinarySearch(asWords, sTargetString, asWords.length - 1,0);
        System.out.println("Index returned: " + iResultIndex);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed Time: " + elapsedTime);
        System.out.println();

        // Linear Search
//        System.out.println("BEGIN Linear Search");
////        System.currentTimeMillis();
//        startTime = System.nanoTime();
//        iResultIndex = oTest.findNumberLinearSearch(asWords, sTargetString);
//        System.out.println("Index returned: " + iResultIndex);
//        elapsedTime = System.nanoTime() - startTime;
//        System.out.println("Elapsed Time: " + elapsedTime);

    }

    /**
     *  Find index of given target num using Binary Search and Recursion
     * @param asStrings
     * @param sTargetString
     * @param iHigh
     * @param iLow
     * @return
     */
    private int findNumberBinarySearch(String[] asStrings, String sTargetString, int iHigh, int iLow) {
        // figure out the middle index or average
        int iMiddle = (iHigh + iLow) / 2;
        // check if num at middle index matches target
        if (asStrings[iMiddle].equals(sTargetString)) {
            return iMiddle;
        }

        // Check if the target number is greater than the value at the middle index
        else if (sTargetString.compareTo(asStrings[iMiddle]) > 0) {
            return findNumberBinarySearch(asStrings, sTargetString, iHigh, iMiddle + 1);
        }

        // Target num is at lower index than middle index
        else {
            return findNumberBinarySearch(asStrings, sTargetString, iMiddle - 1, iLow);
        }

    }

//    /**
//     * Find index of given target num using Linear Search
//     * @param aiNumbers
//     * @param iTargetNum
//     * @return
//     */
//    private int findNumberLinearSearch(int[] aiNumbers, int iTargetNum) {
//
//        for (int x = 0; x < aiNumbers.length; x++) {
//            if (aiNumbers[x] == iTargetNum) {
//                return x;
//            }
//        }
//        return -1;
//    }

}
