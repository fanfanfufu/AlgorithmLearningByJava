package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/17 21:32
 * @description 判断两个事件是否存在冲突
 */
public class Solution02446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int event1Start = Integer.parseInt(event1[0].replace(":", ""));
        int event1End = Integer.parseInt(event1[1].replace(":", ""));
        int event2Start = Integer.parseInt(event2[0].replace(":", ""));
        int event2End = Integer.parseInt(event2[1].replace(":", ""));

        if (event2Start > event1End || event1Start > event2End) return false;

        return true;
    }

    public boolean haveConflict2(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
