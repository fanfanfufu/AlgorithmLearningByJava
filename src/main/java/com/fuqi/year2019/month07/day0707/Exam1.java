package com.fuqi.year2019.month07.day0707;

/**
 * @Description: 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *               所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 * @Author: 傅琦
 * @DateTime: 2019/7/7 10:28
 * @Version: V1.0
 */
public class Exam1 {
    public String defangIPaddr(String address) {
//        return address.replaceAll("\\.", "[.]");

        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.'){
                sb.append("[.]");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Exam1 exam1 = new Exam1();
        String input = "1.1.1.1";
        String res = exam1.defangIPaddr(input);
        System.out.println("res = " + res);
    }
}
