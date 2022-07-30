package com.fuqi.year2022.month07;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/7/30 17:24
 * @description
 */
public class Solution00113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(ans, path, root, targetSum);

        return ans;
    }

    private void dfs(List<List<Integer>> ans, Deque<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(ans, path, root.left, targetSum - root.val);
        dfs(ans, path, root.right, targetSum - root.val);
        path.pollLast();
    }
}
