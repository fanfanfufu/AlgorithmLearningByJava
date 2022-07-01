package com.fuqi.year2022.month07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/7/1 22:47
 * @description
 */
public class Solution00093 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s, len, 0, 4, path, res);

        return res;
    }

    /**
     * @param s            字符串
     * @param len          字符串长度
     * @param begin        本次递归开始的位置
     * @param restSigCount 复原成IP待复原的段数
     * @param path         存储已经添加的IP段
     * @param res          结果集
     */
    private void dfs(String s, int len, int begin, int restSigCount, Deque<String> path, List<String> res) {
        // 递归终止条件
        if (begin == len) {
            // 如果起始位等于字符串的长度，则需要终止递归
            if (restSigCount == 0) {
                // 此时，当剩余段数为0的时候像结果集中添加该IP
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            // 当字符串剩余的长度大于剩余段数的长度上限(每段都是3位)时，指针往后挪，进行下一次循环
            if ((restSigCount - 1) * 3 < len - i - 1) {
                continue;
            }
            // 判断当前取出的数字是否时合法的IP单段数
            if (judgeNumber(s, begin, i)) {
                // 是的话，则添加道path中，然后递归处理字符串后续的内容
                String curS = s.substring(begin, i + 1);
                path.addLast(curS);
                dfs(s, len, i + 1, restSigCount - 1, path, res);
                // 递归处理完后，进行回溯
                path.removeLast();
            }
        }
    }

    private boolean judgeNumber(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res < 256;
    }
}
