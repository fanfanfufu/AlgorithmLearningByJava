package com.fuqi.year2022.month02;

import java.util.*;

/**
 * @author FuQi
 * @date 2022/2/15 22:11
 * @description
 */
public class Solution00090 {
    Deque<Integer> stack = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        
        return ans;
    }

    private void dfs(boolean choosePre, int i, int[] nums) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        dfs(false, i+1, nums);
        if (!choosePre && i > 0 && nums[i-1] == nums[i]) {
            return;
        }
        stack.offerLast(nums[i]);
        dfs(true, i+1, nums);
        stack.pollLast();
    }
}
