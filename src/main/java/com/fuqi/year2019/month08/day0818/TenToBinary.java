package com.fuqi.year2019.month08.day0818;

/**
 * @Description
 * @Team: 电子科技大学自动化研究所
 * @Author: 傅琦
 * @DateTime: 2019/8/18 22:50
 * @Version: V1.0
 */
public class TenToBinary {
    public void binaryToDecimal(int n) {
        //用来记录位数
        int t = 0;
        //用来记录最后的二进制数
        int bin = 0;
        //用来存储余数
        int r = 0;
        while(n != 0){
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10,t);
            t++;
        }
        System.out.println(bin);
    }

    private void binaryToDecimal2(int n){
        StringBuilder binary = new StringBuilder();
        int r = 0;
        while (n != 0){
            r = n % 2;
            n /= 2;
            binary.append(r);
        }
        System.out.println(binary.reverse());
    }

    public static void main(String[] args) {
        TenToBinary toBinary = new TenToBinary();
        toBinary.binaryToDecimal(10);
        toBinary.binaryToDecimal2(10);
    }
}
