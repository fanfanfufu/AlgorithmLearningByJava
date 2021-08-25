package com.fuqi.year2021.month08.day20210825;

/**
 * @author FuQi
 */
public class Solution189 {
    /**
     * 空间复杂度为O(n)
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if (k == 0 || k == nums.length){
            return;
        }
        k = k % nums.length;

        int[] right = new int[k];
        int[] left = new int[nums.length-k];
        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, nums.length-k, right, 0, right.length);
        // 将左右部分再按照旋转后的顺序放回nums
        System.arraycopy(right, 0, nums, 0, right.length);
        System.arraycopy(left, 0, nums, right.length, left.length);
    }

    /**
     * 复制法官方写法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        //建立辅助数组存储
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 暴力：空间复杂度为O(1)
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        if (k == 0 || k == nums.length){
            return;
        }
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length-1];
            System.arraycopy(nums, 0, nums, 1, nums.length-1);
            nums[0] = temp;
        }
    }

    /**
     * 环状替换：空间o(1)，时间O(n)
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        if (k == 0 || k == nums.length){
            return;
        }
        k = k % nums.length;
        int len = nums.length;
        int count = 0;
        for (int i = 0; count < len; i++) {
            int cur = i;
            int pre = nums[cur];
            do {
                int next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while (i != cur);
        }
    }

    /**
     * 翻转数组
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        // 1. 翻转整个数组
        reverse(nums, 0, nums.length-1);
        // 2. 翻转前k个
        reverse(nums, 0, k-1);
        // 3. 翻转剩余部分
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        // 双指针做法
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1,-100,3,99};
        rotate3(input, 2);
        System.out.println("ok");
    }
}
