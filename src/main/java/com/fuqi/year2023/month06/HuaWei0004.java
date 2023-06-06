package com.fuqi.year2023.month06;

import java.util.*;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/5 23:29
 * @description
 */
public class HuaWei0004 {
    public static class Student implements Comparable<Student> {
        String id;
        int score;

        public Student(String id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Student other) {
            return score != other.score ? Integer.compare(other.score, score) : id.compareTo(other.id);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String grade_one_str = in.nextLine();
        String grade_two_str = in.nextLine();

        Map<String, Integer> student_id_map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(grade_two_str, ";");
        while (st.hasMoreTokens()) {
            List<String> student_ids = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
            while (st2.hasMoreTokens()) {
                student_ids.add(st2.nextToken());
            }
            student_id_map.put(student_ids.get(0), Integer.parseInt(student_ids.get(1)));
        }

        Map<String, Set<Student>> student_map = new HashMap<>();
        st = new StringTokenizer(grade_one_str, ";");
        while (st.hasMoreTokens()) {
            List<String> student_ids = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
            while (st2.hasMoreTokens()) {
                student_ids.add(st2.nextToken());
            }
            String id = student_ids.get(0);
            if (student_id_map.containsKey(id)) {
                int totalScore = Integer.parseInt(student_ids.get(1)) + student_id_map.get(id);
                String temp = id.substring(0, 5);
                student_map.computeIfAbsent(temp, k -> new TreeSet<>()).add(new Student(id, totalScore));
            }
        }

        if (student_map.isEmpty()) {
            System.out.println("NULL");
        } else {
            for (Map.Entry<String, Set<Student>> entry : student_map.entrySet()) {
                System.out.println(entry.getKey());
                StringBuilder res = new StringBuilder();
                for (Student student : entry.getValue()) {
                    res.append(student.id).append(";");
                }
                System.out.println(res.substring(0, res.length() - 1));
            }
        }
        return;
    }
}
