package com.fuqi.year2022.month06;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/6/18 21:05
 * @description
 */
public class Solution00199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        bfs(ans, root);
        dfs(ans, root, 0);
        return ans;
    }

    /**
     * BFS思路：取每层的最后一个即可
     *
     * @param ans
     * @param root
     */
    private void bfs(List<Integer> ans, TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = deque.pollFirst();
                if (cur == null) {
                    continue;
                }
                if (i == len-1) {
                    ans.add(cur.val);
                }
                if (cur.left != null) {
                    deque.offerLast(cur.left);
                }
                if (cur.right != null) {
                    deque.offerLast(cur.right);
                }
            }
        }
    }

    /**
     * DFS: 按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
     * @param ans
     * @param root
     * @param depth
     */
    private void dfs(List<Integer> ans, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 因为访问顺序是：根结点 -> 右子树 -> 左子树，因此：
        // 如果当前节点的深度与ans的size一致，说明当前节点就是最右侧的节点
        // 所以，可以将当前节点添加到ans中
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        // 当前节点判断完成，则需要对深度+1
        depth++;
        // 再访问右子树
        dfs(ans, root.right, depth);
        // 最后访问左子树
        dfs(ans, root.left, depth);
    }
}
