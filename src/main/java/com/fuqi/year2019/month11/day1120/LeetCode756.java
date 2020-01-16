package com.fuqi.year2019.month11.day1120;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: LeetCode第756题
 * @Author 傅琦
 * @date 2019/11/20 9:58
 * @Version V1.0
 */
public class LeetCode756 {
    /**
     * 思路：
     * 1.先将三元数组列表按前两位字符进行hash处理，第三位可以用二进制表示。
     * 这样可以将前两位相同的字符串的第三位用二进制表示的数字表示，从而组成对应hash映射
     * 2.再根据当前层获取下一层可能的组成的字符串，然后逐层递归处理，直到该层长度为1，则找到了结果返回true，
     * 否则获取下一个可能组成的字符串，继续上续处理，遍历完还没有结果则返回false
     */

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Integer> allowdNums = convert(allowed);
        return dealNextFloor(allowdNums, "", bottom, 0);
    }

    private String allowedString = "ABCDEFG";

    private boolean dealNextFloor(Map<String, Integer> allowedNums, String bottom, String origin, int k) {
        if (k == origin.length() - 1) {
            return origin.length() == 1 || dealNextFloor(allowedNums, "", bottom, 0);
        }

        String key = origin.substring(k, k+2);
        if (!allowedNums.containsKey(key)){
            return false;
        }
        int allowedNum = allowedNums.get(key);
        if (allowedNum > 0){
            for (int i = 0; i < 7; i++) {
                if ((allowedNum >> i & 1) == 1){
                    bottom += allowedString.charAt(i);
                    boolean flag = dealNextFloor(allowedNums, bottom, origin, k+1);
                    if (flag){ return true; }
                    bottom = bottom.substring(0, bottom.length() - 1);
                }
            }
        }

        return false;
    }

    private Map<String, Integer> convert(List<String> allowed) {
        int[] nums = {1,2,4,8,16,32,64};
        Map<String, Integer> map = new HashMap<>();
        for (String allow : allowed) {
            int c = nums[allow.charAt(2) - 'A'];
            String key = allow.substring(0,2);
            if (map.containsKey(key)){
                map.put(key, map.get(key) + c);
            }else {
                map.put(key, c);
            }
        }
        return map;
    }
}
