package com.fuqi.year2020.month05.day10;

import com.fuqi.year2020.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: LeetCode236题
 * @Author: 傅琦
 * @DateTime: 2020/5/10 11:01
 * @Version: V1.0
 */
public class LeetCode236 {
    /** 方法一：递归判断，
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 缺点：判断条件较复杂，不好理解
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){ return false; }

        boolean ls = dfs(root.left, p, q);
        boolean rs = dfs(root.right, p, q);
        if ((ls && rs) || ((root.val == p.val || root.val == q.val) && (ls || rs))){
            ans = root;
        }

        return ls || rs || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }
    */

    Map<Integer, TreeNode> parent = new HashMap<>(16);
    Set<Integer> visited = new HashSet<>(16);

    /**
     * dfs存储各个节点的父节点
     * @param root
     */
    public void dfs(TreeNode root){
        if (root.left != null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }

        if (root.right != null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        // 首先找出p的所有父节点
        while (p != null){
            visited.add(p.val);
            p = parent.get(p.val);
        }

        //再找q的父节点，第一个在visited中包含的节点就是p和q的最近公共祖先
        while (q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }

        return null;
    }

    /**
     * 递归解析：
     * 1. 终止条件：
     *      当越过叶节点，则直接返回 null ；
     *      当 root 等于 p, q，则直接返回 root ；
     * 2. 递推工作：
     *      开启递归左子节点，返回值记为 left ；
     *      开启递归右子节点，返回值记为 right ；
     * 3. 返回值： 根据 left 和 right ，可展开为四种情况；
     *      (1)当 left和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     *      (2)当 left和 right 同时不为空 ：说明 p, q分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     *      (3)当 left为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     *          i)  p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     *          ii) p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     *      (4)当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
     * @param root
     * @param p
     * @param q
     * @return TreeNode
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        TreeNode lcur = root.left;
        TreeNode rcur = root.right;
        lcur.left = new TreeNode(6);
        lcur.right = new TreeNode(2);
        TreeNode p = lcur.left;

        lcur = lcur.right;
        lcur.left = new TreeNode(7);
        lcur.right = new TreeNode(4);
        TreeNode q = lcur.right;

        rcur.left = new TreeNode(0);
        rcur.right = new TreeNode(8);

        LeetCode236 leetCode236 = new LeetCode236();
        int val = leetCode236.lowestCommonAncestor2(root, p, q).val;
        System.out.println(val);
    }
}
