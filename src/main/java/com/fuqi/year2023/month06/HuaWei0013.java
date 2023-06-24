package com.fuqi.year2023.month06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/24 11:03
 * @description
 */
public class HuaWei0013 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineCount = Integer.parseInt(in.nextLine());
        Map<String, Set<String>> alterRelationMap = new HashMap<>();
        for (int i = 0; i < lineCount; i++) {
            String[] singleAlterRelation = in.nextLine().split(" ");
            alterRelationMap.computeIfAbsent(singleAlterRelation[1], key -> new HashSet<>()).add(singleAlterRelation[0]);
        }
        Set<String> alterInput = Arrays.stream(in.nextLine().split(" ")).collect(Collectors.toSet());
        in.close();
        List<String> alterOutput = new ArrayList<>();
        for (String alter : alterInput) {
            if (alterOutput.isEmpty()) {
                alterOutput.add(alter);
                continue;
            }
            // 如果当前告警已经出现过了，则直接跳过
            if (alterOutput.contains(alter)) continue;
            if (!alterRelationMap.containsKey(alter)) {
                alterOutput.add(alter);
                continue;
            }
            // 告警关系中有当前告警的可抑制告警数据
            Set<String> higherAlter = alterRelationMap.get(alter);
            boolean hasHigherAlter = false;
            for (String alReadyAlter : alterInput) {
                if (higherAlter.contains(alReadyAlter)) {
                    hasHigherAlter = true;
                    break;
                }
            }
            if (hasHigherAlter) continue;
            alterOutput.add(alter);
        }
        if (!alterOutput.isEmpty()) {
            System.out.println(String.join(" ", alterOutput));
        }
    }
}
