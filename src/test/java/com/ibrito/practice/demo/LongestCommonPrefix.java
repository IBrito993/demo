package com.ibrito.practice.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LongestCommonPrefix {

    @Test
    void testSolution1() {
        //String[] strs = {"dog", "racecar", "car"};
        //String[] strs = {"flower", "flow", "flight"};
        //String[] strs = {"", "b"};
        //String[] strs = {"a"};
        //String[] strs = {"cir", "car"};
        //String[] strs = {"a","a","b"};
        //String[] strs = {"aaa", "aa", "aaa"};
        //String[] strs = {"flower", "flower", "flower", "flower"};
         String[] strs = {"a", "ac"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int lastindex = -1;
        int resultIndex = -1;
        int maxLength = strs[0].length()-1;
        char[] baseWordArray = strs[0].toCharArray();

        if (strs.length == 1) {
            return strs[0];
        }

        if (strs[0].length() == 0) {
            return "";
        }

        for (int i = 1; i < strs.length; i++) {


            char[] charArray = strs[i].toCharArray();

            for (int j = 0; j < charArray.length && j <= maxLength; j++) {
                if (baseWordArray[j] == charArray[j]) {
                    lastindex = j;
                } else {
                    break;
                }
            }

            if (lastindex <= -1) {
                resultIndex = -1;
                break;
            }
            if (maxLength > lastindex)
                maxLength = lastindex;

            resultIndex = lastindex;
            lastindex = -1;

        }
        return resultIndex > -1 ? strs[0].substring(0, resultIndex + 1) : "";
    }

}
