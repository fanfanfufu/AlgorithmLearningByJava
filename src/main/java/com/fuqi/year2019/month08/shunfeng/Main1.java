package com.fuqi.year2019.month08.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/29 19:47
 * @Version V1.0
 */
public class Main1 {
//    private static int helper(int[] arr){
//        int[] dp = new int[arr.length];
//        dp[0] = 1;
//
//        for (int i = 1; i < arr.length; i++) {
//            int count = 1;
//            for (int j = i-1; j >= 0; j--) {
//                if (arr[j] < arr[i]){
//                    count = Math.max(count, dp[j]+1);
//                }
//            }
//            dp[i] = count;
//        }
//
//        int maxV = 0;
//        for (int i = 0; i < arr.length; i++) {
//            maxV = Math.max(maxV, dp[i]);
//        }
//        return maxV;
//    }

    public static Value merge(Value v1, Value v2) {
        if (v1.length == v2.length) {
            if (v1.length == 0) {
                return new Value(0, 1);
            }
            return new Value(v1.length, v1.count + v2.count);
        }
        return v1.length > v2.length ? v1 : v2;
    }

    public static void insert(Node node, int key, Value val) {
        if (node.range_left == node.range_right) {
            node.val = merge(val, node.val);
            return;
        } else if (key <= node.getRangeMid()) {
            insert(node.getLeft(), key, val);
        } else {
            insert(node.getRight(), key, val);
        }
        node.val = merge(node.getLeft().val, node.getRight().val);
    }

    public static Value query(Node node, int key) {
        if (node.range_right <= key) {
            return node.val;
        }
        else if (node.range_left > key) {
            return new Value(0, 1);
        }
        else {
            return merge(query(node.getLeft(), key), query(node.getRight(), key));
        }
    }

    public static int helper2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0], max = nums[0];
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        Node root = new Node(min, max);
        for (int num: nums) {
            Value v = query(root, num-1);
            insert(root, num, new Value(v.length + 1, v.count));
        }
        return root.val.count;
    }

    public static int helper(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int dp[] = new int[len];
        int count[] = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(helper(arr));

        scanner.close();
    }
}

class Node {
    int range_left, range_right;
    Node left, right;
    Value val;
    public Node(int start, int end) {
        range_left = start;
        range_right = end;
        left = null;
        right = null;
        val = new Value(0, 1);
    }
    public int getRangeMid() {
        return range_left + (range_right - range_left) / 2;
    }
    public Node getLeft() {
        if (left == null) {
            left = new Node(range_left, getRangeMid());
        }
        return left;
    }
    public Node getRight() {
        if (right == null) {
            right = new Node(getRangeMid() + 1, range_right);
        }
        return right;
    }
}

class Value {
    int length;
    int count;
    public Value(int len, int ct) {
        length = len;
        count = ct;
    }
}
