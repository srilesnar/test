import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long testCases = input.nextInt();
        while(testCases > 0) {
        	if (!input.hasNextInt()) {
        		break;
        	}
            long n = input.nextInt();
            if ( n==0 ) { continue; }
            ArrayList<Integer> arr = new ArrayList<>();
            boolean isAllNegative = true;
            for (int i=0; i<n ; i++) {
            	if (!input.hasNext()) {
            		break;
            	}
                arr.add(input.nextInt());
                if (arr.get(i) > 0) {
                    isAllNegative = false;
                }
            }
            
            int maxSum = arr.get(0);
            int currMaxSum = arr.get(0);
            int nonContSum = arr.get(0);
            int maxNegative = arr.get(0);
            for ( int j = 1; j< arr.size(); j++) {
                currMaxSum = Math.max(arr.get(j), currMaxSum+arr.get(j));
                maxSum = Math.max(currMaxSum, maxSum);
                if (isAllNegative ) {
                    if (maxNegative < arr.get(j)) {
                        maxNegative = arr.get(j);
                    }
                } else if (arr.get(j) > 0) {
                    nonContSum += arr.get(j);
                }
            }
            
            if (isAllNegative ) {
                System.out.println(maxSum+" "+maxNegative);
            } else {
                System.out.println(maxSum+" "+nonContSum);
            }
            
            testCases--;
            }
    }
}