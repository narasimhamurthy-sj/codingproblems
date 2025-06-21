package datastructure;

/*
A priority queue is an abstract data type similar to a regular queue but with an added feature: each element has an
associated priority. Elements are processed based on their priority rather than the order they were added to the queue.
This makes priority queues particularly useful in scenarios where certain tasks or elements need to be processed before others
 based on their importance or urgency.
 */
public class PriorityQueueUsingLinkedList {

    static NodeWithPriority head = null;
    static NodeWithPriority tail = null;
    static int queueSize = 0;

    public static void enQueue(NodeWithPriority newNode) {

        NodeWithPriority currentNode = null;
        NodeWithPriority previousNode = null;
        boolean isNewNodePriorityLesserThanExistingNodes = false;
        queueSize++;
        if (head == null) {
            head = tail = newNode;
            return;
        } else {
            currentNode = head;
            while (currentNode != null) {
                if (newNode.priority <= currentNode.priority) {
                    isNewNodePriorityLesserThanExistingNodes = true;

                    if (currentNode == head) {
                        previousNode = head;
                        head = newNode;
                        head.link = previousNode;
                    } else {
                        previousNode.link = newNode;
                        newNode.link = currentNode;

                    }
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.link;
            }
            if (!isNewNodePriorityLesserThanExistingNodes) {
                previousNode.link = newNode;
            }
        }

    }

    public static void printQueue() {
        NodeWithPriority currentNode = head;
        if (head == null) {
            System.out.println("Nothing to print, empty Queue");
            return;
        }
        System.out.println("Printing Queue........");
        while (currentNode != null) {
            System.out.println("data:" + currentNode.data + "  Priority:" + currentNode.priority);
            currentNode = currentNode.link;
        }

    }

    public static void deQueue() {
        if (head == null) {
            System.out.println("Empty queue,can't delete");
            return;
        }
        System.out.println("Deleted node:" + head.data + " Priority:" + head.priority);
        NodeWithPriority tempNode = head.link;
        head.link = null;
        head = tempNode;
        queueSize--;
    }

    public static void main(String[] args) {

        // new NodeWithPriority(10,2);
        enQueue(new PriorityQueueUsingLinkedList.NodeWithPriority(10, 3));
        enQueue(new PriorityQueueUsingLinkedList.NodeWithPriority(20, 2));
        enQueue(new PriorityQueueUsingLinkedList.NodeWithPriority(30, 1));

        System.out.println("queueSize:" + queueSize);

        printQueue();
        deQueue();
        printQueue();
        deQueue();
        printQueue();
        deQueue();
        System.out.println("queueSize:" + queueSize);
        printQueue();
        enQueue(new PriorityQueueUsingLinkedList.NodeWithPriority(30, 1));
        enQueue(new PriorityQueueUsingLinkedList.NodeWithPriority(20, 1));

        System.out.println("queueSize:" + queueSize);
        printQueue();
        deQueue();
        System.out.println("queueSize:" + queueSize);
        printQueue();

    }

    static class NodeWithPriority {
        int data;
        int priority;
        NodeWithPriority link;

        NodeWithPriority(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.link = null;
        }

    }
}
