package com.fuqi.year2024.month07;

import java.util.*;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/7/15 22:25
 * @description
 */
public class Solution00721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(j), key -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[size];
        Set<String> emailSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if (visited[i]) continue;
            emailSet.clear();
            dfs(i, accounts, emailToIdx, visited, emailSet);

            List<String> res = new ArrayList<>(emailSet);
            Collections.sort(res);
            res.add(0, accounts.get(i).get(0));

            ans.add(res);
        }

        return ans;
    }

    private void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] visited, Set<String> emailSet) {
        visited[i] = true;
        for (int j = 1; j < accounts.get(i).size(); j++) {
            String email = accounts.get(i).get(j);
            if (emailSet.contains(email)) continue;
            emailSet.add(email);
            for (int index : emailToIdx.get(email)) {
                if (!visited[index]) {
                    dfs(index, accounts, emailToIdx, visited, emailSet);
                }
            }
        }
    }
}
