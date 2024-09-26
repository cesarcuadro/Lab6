import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {

        SecureRandom oRand = new SecureRandom();
        int[] aiNumbers = new int[10000000];
        int iTargetIndex; // what we want
        int iTargetNum;
        int iResultIndex; // what is actual
        BinarySearchTest oTest = new BinarySearchTest();
        long startTime;
        long elapsedTime;

        // for loop to put random numbers in array
        for (int x = 0; x < aiNumbers.length; x++) {
            aiNumbers[x] = oRand.nextInt(100);
        }
        // Built in class to sort our data so that binary search can be applied
        Arrays.sort(aiNumbers);
        // Get a target number and its index to test the binary search methods accuracy
        iTargetIndex = oRand.nextInt(aiNumbers.length);
        iTargetNum = aiNumbers[iTargetIndex];

        System.out.println("Target Index: " + iTargetIndex);

        // Binary Search
        System.out.println("BEGIN Binary Search");
//        System.currentTimeMillis();
        startTime = System.nanoTime();
        iResultIndex = oTest.findNumberBinarySearch(aiNumbers, iTargetNum, aiNumbers.length - 1,0);
        System.out.println("Index returned: " + iResultIndex);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed Time: " + elapsedTime);
        System.out.println();

        // Linear Search
        System.out.println("BEGIN Linear Search");
//        System.currentTimeMillis();
        startTime = System.nanoTime();
        iResultIndex = oTest.findNumberLinearSearch(aiNumbers, iTargetNum);
        System.out.println("Index returned: " + iResultIndex);
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed Time: " + elapsedTime);

    }

    /**
     *  Find index of given target num using Binary Search and Recursion
     * @param aiNumbers
     * @param iTargetNum
     * @param iHigh
     * @param iLow
     * @return
     */
    private int findNumberBinarySearch(int[] aiNumbers, int iTargetNum, int iHigh, int iLow) {
        // figure out the middle index or average
        int iMiddle = (iHigh + iLow) / 2;
        // check if num at middle index matches target
        if (aiNumbers[iMiddle] == iTargetNum) {
            return iMiddle;
        }

        // Check if the target number is greater than the value at the middle index
        else if (iTargetNum > aiNumbers[iMiddle]) {
            return findNumberBinarySearch(aiNumbers, iTargetNum, iHigh, iMiddle + 1);
        }

        // Target num is at lower index than middle index
        else {
            return findNumberBinarySearch(aiNumbers, iTargetNum, iMiddle - 1, iLow);
        }

    }

    /**
     * Find index of given target num using Linear Search
     * @param aiNumbers
     * @param iTargetNum
     * @return
     */
    private int findNumberLinearSearch(int[] aiNumbers, int iTargetNum) {

        for (int x = 0; x < aiNumbers.length; x++) {
            if (aiNumbers[x] == iTargetNum) {
                return x;
            }
        }
        return -1;
    }

}
