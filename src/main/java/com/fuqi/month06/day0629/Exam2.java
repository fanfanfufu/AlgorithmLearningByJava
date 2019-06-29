package com.fuqi.month06.day0629;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Description: 长度为 K 的无重复字符子串
 *
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 *
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *
 *
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/29 22:49
 * @Version: V1.0
 */
public class Exam2 {
    public static int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K){ return 0; }

        int i = 0;
        int count = 0;
        Queue<Character> queue = new ArrayBlockingQueue<>(K);
        while (i < S.length()){
            if (queue.size() < K){
                if (!queue.contains(S.charAt(i))){
                    queue.offer(S.charAt(i));
                }else {
                    while (queue.contains(S.charAt(i))){
                        queue.poll();
                    }
                    queue.offer(S.charAt(i));
                }

            }else {
                count++;
                if (!queue.contains(S.charAt(i))){
                    queue.poll();
                    queue.offer(S.charAt(i));
                }else {
                    while (queue.contains(S.charAt(i))){
                        queue.poll();
                    }
                    queue.offer(S.charAt(i));
                }
            }
            i++;
        }
        if (queue.size() == K){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String string = "home";
        int K = 5;
        int res = numKLenSubstrNoRepeats(string, K);
        System.out.println("res = " + res);
    }
}


