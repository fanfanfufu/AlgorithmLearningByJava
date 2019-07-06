package com.fuqi.queuelearn;

/**
 * @Description: 用数组实现实现队列: 数组用一次就失效了
 * @Author 傅琦
 * @date 2019/7/6 10:04
 * @Version V1.0
 */
public class ArrayQueueDemo {
    /**
     * 测试自定义的队列
     */
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.addQueue(548);
        arrayQueue.addQueue(5005);
        arrayQueue.addQueue(333);
    }
}

/**
 * 用十足模拟一个队列
 */
class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;

    /**
     * 队列头指针
     */
    private int front;

    /**
     * 队列尾指针
     */
    private int rear;

    /**
     * 实际存放元素的数组
     */
    private int[] elements;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        elements = new int[maxSize];
        // 可理解成左开右闭
        // 队首指针，指向队列头的前一个位置。
        front = -1;
        // 指向队尾
        rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
        // 2. 若队列还有空间则添加数据，让rear指针后移一位
        rear++;
        // 3. 向数组的对应位置写入数据
        elements[rear] = n;
    }

    /**
     * 获取队列的数据
     * @return
     */
    public int getQueue() {
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 1. fornt后移
        front++;
        // 2. 取出对应位置的元素
        return elements[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            System.out.printf("elements[%d]=%d\n", i, elements[i]);
        }
    }

    /**
     * 显示队首数据
     */
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return elements[front+1];
    }
}
