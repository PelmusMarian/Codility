/*
 * Project: CodilityEqui
 * Made by: Pelmus Marian
 * Date: Jun 9, 2017
 */

package codilityequi;

import java.util.Arrays;
import java.util.stream.LongStream;

public class CodilityEqui {

    public static int solution(int[] A) {
        long sumB = 0; //sum of first half of the array
        long sumE = 0; //sum of the second half of the array
        int index = 0;
        long[] arr = Arrays.stream(A).asLongStream().toArray();
        
        //check for empty array
        if (A == null || A.length == 0) {
            return -1;
        }
        //find result
        for (int i = 0; i < A.length; i++) {
            sumB = 0;
            sumE = 0;
            if (i == 0) {
                sumE = LongStream.of(arr).sum() - A[0];
                if (sumE == 0) {
                    return 0;
                }
            }
            sumE = 0;
            int k = i+1;
            for (int j = 0; j < A.length; j++) {
                if(j < i){
                    sumB += A[j];
                }else{
                    if(k < A.length)
                    sumE += A[k];
                    k++;
                }
            }
            //check sums
            if (sumB == sumE) {
                return i;
            }
        }
        if (sumB != sumE) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {

        int[] arr = {0, -2147483648, -2147483648};
        System.out.println(solution(arr));
    }
}