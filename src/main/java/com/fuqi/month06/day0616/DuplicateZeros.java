package com.fuqi.month06.day0616;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/16 10:34
 * @Version: V1.0
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        int[] input = {1,0,2,3,0,4,5,0};
        duplicateZeros.duplicateZeros(input);
    }

    public void duplicateZeros(int[] arr) {
        int temp = arr[0], i = 1;
        while (i < arr.length){
            if (temp == 0){
                temp = arr[i];
                arr[i] = 0;
            }else {
                int temp2 = arr[i];
                arr[i] = temp;
            }
        }
    }

    public void dZ2(int[] arr){
        int [] temp = new int[arr.length];
        int i = 0, j = 0;
        while (j < temp.length){
            if (arr[i] == 0){
                temp[j++] = 0;
                if (j == temp.length){
                    break;
                }
                temp[j++] = 0;
            }else {
                temp[j++] = arr[i];
            }
            i++;
        }
        for(int m = 0; m < temp.length; m++){
            arr[m] = temp[m];
        }
    }
}
