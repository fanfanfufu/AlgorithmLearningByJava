package com.fuqi.year2024.month11;

import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/11/21 23:52
 * @description
 */
public class Solution03248 {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int cur = 0;
        for (String command : commands) {
            if ("UP".equals(command)) {
                cur -= n;
            } else if ("RIGHT".equals(command)) {
                cur += 1;
            } else if ("DOWN".equals(command)) {
                cur += n;
            } else {
                cur -= 1;
            }
        }

        return cur;
    }
}
