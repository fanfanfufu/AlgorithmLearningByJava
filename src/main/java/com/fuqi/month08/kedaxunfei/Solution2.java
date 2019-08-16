package com.fuqi.month08.kedaxunfei;

import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/16 18:51
 * @Version V1.0
 */
public class Solution2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1, str.length() - 1);
        if ("".equals(str.trim())){
            return;
        }
        String[] strs = str.split(",");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.valueOf(strs[i]);
        System.out.println(binarySearch(arr, 0, arr.length - 1, 19));
    }

    private static int binarySearch(int[] arr, int st, int ed, int tar){
        int len = arr.length;
        if(len == 0 || st > ed)
            return -1;
        int mid = st + (ed - st) / 2;
        if(arr[mid] == tar)
            return mid + 1;
        if(arr[mid] < tar)
            return binarySearch(arr, st, mid - 1, tar);
        return binarySearch(arr, mid + 1, ed, tar);
    }

    private static int binarySearch1(int[] arr, int st, int ed, int tar){
        int len = arr.length;
        if(len == 0 || st > ed)
            return -1;
        int mid = st + (ed - st) / 2;
        if(arr[mid] == tar)
            return mid + 1;
        int l = binarySearch(arr, st, mid - 1, tar);
        if(l != -1)
            return l;
        return binarySearch(arr, mid + 1, ed, tar);
    }

}
