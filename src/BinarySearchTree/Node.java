package BinarySearchTree;

public class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }

    Node() {
        data = 0;
        left = null;
        right = null;
    }

    void PreOrder() {
        System.out.print(data + "\n");
        if (left != null)
            left.PreOrder();
        if (right != null)
            right.PreOrder();

    }

    void InOrder() {
        if (left != null)
            left.InOrder();
        System.out.print(data + "\n");
        if (right != null)
            right.InOrder();
    }

    void PostOrder() {
        if (left != null)
            left.PostOrder();
        if (right != null)
            right.PostOrder();
        System.out.print(data + "\n");
    }

    void addNode(Node node) {

        if (node.data > data) {//  add right Node
            if (right == null)
                right = node;
            right.addNode(node);
        } else if (node.data < data) { // add left Node
            if (left == null)
                left = node;
            left.addNode(node);
        }
    }

    Node min(Node root_nd) {
        if (left == null)
            return this;
        return left.min(left);
    }
    Node max(Node root_nd) {
        if (right == null)
            return this;
        return right.max(right);
    }
    Node search(Node root_nd, int target) {
        if(root_nd.data == target)
            return root_nd;

        else if (target < root_nd.data){
            if (root_nd.left != null)
                return left.search(root_nd.left,target);
        }
        else if (target > root_nd.data){
            if (root_nd.right != null)
                return right.search(root_nd.right,target);
        }
        return null;

    }
    Node searchParent(Node root_nd, Node parent, int target) {
        if(data == target)
            return parent;

        if (target < root_nd.data){
            if (root_nd.left != null) {
                parent = this;
                return left.searchParent(left, parent, target);
            }
            else  return null;

        }
        else{
            if(root_nd.right != null) {
                parent = this;
                return right.searchParent(right, parent, target);
            }
            else return null;


        }
    }
    Node deleteNode(Node root_nd, Node parent, int target) {
        if (root_nd == null) return null;

        if (target == root_nd.data) {
            // DURUM 1: Yaprak Düğüm (Leaf Node)
            if (root_nd.left == null && root_nd.right == null) {
                if (parent != null) {
                    if (parent.left == root_nd) parent.left = null;
                    else if (parent.right == root_nd) parent.right = null;
                }
                return null; // Kök siliniyorsa null döner
            }
            else if (root_nd.left == null) {
                if (parent != null) {
                    if (parent.left == root_nd) parent.left = root_nd.right;
                    else parent.right = root_nd.right;
                }
                return root_nd.right;
            }

            else if (root_nd.right == null) {
                if (parent != null) {
                    if (parent.left == root_nd) parent.left = root_nd.left;
                    else parent.right = root_nd.left;
                }
                return root_nd.left;
            }
            else {
                // Sağ alt ağacın en küçüğünü bul (Successor)
                Node tempNode = root_nd.right.min(root_nd.right);
                int tempVal = tempNode.data;
                // Successor düğümünü fiziksel olarak sil
                deleteNode(root_nd.right, root_nd, tempVal);
                // Mevcut düğümün verisini successor verisiyle değiştir
                root_nd.data = tempVal;
            }
        }
        else if (target > root_nd.data) {
            if (root_nd.right != null)
                deleteNode(root_nd.right, root_nd, target);
        }
        else {
            if (root_nd.left != null)
                deleteNode(root_nd.left, root_nd, target);
        }
        return root_nd;
    }
}
