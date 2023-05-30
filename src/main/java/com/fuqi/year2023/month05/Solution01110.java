package com.fuqi.year2023.month05;

import com.fuqi.year2020.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/30 20:31
 * @description
 */
public class Solution01110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) return ans;
        Set<Integer> toDeleteNum = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        dfs(root, ans, toDeleteNum);
        if (dfs(root, ans, toDeleteNum) != null) ans.add(root);

        return ans;
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> ans, Set<Integer> toDeleteNum) {
        if (root == null) return null;

        root.left = dfs(root.left, ans, toDeleteNum);
        root.right = dfs(root.right, ans, toDeleteNum);

        if (!toDeleteNum.contains(root.val)) return root;
        if (root.left != null) {
            ans.add(root.left);
        }
        if (root.right != null) {
            ans.add(root.right);
        }

        return null;
    }
}
