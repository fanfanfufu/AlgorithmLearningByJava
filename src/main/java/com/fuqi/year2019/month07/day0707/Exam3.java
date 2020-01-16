package com.fuqi.year2019.month07.day0707;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/7/7 10:28
 * @Version: V1.0
 */
public class Exam3 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>(to_delete.length);
        for (int num : to_delete) {
            set.add(num);
        }

        if (root == null){ return ans; }
        if (to_delete.length == 0){
            ans.add(root);
            return ans;
        }

        dfs(root, set, ans);
        if (!set.contains(root.val)){
            ans.add(root);
        }else {
            if (root.left != null){ ans.add(root.left); }
            if (root.right != null){ ans.add(root.right); }
        }

        return ans;
    }

    private void dfs(TreeNode root, Set<Integer> set, List<TreeNode> ans){
        if (root == null) { return; }
        dfs(root.left, set, ans);
        dfs(root.right, set, ans);

        if (root.left != null && set.contains(root.left.val)){
            TreeNode ll = root.left.left;
            TreeNode lr = root.left.right;
            root.left = null;
            if (ll != null){ ans.add(ll); }
            if (lr != null){ ans.add(lr); }
        }

        if (root.right != null && set.contains(root.right.val)){
            TreeNode rl = root.right.left;
            TreeNode rr = root.right.right;
            root.right = null;
            if (rl != null){ ans.add(rl); }
            if (rr != null){ ans.add(rr); }
        }
    }
}
