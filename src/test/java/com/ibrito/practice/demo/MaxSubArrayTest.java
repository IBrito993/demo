package com.ibrito.practice.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MaxSubArrayTest {

    @Test
    void testSolution1() {
        int[] array = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, maxSubArray(array));
    }

    @Test
    void testSolution2() {
        int[] array = new int[] {5, 4, -1, 7, 8};
        assertEquals(23, maxSubArray(array));
    }

    @Test
    void testSolution3() {
        int[] array = new int[] {-1};
        assertEquals(-1, maxSubArray(array));
    }

    @Test
    void testSolution4() {
        int[] array = new int[] {-2, -1};
        assertEquals(-1, maxSubArray(array));
    }

    @Test
    void testSolution5() {
        int[] array = new int[] {-2, 1};
        assertEquals(1, maxSubArray(array));
    }

    @Test
    void testSolution6() {
        int[] array = new int[] {1,-1,1};
        maxSubArray(array);
        assertEquals(1, maxSubArray(array));
    }

    public static int maxSubArray(int[] nums) {

        int resultSum = nums[0];
        int curr =  nums[0];
        System.out.println();
        for (int i = 1; i < nums.length; i++) {

            curr = Math.max(curr+nums[i], nums[i]);
            resultSum = Math.max(resultSum, curr);

        }
        return resultSum;
    }


    public String addStrings(String num1, String num2) {
        StringBuilder resault = new StringBuilder();
        int counter1 = num1.length() - 1, counter2 = num2.length() - 1, sum = 0;
        while (counter1 >= 0 || counter2 >= 0) {
            if (counter1 >= 0 && counter2 >= 0) sum += num1.charAt(counter1) + num2.charAt(counter2) - 96;
            else if (counter1 >= 0) sum += num1.charAt(counter1) - 48;
            else sum += num2.charAt(counter2) - 48;
            resault.append(sum % 10);
            sum /= 10;
            counter1--;
            counter2--;
        }
        if (sum != 0) resault.append(sum);
        return resault.reverse().toString();
    }

}