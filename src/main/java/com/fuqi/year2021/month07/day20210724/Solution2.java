package com.fuqi.year2021.month07.day20210724;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author FuQi
 */
public class Solution2 {
    public static int smallestChair(int[][] times, int targetFriend) {
        int arrive=times[targetFriend][0];
        Arrays.sort(times, Comparator.comparingInt(time -> time[0]));
        HashMap<Integer, Integer> map=new HashMap(16);
        int ans=0;
        for(int i=0;i<times.length;i++){
            if(times[i][0]>arrive) {
                break;
            }
            int av=times[i][0];
            if(map.size()==0) {
                map.put(0,times[i][1]);
                ans=0;
            }
            else{
                int mincurrent=map.size();
                for(Integer j:map.keySet()){
                    if(map.get(j)<=av){
                        mincurrent=Math.min(mincurrent,j);
                        map.put(j,-1);
                    }
                }
                ans=mincurrent;
                map.put(mincurrent,times[i][1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] times = new int[][]{
//                {33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063}
//                ,{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821}
//                ,{48548,48656},{87396,94825},{55273,81868},{75629,91467}
//        };

        int[][] times = new int[][] {{1,4},{2,3},{4,6}};
        int i = smallestChair(times, 2);
        System.out.println("i = " + i);
    }
}
