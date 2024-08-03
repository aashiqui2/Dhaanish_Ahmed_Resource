class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node root;

    void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + "   ");
        inorder(root.right);
    }

    Node findMinimum(Node cur) {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    Node insertion(Node root, int item) {
        if (root == null)
            return new Node(item);

        if (item < root.data)
            root.left = insertion(root.left, item);
        else
            root.right = insertion(root.right, item);

        return root;
    }

    Node[] search(Node cur, int item) {
        Node parent = null;
        while (cur != null && cur.data != item) {
            parent = cur;
            if (item < cur.data)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return new Node[] { cur, parent };
    }

    void deletion(Node root, int item) {
        Node[] nodes = search(root, item);
        Node cur = nodes[0];
        Node parent = nodes[1]; 

        if (cur == null){
            System.out.println("hi");
            return;
        }

        if (cur.left == null && cur.right == null) {
            if (cur != root) {
                if (parent.left == cur)
                    parent.left = null;
                else
                    parent.right = null;
            } else
                this.root = null;

            cur = null;
        } else if (cur.left != null && cur.right != null) {
            Node succ = findMinimum(cur.right);
            int val = succ.data;
            deletion(root, succ.data);
            cur.data = val;
        } else {
            Node child = (cur.left != null) ? cur.left : cur.right;

            if (cur != root) {
                if (cur == parent.left)
                    parent.left = child;
                else
                    parent.right = child;
            } else
                this.root = child;

            cur = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Node root = null;
        root = b.insertion(root, 45);
        root = b.insertion(root, 19);
        root = b.insertion(root, 79);
        root = b.insertion(root, 90);
        root = b.insertion(root, 10);
        root = b.insertion(root, 55);
        root = b.insertion(root, 12);
        root = b.insertion(root, 20);
        root = b.insertion(root, 50);

        System.out.println("The inorder traversal of the given binary tree is - ");
        b.inorder(root);

        b.deletion(root, 50);
        System.out.println("\nAfter deleting node 25, the inorder traversal of the given binary tree is - ");
        b.inorder(root);

        root = b.insertion(root, 2);
        System.out.println("\nAfter inserting node 2, the inorder traversal of the given binary tree is - ");
        b.inorder(root);
    }
}
