package LinkedList;

public class Main {
//     -----------------Linked List Methods------------------
//    printList()
//    addFrist(HashTable.Eleman e)
//    addLast(HashTable.Eleman e)
//    addBefore(HashTable.Eleman target,HashTable.Eleman yeni)
//    search(int target)
//    removeFrist()
//    removeLast()
//    clonList(linkedList ll)

    public static void main(String[] args) {
        // Create new "HashTable.Eleman"
        Eleman e1=new Eleman(5);
        Eleman e2=new Eleman(10);
        Eleman e3=new Eleman();
        Eleman e4=new Eleman(9);
        Eleman e5=new Eleman(100);
        Eleman e6=new Eleman(15);
        // create new linkedList
        linkedList ll=new linkedList();
        // linked list to add 'HashTable.Eleman'
        ll.addLast(e1);
        ll.addLast(e2);
        ll.addLast(e3);
        ll.addLast(e4);
        ll.addLast(e5);

        ll.addBefore(e1,e6);
        ll.printList();
        // Search within linked list.
        System.out.println(ll.search(15));
        // linked list in remove
        ll.removeFirst();
        ll.removeLast();
        ll.printList();

        // Linked list cloning
        linkedList clon = ll.clonList(ll);
        clon.printList(); // print linked list

    }
}
