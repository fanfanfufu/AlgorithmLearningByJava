package com.fuqi.year2019.month08.beikezhengshipi;

import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/23 19:22
 * @Version V1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();
        int k=scanner.nextInt();
        String str=scanner.next();
        helper(k, str);

        scanner.close();
    }

    private static void helper(int k, String str) {
        if(str == null){
            System.out.println("");
        }
        StringBuilder res = new StringBuilder();
        int left=0;
        int right=str.length() - 1;
        int cnt=0;
        while(left!=right) {
            if(str.charAt(left++)==str.charAt(right--)) {
                cnt++;
            }else{
                break;
            }

        }
        for(int i=0;i<k;i++) {
            if(i>0) {
                res.append(str.substring(cnt, str.length()));
            }else {
                res.append(str);
            }

        }
        System.out.println(res.toString());
    }
}
