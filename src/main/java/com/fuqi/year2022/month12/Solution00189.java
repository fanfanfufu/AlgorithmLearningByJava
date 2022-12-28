package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/28 22:30
 * @description
 */
public class Solution00189 {
    /**
     * 方法一：使用额外的数组
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num2[(i + k) % n] = nums[i];
        }
        System.arraycopy(num2, 0, nums, 0, n);
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = gcd(k, n);
        for (int i = 0; i < count; i++) {
            int cur = i;
            int pre = nums[i];
            do {
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
            } while (i != cur);
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int i = 0; i < count; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (i != current);
        }
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(x, x % y) : x;
    }

    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 反转整个数据
        reverse(nums, 0, n - 1);
        // 反转前k个
        reverse(nums, 0, k - 1);
        // 反转剩余的部分
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
