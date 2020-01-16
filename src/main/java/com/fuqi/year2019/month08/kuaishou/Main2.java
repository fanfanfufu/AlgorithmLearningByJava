package com.fuqi.year2019.month08.kuaishou;

import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/25 17:09
 * @Version V1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while(N != 0) {
            N--;
            int number = sc.nextInt();

            boolean flag = true;
            while (number*number > 10) {
                int pre = number;
                number = func(number);
                if (pre == number) {
                    System.out.println("false");
                    flag = false;
                    break;
                }
            }

            if(flag) {
                if(number == 1)
                    System.out.println("true");
                else
                    System.out.println("false");
            }
        }
    }

    static int func(int num){
        int result = 0;
        while(num != 0) {
            int temp = num%10;
            result += temp*temp;
            num = num/10;
        }

        return result;
    }
}
