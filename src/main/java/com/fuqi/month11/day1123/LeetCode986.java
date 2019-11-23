package com.fuqi.month11.day1123;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: LeetCode第986题
 * @Author 傅琦
 * @date 2019/11/23 10:22
 * @Version V1.0
 */
public class LeetCode986 {
    /**
     * 用双指针法
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList();
        if(A == null || A.length < 1 || A[0].length < 1
                || B == null || B.length < 1 || B[0].length < 1)
            return list.toArray(new int[list.size()][2]);
        int indexA = 0;
        int indexB = 0;
        while(indexA < A.length && indexB < B.length){
            int start = Math.max(A[indexA][0], B[indexB][0]);
            int end = Math.min(A[indexA][1], B[indexB][1]);
            if(start > end){
                if(A[indexA][0] > B[indexB][1]){
                    indexB++;
                }
                else{
                    indexA++;
                }
                continue;
            }
            int[] temp = {start, end};
            list.add(temp);
            if(A[indexA][1] < B[indexB][1]){
                indexA++;
            }
            else if(A[indexA][1] == B[indexB][1]){
                indexA++;
                indexB++;
            }
            else{
                indexB++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
