package com.fuqi.day0524;

/**
 * @Description: 序列化和反序列化二叉树
 * @Author 傅琦
 * @Date 2019/5/24 22:35
 * @Version V1.0
 */
public class TreeNodeSerialze {
    /**
     1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
    不为空时，在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
     2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树(特别注意：
    在递归时，递归函数的参数一定要是char ** ，这样才能保证每次递归后指向字符串的指针会
    随着递归的进行而移动！！！)
    */
    public String Serialize(TreeNode root){
        StringBuilder stringBuilder = new StringBuilder();
        if (root == null){
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }

        stringBuilder.append(root.val + ",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));
        return stringBuilder.toString();
    }

    private int index = -1;
    public TreeNode Deserialize(String str){
        index++;
        int len = str.length();
        if (index >= len){ return null; }

        String[] strings = str.split(",");
        TreeNode node = null;
        if (!"#".equals(strings[index])){
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
