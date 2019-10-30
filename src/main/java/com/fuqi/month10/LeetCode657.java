package com.fuqi.month10;

/**
 * @Description: LeetCode第657题，easy级别的
 * @Author 傅琦
 * @date 2019/10/30 16:50
 * @Version V1.0
 */
public class LeetCode657 {
    public boolean judgeCircle(String moves) {
        int[] coordinate = new int[2];

        char[] movess = moves.toCharArray();
        for (char move : movess) {
            switch (move){
                case 'U':
                    coordinate[1] += 1;
                    continue;
                case 'D':
                    coordinate[1] -= 1;
                    continue;
                case 'L':
                    coordinate[0] -= 1;
                    continue;
                case 'R':
                    coordinate[0] += 1;
                    continue;
                default:
                    continue;
            }
        }

        return coordinate[0] == 0 && coordinate[1] == 0;
    }
}
