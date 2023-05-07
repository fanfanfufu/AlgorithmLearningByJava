package com.fuqi.year2023.month05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/7 11:26
 * @description
 */
public class Solution06417 {
    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
        System.out.println(frequencyTracker.hasFrequency(1));
        frequencyTracker.add(3);
        System.out.println(frequencyTracker.hasFrequency(1));
        System.out.println(frequencyTracker.hasFrequency(1));
        frequencyTracker.add(6);
        frequencyTracker.add(2);
        frequencyTracker.add(6);
        frequencyTracker.deleteOne(6);
        frequencyTracker.deleteOne(6);
        System.out.println(frequencyTracker.hasFrequency(2));
        frequencyTracker.add(2);
        System.out.println(frequencyTracker.hasFrequency(2));
        System.out.println(frequencyTracker.hasFrequency(1));
    }
}

class FrequencyTracker {
    /**
     * 记录数字的出现次数的map
     */
    private Map<Integer, Integer> numberCount;

    /**
     * 记录出现次数对应的数字个数的map
     */
    private Map<Integer, Integer> frequency;

    public FrequencyTracker() {
        this.numberCount = new HashMap<>();
        this.frequency = new HashMap<>();
    }

    public void add(int number) {
        Integer oldFrequency = this.numberCount.getOrDefault(number, 0);
        int newFrequency = oldFrequency + 1;
        this.numberCount.put(number, newFrequency);
        // 获取旧的频次的数字个数
        Integer oldFrequencyNumbers = this.frequency.getOrDefault(oldFrequency, 0);
        // 获取新的频次的数字个数
        Integer newFrequencyNumbers = this.frequency.getOrDefault(newFrequency, 0);
        // 更新新频次对应的数字个数
        this.frequency.put(newFrequency, newFrequencyNumbers+1);
        if (oldFrequency == 0) {
            // 如果旧的频次为0，说明number是一个新的数字，则不需要对旧的频次的数字个数进行操作
            return;
        }
        // 更新旧的频次的数字个数
        this.frequency.put(oldFrequency, oldFrequencyNumbers-1);
    }

    public void deleteOne(int number) {
        // 如果number并不存在，直接不用操作
        if (!this.numberCount.containsKey(number)) {
            return;
        }
        // 先获取number的次数
        Integer oldFrequency = this.numberCount.get(number);
        int newFrequency = oldFrequency - 1;
        // 获取旧的频次的数字个数
        Integer oldFrequencyNumbers = this.frequency.getOrDefault(oldFrequency, 0);
        // 更新旧的频次的数字个数
        this.frequency.put(oldFrequency, oldFrequencyNumbers-1);
        if (oldFrequency == 1) {
            // 如果number只有一个，直接移除number的频次统计
            this.numberCount.remove(number);
            return;
        }
        // 将number的出现频次更新
        this.numberCount.put(number, newFrequency);
        // 获取新的频次的数字个数
        Integer newFrequencyNumbers = this.frequency.getOrDefault(newFrequency, 0);
        // 更新新的频次的数字个数
        this.frequency.put(newFrequency, newFrequencyNumbers+1);
    }

    public boolean hasFrequency(int frequency) {
        return this.frequency.getOrDefault(frequency, 0) > 0;
    }
}
