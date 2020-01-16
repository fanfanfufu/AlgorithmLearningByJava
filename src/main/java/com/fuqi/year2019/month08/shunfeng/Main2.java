package com.fuqi.year2019.month08.shunfeng;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/29 20:11
 * @Version V1.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int persons = in.nextInt();
        int languages = in.nextInt();
        int k = in.nextInt();

        Set<Integer> personSet = new HashSet<>();
        Set<Integer> languageSet = new HashSet<>();

        for (int i = 0; i < k; i++) {
            int person = in.nextInt();
            personSet.add(person);

            int language = in.nextInt();
            languageSet.add(language);
        }

        int ans = (persons-personSet.size()) + (languages - languageSet.size());
        System.out.println(ans);

        in.close();
    }
}
