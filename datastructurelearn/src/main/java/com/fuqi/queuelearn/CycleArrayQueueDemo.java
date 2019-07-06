package com.fuqi.queuelearn;

/**
 * @Description: 循环数组创建队列
 * @Author 傅琦
 * @date 2019/7/6 11:09
 * @Version V1.0
 */
public class CycleArrayQueueDemo {
}

class CycleArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头指针: 指向第一个元素
     */
    private int front;

    /**
     * 队列尾指针: 指向队尾元素
     */
    private int rear;

    /**
     * 实际存放元素的数组
     */
    private int[] elements;

    public CycleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[this.maxSize];
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 往队列中添加元素
     * @param n
     */
    public void addQueue(int n){
        // 1. 首先判断队列是否已满
        if (isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        elements[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取队列的数据
     * @return
     */
    public int getQueue() {
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 1. 先把front对应的值保留到临时变量中
        int value = elements[front];
        // 2. 将front后移
        front = (front + 1) % maxSize;
        // 3. 返回临时变量的值
        return value;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("elements[%d]=%d\n", (i % maxSize), elements[i]);
        }
    }

    /**
     * 求出当前队列的有效数据
     */
    public int size(){
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 显示队首数据
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return elements[front];
    }
}
