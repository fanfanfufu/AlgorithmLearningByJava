package com.fuqi.month08.beike;

import java.util.*;

/**
 * @Description: 举重大赛
 * @Author 傅琦
 * @date 2019/8/10 18:57
 * @Version V1.0
 */
public class Main3 {

    private static long helper(int[] arr){

        int ans = 0;

        if (arr.length < 2){
            return ans;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] >= (0.9 * arr[j])){
                    ans++;
                }else {
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] players = new int[N];
        for (int i = 0; i < N; i++) {
            players[i] = scanner.nextInt();
        }

        Arrays.sort(players);

        System.out.println(helper(players));

//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt(), res = 0;
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < len; i++) {
//            list.add(sc.nextInt());
//        }
//        Collections.sort(list, Collections.reverseOrder());
//        for(int i = 0; i < len; i++){
//            for(int j = i + 1; j < len; j++){
//                if(list.get(j) >= (list.get(i) * 0.9)) {
//                    res ++;
//                } else {
//                    break;
//                }
//            }
//        }
//        System.out.println(res);
    }
}
