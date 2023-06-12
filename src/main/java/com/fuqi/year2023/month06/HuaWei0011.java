package com.fuqi.year2023.month06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/12 23:45
 * @description
 */
public class HuaWei0011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] line1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] line2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] messages = new int[101];
        for (int i = 0; i < line1.length; i++) {
            messages[line1[i]] = line1[i+1];
            i++;
        }
        int[] consumers = new int[101];
        int no = 1;
        for (int i = 0; i < line2.length; i++) {
            int start = line2[i];
            i++;
            int end = line2[i];
            for (int j = start; j < end; j++) {
                consumers[j] = no;
            }
            no++;
        }
        consumeMessage(consumers, messages);

    }

    private static void consumeMessage(int[] consumers, int[] messages) {
        Map<Integer, List<Integer>> consumeMap = new TreeMap<>();
        for (int i = 0; i < consumers.length; i++) {
            if (consumers[i] == 0) continue;
            List<Integer> listened = consumeMap.computeIfAbsent(consumers[i], key -> new ArrayList<>());
            if (messages[i] == 0) continue;
            listened.add(messages[i]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : consumeMap.entrySet()) {
            if (entry.getValue().size() == 0) {
                System.out.println("-1");
            } else {
                String outputLine = entry.getValue().stream().map(String::valueOf).collect(Collectors.joining(" "));
                System.out.println(outputLine);
            }
        }
    }
}
