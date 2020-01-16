package com.fuqi.year2019.month07.pinduoduo;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/28 13:45
 * @Version V1.0
 */
public class Pin2 {
    public static void main(String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int len = strs.length;
        int[] count = new int[26];
        for(int i = 0; i < len; i++){
            count[strs[i].charAt(0) - 'A'] ++;
            count[strs[i].charAt(strs[i].length() - 1) - 'A'] ++;
        }
        for(int i = 0; i < 26; i++){
            if(count[i] % 2 != 0){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
