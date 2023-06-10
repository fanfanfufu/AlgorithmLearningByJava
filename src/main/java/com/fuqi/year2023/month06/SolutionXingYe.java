package com.fuqi.year2023.month06;

public class SolutionXingYe {
    private String[] table = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    public String numToString (int intValue) {
        // write code here
        if (intValue < 10) return String.valueOf(intValue);
        if (intValue < 36) return table[intValue];
        StringBuilder sb = new StringBuilder();
        while (intValue >= 36) {
            int mod = intValue % 36;
            sb.append(table[mod]);
            intValue /= 36;
        }
        sb.append(table[intValue]);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        SolutionXingYe solutionXingYe = new SolutionXingYe();
        int value = 80;
        System.out.println(solutionXingYe.numToString(80));
    }
}
