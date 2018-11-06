package com.bf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LongestIncSequence {

    public static Integer[] SubmittedLIS (Integer[] input) {

        if (input == null){
            return null;
        }

        if (input.length == 1) {
            return input;
        }

        List<Integer> bestSoFar = new ArrayList<Integer>();
        for(int i = 0; i < input.length; i++){
            List<Integer> current = new ArrayList<Integer>();
            for (int j = i; j < input.length; j++){
                if (current.size() == 0) {
                    current.add(input[j]);
                }
                if (input[j] > current.get(current.size() - 1)){
                    current.add(input[j]);
                }
            }
            if (current.size() > bestSoFar.size()){
                bestSoFar = current;
            }
        }

        return bestSoFar.toArray(new Integer[0]);
    }

    public static Integer[] LIS (Integer[] input) {
        Integer[] m = new Integer[input.length + 1];
        Arrays.fill(m,new Integer(0));
        Integer[] p = new Integer[input.length];
        Arrays.fill(p,new Integer(0));

        int l = 0;
        int high, low, mid, newLow;

        for (int i = 0; i < input.length; i++) {
            low = 1;
            high = l;
            while(low <= high) {
                mid = (int) Math.ceil((low + high) / 2);
                if (input[m[mid]] < input[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            newLow = low;

            p[i] = m[newLow - 1];
            m[newLow] = i;

            if (newLow > l){
                l = newLow;
            }
        }

        Integer[] solution = new Integer[l];
        Arrays.fill(solution, 0);

        Integer k = m[l];
        for (int i = 0; i < l; i++){
            solution[l - i - 1] = input[k];
            k = p[k];
        }

        return solution;
    }

    @Test
    public void LongestIncSequenceTest() {
        Integer[][] inputs = {
                {1,2,3,4,5},
                {1},
                {5,2,10,4,5,6,7},
                {},
                {1,2,3,0,1,2,-1,2},
                {100,1,2,3,4},
                {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15} // Wikipedia Example
        };

        Integer[][] outputs = {
                {1,2,3,4,5},
                {1},
                {2,4,5,6,7},
                {},
                {0, 1,2},
                {1,2,3,4},
                {0, 2, 6, 9, 11, 15} // Wikipedia Example

        };

        for (int i = 0; i < inputs.length; i++){
            try {
                System.out.println(i);
                assertArrayEquals(outputs[i], LIS(inputs[i]));
            } catch (Exception e) {
                System.out.println("Failed on input: " + inputs[i]);
                e.printStackTrace();
            }
        }
    }
}
