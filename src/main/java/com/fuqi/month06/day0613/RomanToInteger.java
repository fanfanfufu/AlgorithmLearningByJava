package com.fuqi.month06.day0613;

/**
 * @Description: 罗马数字转成整数
 * @Author 傅琦
 * @Date 2019/6/13 11:15
 * @Version V1.0
 */
public class RomanToInteger {
    private static int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;

                case 'V':
                    result += 5;
                    if (i != 0 && s.charAt(i - 1) == 'I') {
                        result -= 1;
                        i--;
                    }
                    break;

                case 'X':
                    result += 10;
                    if (i != 0 && s.charAt(i - 1) == 'I') {
                        result -= 1;
                        i--;
                    }
                    break;
                case 'L':
                    result += 50;
                    if (i != 0 && s.charAt(i - 1) == 'X') {
                        result -= 10;
                        i--;
                    }
                    break;
                case 'C':
                    result += 100;
                    if (i != 0 && s.charAt(i - 1) == 'X') {
                        result -= 10;
                        i--;
                    }
                    break;

                case 'D':
                    result += 500;
                    if (i != 0 && s.charAt(i - 1) == 'C') {
                        result -= 100;
                        i--;
                    }
                    break;

                case 'M':
                    result += 1000;
                    if (i != 0 && s.charAt(i - 1) == 'C') {
                        result -= 100;
                        i--;
                    }
                    break;

                default:
                    break;
            }
        }
        return result;
    }
}
