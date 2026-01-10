package LinkedList.StackStructure;

import LinkedList.Eleman;

public class Main {
    public static void main(String[] args) {
        Stack stack=new Stack();

        stack.push(new Eleman(5));
        stack.push(new Eleman(6));
        stack.push(new Eleman(7));
        stack.push(new Eleman(8));
        stack.printStack();
        stack.pull();
        stack.pull();
        stack.pull();
        stack.printStack();
    }
}
