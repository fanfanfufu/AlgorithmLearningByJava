package com.fuqi.month06.day0618;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description: 找出S中所含的J中字符的个数
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 * @Author 傅琦
 * @Date 2019/6/18 10:53
 * @Version V1.0
 */
public class JewelsAndStones {
    /**
     * 时间复杂为O(n*n)
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 时间复杂度为O(n)
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i), 0);
        }

        for (Character character: S.toCharArray()) {
            if (map.containsKey(character)){
                map.put(character, map.get(character)+1);
            }
        }

        int count = 0;
        for (Integer num: map.values()) {
            count += num;
        }

        return count;
    }
}
