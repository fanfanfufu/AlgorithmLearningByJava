package com.fuqi.year2021.month11.day20211113;

/**
 * @author FuQi
 * @date 2021/11/13 23:00
 * @description
 */
public class Robot {
    private int width;

    private int height;

    private String dir;

    private int curX;

    private int curY;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.dir = "East";
    }

    public void move(int num) {
        num = num % (2 * (this.width-1+this.height-1));
        if (num == 0) {
            changeDir();
        }
        // while循环
        while (num > 0) {
            // 计算在当前方向中可移动的距离上限
            int dirDistance = getDirDistance();
            if (num <= dirDistance) {
                // 如果移动距离小于当前方向可移动距离上限
                doMoveNotChangeDirect(num);
                num = 0;
                continue;
            }
            // 如果移动距离大于当前方向可移动距离上限
            num = doMoveMaxDirDistance(num, dirDistance);
        }
    }

    private void changeDir() {
        if (this.curX == 0 && this.curY == 0) {
            this.dir = "South";
        } else if (this.curX == this.width-1 && this.curY == 0) {
            this.dir = "East";
        } else if (this.curX == this.width-1 && this.curY == this.height-1) {
            this.dir = "North";
        } else if (this.curX == 0 && this.curY == this.height-1){
            this.dir = "West";
        }
    }

    private int doMoveMaxDirDistance(int num, int dirDistance) {
        switch (this.dir) {
            case "East":
                this.curX = width-1;
                this.dir = "North";
                break;
            case "North":
                this.curY = height-1;
                this.dir = "West";
                break;
            case "West":
                this.curX = 0;
                this.dir = "South";
                break;
            case "South":
                this.curY = 0;
                this.dir = "East";
                break;
            default:
        }

        return num-dirDistance;
    }

    private int getDirDistance() {
        int dirDis;
        if ("East".equals(this.dir)) {
            dirDis = width-1-curX;
        } else if ("North".equals(this.dir)) {
            dirDis = height-1-curY;
        } else if ("West".equals(this.dir)) {
            dirDis = curX;
        } else {
            dirDis = curY;
        }

        return dirDis;
    }

    private void doMoveNotChangeDirect(int num) {
        if ("East".equals(this.dir)) {
            this.curX += num;
        } else if ("North".equals(this.dir)) {
            this.curY += num;
        } else if ("West".equals(this.dir)) {
            this.curX -= num;
        } else {
            this.curY -= num;
        }
    }

    public int[] getPos() {
        return new int[]{curX, curY};
    }

    public String getDir() {
        return this.dir;
    }

    public static void main(String[] args) {
        Robot robot = new Robot(4,5);
        robot.move(44);
        robot.move(19);
        robot.move(8);
        robot.move(36);
        String dir = robot.getDir();
        System.out.println("dir = " + dir);
        int[] pos = robot.getPos();
        System.out.println(pos[0] + "," + pos[1] );
        robot.move(17);
        robot.move(49);
        robot.move(14);
        robot.move(40);
        dir = robot.getDir();
        System.out.println("dir = " + dir);
        pos = robot.getPos();
        System.out.println(pos[0] + "," + pos[1] );
        robot.move(18);
        robot.move(7);
        dir = robot.getDir();
        System.out.println("dir = " + dir);
        pos = robot.getPos();
        System.out.println(pos[0] + "," + pos[1] );
        robot.move(8);
        robot.move(5);
        robot.move(2);
        robot.move(36);
        robot.move(32);
        dir = robot.getDir();
        System.out.println("dir = " + dir);
        pos = robot.getPos();
        System.out.println(pos[0] + "," + pos[1] );
        System.out.println();
    }
}
