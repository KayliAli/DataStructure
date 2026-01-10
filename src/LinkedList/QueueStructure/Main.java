package LinkedList.QueueStructure;

import LinkedList.Eleman;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(new Eleman(10));
        queue.push(new Eleman(20));
        queue.push(new Eleman(30));
        queue.push(new Eleman(40));
        queue.push(new Eleman(50));
        queue.printQueue();
        queue.pull();

        queue.printQueue();
    }
}
