package com.fuqi.year2019.month08.DajiangB;

import java.util.*;

/**
 * @Description:
 *
 * 小B平时喜欢倒腾一些小东西，最近他准备给自己做的小机器人加入一套语音控制的功能，每个指令对应一个动作。
 * 由于语言转文字有很多现成的方案，所以小B打算直接复用这些方案，但是语音转成了文字之后，还需要将文字跟具体的动作对应起来。
 * 因此小B需要实现一个函数，将语音转换出来的文字，再转换成相应的动作。
 * 为了简单实现，小B将语音直接转成了拼音，然后把对应的动作也都起了名字，因此只要预先输入好两者的映射关系，然后输入语音指令就输出相应的动作。
 * 然而因为小B的函数有bug，机器人并不想听他的话...
 * 你能帮小B解决这个问题吗？
 *
 *
 * 输入包含多组测试数据，对于每组测试数据：
 * 第一行输入两个正整数，空格隔开，需要进 行映射的命令的数目N 和进行调试时发送的语音指令条数 M (1 < N < 1000, 1 < M < 1000)
 * 接下来N行，每行输入两个字符串表示语音指令和对应的动作cmd和action，以空格隔开，每个字符串的长度小于1000，且只有大小写字母
 * 最后M行，每行输入一个字符串表示需要进行调试的语音指令
 *
 * 对于每组测试数据：
 * 输出M行，根据调试的语音指令输出对应的动作指令action
 *
 * 4 4
 * ZuoZhuan TurnLeft
 * YouZhuan TurnRight
 * QianJin Forward
 * HouTui Backward
 * ZuoZhuan
 * QianJin
 * QianJin
 * HouTui
 * 1 1
 * SDFlkjdf LNCIls
 * SDFlkjdf
 *
 * TurnLeft
 * Forward
 * Forward
 * Backward
 * LNCIls
 *
 * @Author: 傅琦
 * @DateTime: 2019/8/6 19:50
 * @Version: V1.0
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            Map<String, String> map = new HashMap<>(16);
//            String numLine = scanner.nextLine();
//            String[] nums = numLine.split(" ");
//            int N = Integer.parseInt(nums[0]);
//            int M = Integer.parseInt(nums[1]);
//
//            for(int i = 0; i < N; i++){
//                String strLine = scanner.nextLine();
//                String[] strs = strLine.split(" ");
//                String cmd = strs[0];
//                String action = strs[1];
//
//                map.put(cmd, action);
//            }
//
//            List<String> list = new ArrayList<String>();
//            for(int i = 0; i < M; i++){
//                list.add(scanner.nextLine());
//            }
//            for(int i = 0; i < M; i++){
//                System.out.println(map.get(list.get(i)));
//            }
//        }
//        scanner.close();
        helper();
    }
    
    public static void helper(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Map<String, String> map = new HashMap<>(16);
            // 需要进行映射的命令的数目N
            int N = scanner.nextInt();
            // 进行调试时发送的语音指令条数M
            int M = scanner.nextInt();

            for (int i = 0; i < N; i++) {
                String cmd = scanner.next();
                String action = scanner.next();
                map.put(cmd, action);
            }

            List<String> list = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                list.add(scanner.next());
            }
            for (int i = 0; i < M; i++) {
                System.out.println(map.get(list.get(i)));
            }
        }
        scanner.close();
    }
}
