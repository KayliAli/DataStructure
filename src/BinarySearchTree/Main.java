package BinarySearchTree;

public class Main {
    public static void main(String[] args) {

        // add root
        Node root = new Node(14);
        root.addNode(new Node(10));
        root.addNode(new Node(6));
        root.addNode(new Node(13));
        root.addNode(new Node(21));
        root.addNode(new Node(18));
        root.addNode(new Node(40));
        root.addNode(new Node(34));


        root.InOrder();
        System.out.println("--------------------");
        root.PostOrder();
        System.out.println("--------------------");
        root.PreOrder();

        System.out.println("Min:"+root.min(root).data);
        System.out.println("Max:"+root.max(root).data);

        int target = 34;
        System.out.println(root.search(root, target));

        System.out.println(root.searchParent(root,root,target));

        root.deleteNode(root,root ,10);
        root.InOrder();
    }
}
