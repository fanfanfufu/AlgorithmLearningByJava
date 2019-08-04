package com.fuqi.month08.day0804;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/8/4 11:27
 * @Version: V1.0
 */
public class SnapshotArray {
    int[] element;
    int snapCount = 0;
    List<int[]> record;

    public SnapshotArray(int length) {
        element = new int[length];
    }

    public void set(int index, int val) {
        element[index] = val;
    }

    public int snap() {
        int res = snapCount;
        snapCount++;
        if (record == null){
            record = new ArrayList<>();
        }
        int[] temp = new int[element.length];
        System.arraycopy(element, 0, temp, 0, element.length);
        record.add(temp);
        return res;
    }

    public int get(int index, int snap_id) {
        return record.get(snap_id)[index];
    }
}
