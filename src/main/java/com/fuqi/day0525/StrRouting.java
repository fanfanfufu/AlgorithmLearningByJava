package com.fuqi.day0525;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/25 17:22
 * @Version V1.0
 */
public class StrRouting {
    public static void main(String[] args){
        // "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEM"
        String string = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        char[] matrix = string.toCharArray();
        int row = 5, col = 8;
        String path = "SGGFIECVAASABCEHJIGQEM";
        char[] str = path.toCharArray();
        StrRouting strRouting = new StrRouting();
        boolean result = strRouting.hasPath(matrix, row, col, str);
        System.out.println(result);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if(helper(matrix, rows, cols, str, i, j, 0, flag)){return true;}
            }
        }

        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, char[] str, int i, int j, int k, boolean[] flag){
        // 先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]){
            return false;
        }

        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k == str.length - 1){return true;}

        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(helper(matrix, rows, cols, str, i-1, j, k+1, flag)
                || helper(matrix, rows, cols, str, i+1, j, k+1, flag)
                || helper(matrix, rows, cols, str, i, j-1, k+1, flag)
                || helper(matrix, rows, cols, str, i, j+1, k+1, flag)){
            return true;
        }
        // 走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }
}
