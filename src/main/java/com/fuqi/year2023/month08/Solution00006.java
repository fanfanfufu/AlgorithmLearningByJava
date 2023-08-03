package com.fuqi.year2023.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/2 23:34
 * @description
 */
public class Solution00006 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<List<Character>> convertedData = new ArrayList<>(numRows);
        int row = 0, col = 0;
        boolean isSlash = false;
        for (int i = 0; i < s.length(); i++) {
            if (isSlash && row >= 0) {
                convertedData.get(row).get(s.charAt(i));
                row--;
                if (row < 0) {
                    isSlash = false;
                    row = 0;
                    continue;
                }
                col++;
                continue;
            }
            convertedData.get(row).add(s.charAt(i));
            row++;
            if (row >= numRows) {
                isSlash = true;
                row = numRows-1;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (List<Character> eachRow : convertedData) {
            for (Character ch : eachRow) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
