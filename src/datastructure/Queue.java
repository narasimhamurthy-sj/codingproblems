package datastructure;

import java.util.Arrays;

/*
Follows the First-In-First-Out (FIFO) principle. This means that the first element added to the queue
will be the first one to be removed. It is analogous to a real-life queue, such as a line of people waiting
 to buy tickets: the first person in line is the first person to be served.

 circular queue:
 1,2,3,4,5



 */
public class Queue {

    static int queueMaxSize = 5;
    static int[] queueArray = new int[queueMaxSize];
    static int currentQueueSize = 0;
    static int startingIndex = 0;

    public static void enQueue(int data) {
        if (currentQueueSize < queueMaxSize) {
            queueArray[currentQueueSize] = data;
            currentQueueSize++;
        } else {
            System.err.println("Queue is full");
        }
    }

    public static void deQueue() {
        if (!(currentQueueSize < 1)) {
            queueArray[startingIndex] = -1;
            currentQueueSize--;
            if (startingIndex < queueArray.length) {
                startingIndex++;
            }
        } else {
            System.err.println("Queue is Empty");
        }

    }

    public static void printQueue() {
        Arrays.stream(queueArray).forEach(queueElement -> System.out.println(queueElement));
    }

    public static void main(String[] args) {

        for (int i = 1; i < 7; i++) {
            enQueue(i);
            ;

        }
        printQueue();


        deQueue();
        System.out.println("After delete:");
        printQueue();


    }

    public int peekElement() {
        if (queueArray.length != 0) {
            return queueArray[0];
        } else {
            System.err.println("Queue is empty");
            return -1;
        }
    }


}
