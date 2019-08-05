package com.fuqi.month08.day0804;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/8/4 11:27
 * @Version: V1.0
 */
public class SnapshotArray {
    private int count;
    private List<TreeMap<Integer, Integer>> shot = new ArrayList<>();

    public SnapshotArray(int length) {
        IntStream.range(0, length).forEach(i -> {
            shot.add(new TreeMap<>());
        });
    }

    public void set(int index, int val) {
        shot.get(index).put(count, val);
    }

    public int snap() {
        return count++;
    }

    public int get(int index, int snap_id) {
        Integer key = shot.get(index).floorKey(snap_id);
        return key == null ? 0 : shot.get(index).get(key);
    }
}
