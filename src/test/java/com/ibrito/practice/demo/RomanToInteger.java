package com.ibrito.practice.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class RomanToInteger {

    @Test
    void testSolution1() {
        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("I", 1);
        valueMap.put("V", 5);
        valueMap.put("X", 10);
        valueMap.put("L", 50);
        valueMap.put("C", 100);
        valueMap.put("D", 500);
        valueMap.put("M", 1000);

        String roman = "LVIII";
        int result = 0;
        int lastVal = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i > 0) {
                if (valueMap.get(String.valueOf(roman.charAt(i))) <= lastVal) {
                    result += valueMap.get(String.valueOf(roman.charAt(i)));
                } else {
                    result += valueMap.get(String.valueOf(roman.charAt(i)))-lastVal;
                    result -= lastVal;
                }
            } else {
                result = valueMap.get(String.valueOf(roman.charAt(i)));
            }
            lastVal = valueMap.get(String.valueOf(roman.charAt(i)));
        }
        System.out.println("Result: " + result);
    }
}
