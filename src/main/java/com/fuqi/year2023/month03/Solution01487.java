package com.fuqi.year2023.month03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2023/3/3 22:36
 * @description
 */
public class Solution01487 {
    public String[] getFolderNames(String[] names) {
        if (names.length == 1) {
            return names;
        }
        Map<String, Integer> nameCountMap = new HashMap<>(names.length);
        for (int i = 0; i < names.length; i++) {
            String curName = names[i];
            if (!nameCountMap.containsKey(curName)) {
                // 如果当前的名字并没有出现过
                nameCountMap.put(curName, 1);
                continue;
            }
            // 当前的名字出现过
            Integer count = nameCountMap.get(curName);
            String newName = addSuffix(curName, count);
            while (nameCountMap.containsKey(newName)) {
                count++;
                newName = addSuffix(curName, count);
            }
            names[i] = newName;
            nameCountMap.put(curName, count+1);
            nameCountMap.put(newName, 1);
        }

        return names;
    }

    private String addSuffix(String name, int count) {
        return name + String.format("(%s)", count);
    }

    public static void main(String[] args) {
        String[] names = new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        Solution01487 solution01487 = new Solution01487();
        System.out.println(Arrays.toString(solution01487.getFolderNames(names)));
    }
}
