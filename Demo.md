Sure! Here's a simplified version of the Binary Search Tree (BST) code with more comments and simpler structure to help slow learners understand it better:

```java
// Node class represents each node in the BST
class Node {
    int key; // The value of the node
    Node left, right; // References to the left and right child nodes

    // Constructor to create a new node
    public Node(int item) {
        key = item; // Assign the value to the node
        left = right = null; // Initialize left and right children as null
    }
}

// BinarySearchTree class represents the BST itself
class BinarySearchTree {
    Node root; // The root of the BST

    // Constructor to create an empty BST
    BinarySearchTree() {
        root = null;
    }

    // Method to insert a new key into the BST
    void insert(int key) {
        root = insertRec(root, key); // Call the recursive insert method
    }

    // Recursive method to insert a new key into the BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node and return it
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) // If the key is less than the root's key, insert in the left subtree
            root.left = insertRec(root.left, key);
        else if (key > root.key) // If the key is greater than the root's key, insert in the right subtree
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to print the BST in an inorder way (sorted order)
    void inorder() {
        inorderRec(root); // Call the recursive inorder method
    }

    // Recursive method to do an inorder traversal of the BST
    void inorderRec(Node root) {
        if (root != null) { // If the current node is not null
            inorderRec(root.left); // Traverse the left subtree
            System.out.print(root.key + " "); // Print the current node's key
            inorderRec(root.right); // Traverse the right subtree
        }
    }

    // Method to search for a key in the BST
    boolean search(int key) {
        return searchRec(root, key); // Call the recursive search method
    }

    // Recursive method to search for a key in the BST
    boolean searchRec(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key)
            return root != null;

        // Key is greater than root's key, search in the right subtree
        if (root.key < key)
            return searchRec(root.right, key);

        // Key is smaller than root's key, search in the left subtree
        return searchRec(root.left, key);
    }

    // Main method to test the BST implementation
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(); // Create a new BST

        // Insert keys into the BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print the BST in inorder (sorted order)
        tree.inorder();
        System.out.println(); // Print a new line

        // Search for keys in the BST and print the results
        System.out.println("Is 60 in the tree? " + tree.search(60)); // Should return true
        System.out.println("Is 25 in the tree? " + tree.search(25)); // Should return false
    }
}
```

### Explanation:

1. **Node Class**:
   - Represents each element (node) in the tree.
   - Each node has a `key` (value) and two children (`left` and `right`).

2. **BinarySearchTree Class**:
   - Represents the entire tree.
   - `root` is the starting point of the tree.

3. **Insert Method**:
   - Adds a new value to the tree.
   - Uses a helper method `insertRec` to find the correct spot for the new value.

4. **Inorder Method**:
   - Prints the tree's values in sorted order.
   - Uses a helper method `inorderRec` to recursively visit nodes.

5. **Search Method**:
   - Checks if a value exists in the tree.
   - Uses a helper method `searchRec` to search through nodes recursively.

6. **Main Method**:
   - Creates a tree and inserts some values.
   - Prints the tree in sorted order.
   - Searches for specific values and prints the results.