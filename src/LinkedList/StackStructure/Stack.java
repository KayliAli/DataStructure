package LinkedList.StackStructure;

import LinkedList.Eleman;

public class Stack {
    Eleman frist;
    Eleman last;

    public Stack() {
        frist = null;
        last = null;
    }
    boolean isEmpty() {
        return frist == null;
    }
    void printStack() {
        if(frist==null){ // liste empty
            return;
        }
        Eleman temp=frist;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.ileri;
        }
        System.out.println("------------------");
    }
    void push(Eleman eleman) {
        if(isEmpty()){
            frist = eleman;
            last = eleman;
            return;
        }
        // addFrist
        Eleman temp = frist;
        frist = eleman;
        eleman.ileri=temp;

    }
    Eleman pull(){
        if(isEmpty()) {
            System.out.println("Stack Empty");
            return null;
        }
        // removeFrist
        Eleman temp = frist;
        frist=frist.ileri;
        return temp;
    }

}
