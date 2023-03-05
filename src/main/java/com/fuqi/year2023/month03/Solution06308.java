package com.fuqi.year2023.month03;

import com.fuqi.year2020.TreeNode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author FuQi
 * @date 2023/3/5 11:09
 * @description
 */
public class Solution06308 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root.left == null && root.right == null){
            if (k == 1) return (long) root.val;
            if (k > 1) return -1;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int layerCount = 0;
        // 层和的大顶堆
        PriorityQueue<Long> kthSumHeap = new PriorityQueue<>(k);
        while (!deque.isEmpty()) {
            layerCount++;
            int curSize = deque.size();
            long layerSum = 0L;
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = deque.pollFirst();
                layerSum = layerSum + curNode.val;
                if (curNode.left != null) deque.offerLast(curNode.left);
                if (curNode.right != null) deque.offerLast(curNode.right);
            }
            if (kthSumHeap.size() < k) {
                kthSumHeap.offer(layerSum);
            } else if (layerSum > kthSumHeap.peek()) {
                kthSumHeap.poll();
                kthSumHeap.offer(layerSum);
            }
        }

        return layerCount < k ? -1 : kthSumHeap.peek();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        Solution06308 solution06308 = new Solution06308();
        System.out.println(solution06308.kthLargestLevelSum(root, 1));
    }
}
