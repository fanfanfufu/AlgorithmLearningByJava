package com.fuqi.month06.day0617;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @Author 傅琦
 * @Date 2019/6/17 11:06
 * @Version V1.0
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        UniqueBinarySearchTreesII treesII = new UniqueBinarySearchTreesII();
        List<TreeNode> res = treesII.generateTrees2(3);
        System.out.println("res = " + res);
    }

    /**
     * 解法一
     */
    public List<TreeNode> generateTrees1(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        else{
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            TreeNode[] resarr =  recursion(1, n, dp);
            List<TreeNode> res = new ArrayList<>();
            for(TreeNode node : resarr){
                res.add(node);
            }
            return res;
        }
    }

    public TreeNode[] recursion(int s, int e, int[] dp){
        TreeNode[] roots = null;
        int curlen = 0;
        if(s > e){
            roots = new TreeNode[1];
            roots[0] = null;
            return roots;
        }
        roots = new TreeNode[dp[e - s + 1]];
        for(int i = s; i <= e; i++){
            TreeNode[] lefts = recursion(s, i - 1, dp);
            TreeNode[] rights = recursion(i + 1, e, dp);
            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots[curlen++] = root;
                }
            }
        }
        return roots;
    }

    /**
     * 方式2
     */
    public List<TreeNode> generateTrees2(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, end);
            for(TreeNode left : leftSubTrees) {
                for(TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

    /**
     * 解法3
     */
    public List<TreeNode> generateTrees3(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if (n == 0) { return ret; }
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i){
            nums[i] = i+1;
        }
        return build(nums, 0, n-1);
    }

    private List<TreeNode> build(int[] nums, int l, int r) {
        List<TreeNode> list = new ArrayList<>();
        // bug - 2 => Arrays.asList(null) is illegal, we use list directly here;
        if (l >= r) {
            // sentry node used to reduce complexity;
            if (l > r) {
                list.add(null);
            }
            else {
                list.add(new TreeNode(nums[l]));
            }
            return list;
        }
        for (int i = l; i <= r; ++i) {
            List<TreeNode> lList = build(nums, l, i-1);
            List<TreeNode> rList = build(nums, i+1, r);
            for (TreeNode lNode: lList) {
                for (TreeNode rNode: rList) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}
