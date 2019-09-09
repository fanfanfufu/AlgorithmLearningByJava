package com.fuqi;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/9/9 22:19
 * @Version V1.0
 */
public class KMP {

    /**
     * 获得next数组
     */
    private static int[] getNextArray(char[] chars) {
        if (chars.length == 1) { return new int[] {-1}; }

        int[] next = new int[chars.length];
        // 因为第一号位左边没有字符可以匹配，所以记为-1
        next[0] = -1;
        // 因为第2号位左边只有一个字符，最长公共前后缀就是1号位这个字符本身
        // 但是由于最长公共前后缀的长度要小于当前字串的长度，因此记为0
        next[1] = 0;

        // 第三个字符开始找
        int positon = 2;
        int count = 0;
        // 找当前位置左边字串的最长公共前后缀，并将其长度赋值给next数组当前位置
        while (positon < chars.length) {
            if (chars[positon-1] == chars[0]) {
//                count++;
//                next[positon] = count;
//                positon++;
                next[positon++] = ++count;
            } else if (count > 0) {
                count = next[count];
            } else {
//                next[positon] = 0;
//                positon++;
                next[positon++] = 0;
            }
        }
        return next;
    }

    /**
     * 对主串和模式串进行KMP匹配
     * @param source 待匹配的主串
     * @param pattern 模式串
     * @return int 若匹配成功，则返回pattern在主串中的起始位置；若匹配失败，则返回-1
     */
    public static int kmpMatch(String source, String pattern) {
        char[] s_arr = source.toCharArray();
        char[] p_arr = pattern.toCharArray();
        int[] next = getNextArray(p_arr);
        int i = 0, j = 0;

        while (i < s_arr.length && j < p_arr.length) {
            if (j == -1 || s_arr[i] == p_arr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == p_arr.length) {
            return i-j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
    }
}
