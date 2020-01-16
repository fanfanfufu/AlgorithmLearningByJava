package com.fuqi.year2020.month01.day16;

/**
 * @Description:
 * @Author 傅琦
 * @date 2020/1/16 10:57
 * @Version V1.0
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int a = 1;
        int b = 2;
        int c = 3;
        int res = solution2.minFlips(a, b, c);
        System.out.println(res);
    }

    public int minFlips(int a, int b, int c) {
        int d = a | b;
        String sa = Integer.toBinaryString(a);
        String sb = Integer.toBinaryString(b);
        String sc = Integer.toBinaryString(c);
        String sd = Integer.toBinaryString(d);

        int len1 = sa.length()-1;
        int len2 = sb.length()-1;
        int len3 = sc.length()-1;
        int len4 = sd.length()-1;

        int ans = 0;
        while (len3 >= 0 || len4 >= 0){
            if (len1 < 0 || len2 < 0 || len3 < 0 || len4 < 0){
                break;
            }
            if (sc.charAt(len3) == '1' && sd.charAt(len4) == '0'){
                ans += 1;
            }else if (sc.charAt(len3) == '0' && sd.charAt(len4) == '1'){
                if (sa.charAt(len1) == sb.charAt(len2)){
                    ans += 2;
                }else {
                    ans += 1;
                }
            }
            len1--;
            len2--;
            len3--;
            len4--;
        }

        return ans;
    }
}
