package com.fuqi.month11.day1118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/11/18 10:40
 * @Version V1.0
 */
public class LeetCode1238 {
    /**
     * 其实就是考察格雷码的构造
     * 生成格雷码的方法:
     * n+1位格雷码G(n+1)的总数 等于 n位格雷码G(n)总数的2倍。
     * 只需将n位格雷码G(n)最高位添加0作为G(n+1)的前一半数据(符合格雷码要求)，
     * 然后G(n)逆序排,并在最高位加1,作为G(n+1)的后一半数据(也符合格雷码要求),即G(n)每一位加上1<<(n)。
     */

    /**
     * 方法一
     * @param n
     * @param start
     * @return
     */
    public List<Integer> circularPermutation(int n, int start) {

        List<Integer> grayCode = new ArrayList<>();
        grayCode.add(0);
        for (int i = 0; i < n; i++)
            for (int j = grayCode.size() - 1; j >= 0; j--)
                grayCode.add(grayCode.get(j) + (1 << i));

        // rotate
        for (int i = 0; i < grayCode.size(); i++)
            if (grayCode.get(i) == start) {

                Collections.rotate(grayCode, -i);
                break;
            }

        return grayCode;
    }

    /**
     * 递归生成格雷码
     */
    public static List<Integer> genGaryCode(int n) {
        List<Integer> result = new ArrayList<>();

        if (n <= 0){
            return result;
        }

        if (n == 1) {
            result.add(0);
            result.add(1);
        }

        List<Integer> pre = genGaryCode(n-1);
        int len = pre.size();
        result.addAll(pre);
        for (int i = len - 1; i >= 0; i--) {
            result.add(pre.get(i) + (1 << (n-1)));
        }

        return result;
    }

    /**
     * 循环生成格雷码
     */
    public static List<Integer> genGaryCodeCircle(int n){
        List<Integer> result = new ArrayList<>();

        if (n <= 0){
            return result;
        }

        result.add(0);
        result.add(1);
        if (n == 1) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            int temp = result.size();
            for (int j = temp-1; j >= 0; j--) {
                result.add(result.get(j) + (1 << (i-1)));
            }
        }

        return result;
    }

    /**
     * 方法二
     * @param n
     * @param start
     * @return
     */
    public List<Integer> circularPermutation2(int n, int start) {
        if(n <= 0 || start < 0 || start >=(int)Math.pow(2,n)) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        if(n == 1) {
            list.add(start);
            list.add(1-start);
            return list;
        }
        //生成格雷码
        list.add(0);
        list.add(1);
        int index = start == 1 ? 1:0;
        for(int i=2; i<=n; i++) {
            int temp = list.size();
            for(int j=temp-1; j>=0; j--) {
                int value = list.get(j) + (1<<(i-1));
                list.add(value);
                if(value == start) {
                    index = list.size()-1;
                }
            }
        }
        //截断格雷码，重排序
        List<Integer> result = new ArrayList<>();
        result.addAll(list.subList(index, list.size()));
        result.addAll(list.subList(0, index));
        return result;
    }
}
