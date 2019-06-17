package com.fuqi.month06.day0617;

/**
 * @Description: 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * 示例1：
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 示例2：
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * @Author 傅琦
 * @Date 2019/6/17 9:01
 * @Version V1.0
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || "".equals(s.trim())){ return 0; }

        int[] record = new int[s.length() + 1];
        record[s.length()] = 1;
        for (int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != '0'){
                record[i] += record[i+1];
            }
            if (i < s.length()-1){
                int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1)-'0');
                if (num == 0){
                    return 0;
                }
                if (9 < num && num < 27){
                    record[i] += record[i+2];
                }
            }
        }
        return record[0];
    }

    public static void main(String[] args) {
        String s = "12";
        DecodeWays decodeWays = new DecodeWays();
        int res = decodeWays.numDecodings(s);
        System.out.println(res);
    }
}
