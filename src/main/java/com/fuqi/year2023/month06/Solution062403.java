package com.fuqi.year2023.month06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 人气最高的店铺
 */
public class Solution062403 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nm = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] userVote = new int[nm[0]][2];
        // 记录每个店铺获取的初始意向票的用户成本
        Map<Integer, List<Integer>> shopVotes = new HashMap<>();
        for (int i = 0; i < nm[0]; i++) {
            int[] user = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            userVote[i] = user;
            shopVotes.computeIfAbsent(user[0], key -> new ArrayList<>()).add(user[1]);
        }
        in.close();
        List<int[]> sortedUserVote = Arrays.stream(userVote).sorted((user1, user2) -> {
            if (user1[1] == user2[1]) {
                return user1[0] - user2[0];
            }

            return user1[1] - user2[1];
        }).collect(Collectors.toList());
        for (List<Integer> votes : shopVotes.values()) {
            if (votes.size() == 0) continue;
            votes.sort(Comparator.naturalOrder());
        }
        System.out.println(minCostToWin(nm[0], nm[1], sortedUserVote, shopVotes));
    }

    public static long minCostToWin(int n, int m, List<int[]> sortedUserVote, Map<Integer, List<Integer>> shopVotes) {
        int winnerCount = 0, winnerShop = 0;
        int oneCount = shopVotes.getOrDefault(1, new ArrayList<>()).size();
        for (Map.Entry<Integer, List<Integer>> entry : shopVotes.entrySet()) {
            if (winnerCount < entry.getValue().size()) {
                winnerCount = entry.getValue().size();
                winnerShop = entry.getKey();
            }
        }
        if (winnerShop == 1) return 0L;
        long minCost = 0L;
        int i = 0;
        while (oneCount <= winnerCount) {
            int[] user = sortedUserVote.get(i);
            i++;
            if (user[0] == 1) {
                // 如果用户的初始意向店铺就是1号，则直接跳过
                continue;
            }
            oneCount++;
            if (user[0] == winnerShop) {
                // 如果用户的初始意向店铺是当前的票最高的店
                minCost += user[1];
                winnerCount--;
                shopVotes.get(winnerShop).removeIf(cost -> cost == user[1]);
                continue;
            }
            long cost1 = minCost + user[1];
            long cost2 = minCost + shopVotes.get(winnerShop).get(0);
            if (winnerCount-- < oneCount) {
                return cost2;
            }
            if (cost1 < cost2) {
                minCost = cost1;
            } else {
                minCost = cost2;
                winnerCount--;
                shopVotes.get(winnerShop).removeIf(cost -> cost == user[1]);
            }
        }

        return minCost;
    }
}
