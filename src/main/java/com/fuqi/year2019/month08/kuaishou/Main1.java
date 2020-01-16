package com.fuqi.year2019.month08.kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/25 17:09
 * @Version V1.0
 */
public class Main1 {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lines = sc.nextInt();
        for (int i = 0; i < lines; i++) {
            String str1 = sc.next();
            List<Integer> list1 = new ArrayList<>();
            for (char ch : str1.toCharArray()) {
                if (ch != '.'){
                    list1.add(ch - '0');
                }
            }
            StringBuilder sb1 = new StringBuilder();
            for (int num : list1) {
                sb1.append(num);
            }
            System.out.println(sb1.toString());

            String str2 = sc.next();
            List<Integer> list2 = new ArrayList<>();
            for (char ch : str2.toCharArray()) {
                if (ch != '.'){
                    list2.add(ch - '0');
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (int num : list2) {
                sb2.append(num);
            }
            System.out.println(sb2.toString());

            if (sb1.length() < sb2.length()){
                for (int j = 0; j <= sb2.length()-sb1.length(); j++) {
                    sb1.append(0);
                }
                System.out.println(sb1);
            }else if (sb1.length() > sb2.length()){
                for (int j = 0; j <= sb1.length()-sb2.length(); j++) {
                    sb2.append(0);
                }
                System.out.println(sb2);
            }

            System.out.println(sb1.toString().compareTo(sb2.toString()) < 0);
        }

        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        while(N != 0){
            N--;
            String line = sc.nextLine();
            String[] str = line.split(" ");
            String[] demo1 = str[0].split("\\.");
            String[] demo2 = str[1].split("\\.");
            int p1 = 0;
            int p2 = 0;
            boolean flag = true;
            while(p1 < demo1.length && p2 < demo2.length){
                int n1 = Integer.valueOf(demo1[p1]);
                int n2 = Integer.valueOf(demo2[p2]);
                if(n1 < n2){
                    System.out.println("true");
                    flag = false;
                    break;
                } else if(n1 > n2){
                    System.out.println("false");
                    flag = false;
                    break;
                }
                p1++;
                p2++;
            }

            if(flag) {
                boolean mark = true;
                while (p1 < demo1.length) {
                    int n = Integer.valueOf(demo1[p1]);
                    if (n > 0) {
                        System.out.println("false");
                        mark = false;
                        break;
                    }
                    p1++;
                }
                while (p2 < demo2.length) {
                    int n = Integer.valueOf(demo2[p2]);
                    if (n > 0) {
                        System.out.println("true");
                        mark = false;
                        break;
                    }
                    p2++;
                }
                if(mark)
                    System.out.println("false");
            }
        }
    }
}
