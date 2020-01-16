package com.fuqi.year2019.month11.day1119;

/**
 * @Description: LeetCode423题
 * @Author 傅琦
 * @date 2019/11/19 16:42
 * @Version V1.0
 */
public class LeetCode423 {
    public String originalDigits(String s) {
        char[] count = new char[26 + 'a'];
        for (char letter : s.toCharArray()) {
            count[letter]++;
        }

        int[] out = new int[10];
        // 这几个偶数只需要通过一个字符就可以判断其个数
        out[0] = count['z'];
        out[2] = count['w'];
        out[4] = count['u'];
        out[6] = count['x'];
        out[8] = count['g'];

        // 3和8都包含h，所以3的个数就是字符h出现的次数减去8的个数所剩的
        out[3] = count['h'] - out[8];
        // 5和7的个数计算与3的相同
        out[5] = count['f'] - out[4];
        // 7还有一种：out[7] = count['v'] - out[5];
        out[7] = count['s'] - out[6];

        // 1的个数等于字符o的次数减去0，2，4的个数
        out[1] = count['o'] - out[0] - out[2] - out[4];
        // 1的个数也可以这么算，只不过需要先计算出9的个数
        // out[1] = count['n'] - out[7] - 2 * count[9];

        // 9的个数等于字符i的个数减去5，6，8的个数
        out[9] = count['i'] - out[5] - out[6] - out[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
