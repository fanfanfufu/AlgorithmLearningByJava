package com.fuqi.year2019.month11.day1108;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 第638题，大礼包
 * @Author 傅琦
 * @date 2019/11/8 10:50
 * @Version V1.0
 */
public class LeetCode638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 统计不使用
        int noSpecial = 0;
        for (int i = 0; i < needs.size(); i++) {
            noSpecial += price.get(i) * needs.get(i);
        }
        int res = noSpecial;
        // 遍历每一个大礼包
        for (List<Integer> sp: special){
            // 当前大礼包超过购买数量时，则跳过
            if (check(sp, needs)){
                List<Integer> newNeeds = new ArrayList<>();
                for (int i = 0; i < sp.size() - 1; i++) {
                    newNeeds.add(needs.get(i) - sp.get(i));
                }

                // 剩下的购买数量递归调用本方法，获取最低价格
                int left = shoppingOffers(price, special, newNeeds);
                // 使用当前大礼包和不使用相比，选价格最低的
                res = Math.min(res, left + sp.get(sp.size() - 1));
            }
        }
        return res;
    }

    /**
     * 检查大礼包中对应礼品的个数是否超过需求数
     * @param special
     * @param needs
     * @return
     */
    private boolean check(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (special.get(i) > needs.get(i)){
                return false;
            }
        }
        return true;
    }
}
