package com.fuqi.year2019.month08.kedaxunfei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/16 18:37
 * @Version V1.0
 */
public class Solution1 {
    public static void main(String[] args) {
        // 爱讯飞789swi34kash1ia65dec
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        char[] strs = string.toCharArray();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] >= '0' && strs[i] <= '9'){
                Integer temp = Integer.valueOf(Character.toString(strs[i]));
                list.add(temp);
            }
        }

        if (list.isEmpty()){
            System.out.println(-1);
        }else {
            Collections.sort(list);
            for (int num : list) {
                System.out.print(num);
            }
        }
    }
}
