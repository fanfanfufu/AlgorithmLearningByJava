package com.fuqi.year2024.month02;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/2/7 22:59
 * @description
 */
public class Solution02641 {
    public TreeNode replaceValueInTree(TreeNode root) {
        // 堂兄弟节点 -> 深度相同父节点不同的节点
        // 根节点无堂兄弟节点 -> root.val = 0
        root.val = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        // 将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            // 遍历每一层(深度相同)的节点并将对于的val加起来，最后要交换的值-> sum - x - y
            for (TreeNode node: queue) {
                if (node.left != null) {
                    sum += node.left.val;
                }
                if (node.right != null) {
                    sum += node.right.val;
                }
            }
            // 遍历第二遍 -> 将不是堂兄弟节点的val减去
            while (size-- > 0) {
                // 第一遍用的for遍历并没有将队列改变，所以可以复用queue
                TreeNode node = queue.poll();
                // 将父节点下的两个非堂兄弟节点的值记录
                int sumOfxy = (node.left == null ? 0 : node.left.val) + (node.right == null ? 0: node.right.val);
                // 若该父节点node下的子节点存在则将其更改val并将子节点入队
                if (node.left != null) {
                    node.left.val = sum - sumOfxy;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = sum - sumOfxy;
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
