package com.fuqi.year2020.month05.day19;

/**
 * @Description: 验证回文字符串II
 * @Author 傅琦
 * @date 2020/5/19 9:39
 * @Version V1.0
 */
public class LeetCode660 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while (l < r){
            char c1 = s.charAt(l), c2 = s.charAt(r);
            if (c1 == c2){
                l++;
                r--;
            }else {
                boolean flag1 = true, flag2 = true;
                // 去除右边的字符，判断内部是否有回文串
                for (int i = l, j = r-1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4){
                        flag1 = false;
                        break;
                    }
                }
                // 去除左边的字符后判断是否回文
                for (int i = l+1, j = r; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4){
                        flag2 = false;
                        break;
                    }
                }

                return flag1 || flag2;
            }
        }
        return true;
    }
}
