package com.fuqi.year2022.month02.week281;

/**
 * @author FuQi
 * @date 2022/2/20 11:17
 * @description
 */
public class Solution06014 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] charCount = new int[26];
        char[] chars = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)-'a']++;
        }
        int c = 0;
        int i = 25;
        StringBuilder builder = new StringBuilder();
        while (true) {
            while (i >= 0 && charCount[i] == 0) {
                i--;
            }
            if (i == -1) {
                break;
            }
            while (charCount[i] > 0 && c < repeatLimit) {
                c++;
                builder.append((char) i+'a');
                charCount[i]--;
            }
            c = 0;
            if (charCount[i] == 0) {
            } else {
                int j = i-1;
                while (j >= 0 && charCount[j] == 0) {
                    j--;
                }
                if (j >= 0) {
                    builder.append((char) j+'a');
                    charCount[j]--;
                } else {
                    break;
                }
            }
        }

        return builder.toString();
    }
}
