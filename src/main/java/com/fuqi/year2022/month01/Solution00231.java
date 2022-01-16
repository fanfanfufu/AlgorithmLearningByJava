package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/16 22:36
 * @description
 */
public class Solution00231 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 6;
        System.out.println("a 往左移动一位：" + (a << 1));
        System.out.println("a 往右移动一位：" + (a >> 1));
        System.out.println("b 往左移动一位：" + (b << 1));
        System.out.println("b 往右移动一位：" + (b >> 1));
        System.out.println("c 往左移动一位：" + (c << 1));
        System.out.println("c 往右移动一位：" + (c >> 1));
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-6));
    }

    /**
     * 统计转换成二进制表示后1的个数是否等于1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n) {
        if (n < 1) {
            return false;
        }
        String binaryString = Integer.toBinaryString(n);
        int oneCount = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                oneCount++;
            }
        }
        return oneCount == 1;
    }

    /**
     * n与n-1做与运算，如果是2的幂，结果必须是0
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    /**
     * n与-n做与运算，如果是2的幂，结果必须是n
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo3(int n) {
        return n > 0 && (n & -n) == n;
    }

    /**
     * 判断n是否是Integer类型中最大的2的幂的约数(取模为0)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo4(int n) {
        int maxPower = 1 << 30;
        return n > 0 && (maxPower % n == 0);
    }

    /**
     * 使用异或操作
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo5(int n) {
        return n > 0 && ((n ^ (n-1)) == n * 2 - 1);
    }

    /**
     * 打表法：列出Integer中所有2的幂，如果n不在这些中，直接返回false
     * @param n
     * @return
     */
    public boolean isPowerOfTwo6(int n) {
        switch (n) {
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256:
            case 512:
            case 1024:
            case 2048:
            case 4096:
            case 8192:
            case 16384:
            case 32768:
            case 65536:
            case 131072:
            case 262144:
            case 524288:
            case 1048576:
            case 2097152:
            case 4194304:
            case 8388608:
            case 16777216:
            case 33554432:
            case 67108864:
            case 134217728:
            case 268435456:
            case 536870912:
            case 1073741824:
                return true;
            default:
                return false;
        }
    }

    /**
     * 打表法：使用二进制表示
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo7(int n) {
        switch (n) {
            case 0b1:
            case 0b10:
            case 0b100:
            case 0b1000:
            case 0b10000:
            case 0b100000:
            case 0b1000000:
            case 0b10000000:
            case 0b100000000:
            case 0b1000000000:
            case 0b10000000000:
            case 0b100000000000:
            case 0b1000000000000:
            case 0b10000000000000:
            case 0b100000000000000:
            case 0b1000000000000000:
            case 0b10000000000000000:
            case 0b100000000000000000:
            case 0b1000000000000000000:
            case 0b10000000000000000000:
            case 0b100000000000000000000:
            case 0b1000000000000000000000:
            case 0b10000000000000000000000:
            case 0b100000000000000000000000:
            case 0b1000000000000000000000000:
            case 0b10000000000000000000000000:
            case 0b100000000000000000000000000:
            case 0b1000000000000000000000000000:
            case 0b10000000000000000000000000000:
            case 0b100000000000000000000000000000:
            case 0b1000000000000000000000000000000:
                return true;
            default:
                return false;
        }
    }
}
