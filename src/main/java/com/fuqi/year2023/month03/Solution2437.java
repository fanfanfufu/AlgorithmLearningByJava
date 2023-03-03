package com.fuqi.year2023.month03;

/**
 * @author FuQi
 * @date 2023/3/2 22:02
 * @description
 */
public class Solution2437 {
    public int countTime(String time) {
        if (!time.contains("?")) return 1;
        int sum = 1;

        if (time.charAt(0) == '?') {
            if (time.charAt(1) == '?') {
                sum *= 24;
            } else if (time.charAt(1) <= '3') {
                sum *= 3;
            } else {
                sum *= 2;
            }
        } else {
            if (time.charAt(1) == '?') {
                if (time.charAt(0) <= '1') {
                    sum *= 10;
                } else if (time.charAt(0) == '2') {
                    sum *= 4;
                }
            }
        }

        if (time.charAt(3) == '?') {
            if (time.charAt(4) == '?') {
                sum *= 60;
            } else {
                sum *= 6;
            }
        } else {
            if (time.charAt(4) == '?') {
                sum *= 10;
            }
        }
        return sum;
    }

    public int countTime1(String time) {
        char[] timeArr = time.toCharArray();
        int hour = 1, minute = 1;
        if (timeArr[0] == '?' && timeArr[1] == '?') hour = 24;
        else if (timeArr[0] == '?') hour = timeArr[1] < '4' ? 3 : 2;
        else if (timeArr[1] == '?') hour = timeArr[0] < '2' ? 10 : 4;

        if (timeArr[3] == '?' && timeArr[4] == '?') minute = 60;
        else if (timeArr[3] == '?') minute = 6;
        else if (timeArr[4] == '?') minute = 10;

        return hour * minute;
    }
}
