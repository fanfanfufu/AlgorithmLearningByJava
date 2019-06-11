package com.fuqi.sortAlig;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description: 桶排序,桶内的排序就是插入、选择、归并等基本排序
 * @Author 傅琦
 * @Date 2019/6/5 21:40
 * @Version V1.0
 */
public class BucketOrder {
    public static void main(String[] args){
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156, 194, 117, 98, 139, 67, 133, 181, 13, 28, 109};
        order(arr);
    }

    public static void order(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num: arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // 划分合适的桶以及数目
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入相应的桶中
        for (int num: arr) {
            int temp = (num - min) / arr.length;
            bucketArr.get(temp).add(num);
        }

        // 桶内排序，这里直接调用Collection的
        for (ArrayList<Integer> bucket: bucketArr) {
            Collections.sort(bucket);
        }

        for (ArrayList<Integer> bucket: bucketArr) {
            if (!bucket.isEmpty()){
                for (int number: bucket) {
                    System.out.print(number + " ");
                }
            }
        }
    }
}
