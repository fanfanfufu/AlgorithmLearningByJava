package com.fuqi.year2022.month01;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author FuQi
 * @date 2022/1/21 22:55
 * @description
 */
public class Solution00146 {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > this.capacity;
        }
    }
}
