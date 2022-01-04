package com.fuqi.year2022.month01;

import java.time.LocalDate;

/**
 * @author FuQi
 * @date 2022/1/4 22:45
 * @description 一周中的第几天，给定三个数：
 * day表示处于当月的第x天
 * month表示处于当年的第y月
 * year表示年
 *
 * 此题可作为LocalDate工具类的使用练习题
 */
public class Solution01185 {
    public static String dayOfTheWeek(int day, int month, int year) {
        String[] weekDayArr = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        LocalDate date = LocalDate.of(year, month, day);
        return weekDayArr[date.getDayOfWeek().getValue()-1];
    }

    /**
     * 基姆拉尔森计算公式
     * D= year + [year/4] - [year/100] + [year/400] + 2month + [3(month+1)/5] + day + 1
     * D % 7即可得到属于一周的第几天
     *
     * 说明：
     * y 是年份。
     *
     * m 是月份。m 的取值范围是 3 至 14，因为某年的 1、2 月要看作上一年的 13、14月，比如 2019 年的 1 月 1 日要看作 2018 年的 13 月 1 日来计算。
     *
     * d 是该月第几天。
     *
     * [] 代表对计算结果向下取整，只保留整数部分。
     *
     * W = D%7 是结果，代表一周中第几天, 0 为周日
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dayOfTheWeek1(int day, int month, int year) {
        String[] week = {  "Sunday" ,"Monday" , "Tuesday" , "Wednesday" , "Thursday" , "Friday" , "Saturday" } ;
        if (month < 3) {
            month += 12;
            --year;
        }
        int dayOfWeek = (1+day+(3 * (month+1)/5) + (2 * month) + (year/400) - (year/100) + (year/4) + year) % 7;
        return week[dayOfWeek];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31,8,2019));
        System.out.println(dayOfTheWeek1(18,7,1999));
    }
}
