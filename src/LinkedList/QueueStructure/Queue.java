package LinkedList.QueueStructure;

import LinkedList.Eleman;

public class Queue {
    Eleman frist;
    Eleman last;

    Queue() {
        frist=null;
        last=null;

    }
    void printQueue(){
        if(frist==null){
            System.out.println("Queue is Empty");
            return;
        }
        Eleman temp=frist;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.ileri;

        }
        System.out.println("-------------------------");

    }
    void push(Eleman eleman){
        if(frist==null){
            frist=eleman;
            last=eleman;
            return;
        }
        Eleman temp=frist;
        frist=eleman;
        eleman.ileri=temp;
    }
    Eleman pull(){
        if(frist==null){
            System.out.println("Queue is Empty");
            return null;
        }
        Eleman temp=frist;
        while(temp!=last){
            if(temp.ileri.ileri==null){
                Eleman e =temp.ileri;
                last=temp;
                temp.ileri=null;
                return e;

            }
            temp=temp.ileri;
        }
        return temp;

    }

}
