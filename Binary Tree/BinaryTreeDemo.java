import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	int index = -1;

	public Node buildTree(int nodes[]) {
		index++;
		if (nodes[index] == -1) {
			return null;
		}
		Node newnode = new Node(nodes[index]);
		newnode.left = buildTree(nodes);
		newnode.right = buildTree(nodes);
		return newnode;
	}

	public void preorder(Node root) {// root ,left,Right
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public void inorder(Node root) {// left, root,right
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);

	}

	public void postorder(Node root) {// left,right, root
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");

	}

	public void levelorder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node currentNode = q.remove();
			if (currentNode == null) {
				System.out.println();
				if (q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				System.out.print(currentNode.data + " ");
				if (currentNode.left != null) {
					q.add(currentNode.left);
				}
				if (currentNode.right != null) {
					q.add(currentNode.right);
				}
			}
		}
	}

	public int countnodes(Node root) {
		if (root == null) {
			return 0;
		}
		int leftNodes = countnodes(root.left);
		int rightNodes = countnodes(root.right);

		return leftNodes + rightNodes + 1;
	}

	public int sumnodes(Node root) {
		if (root == null) {
			return 0;
		}
		int leftSum = sumnodes(root.left);
		int rightSum= sumnodes(root.right);
		return leftSum + rightSum + root.data;
	}
	public int height(Node root) {
		if(root==null) {
			return 0;
		}
		int leftHeight=height(root.left);
		int rightHeight=height(root.right);
		int myheight=Math.max(leftHeight, rightHeight)+1;
		
		return myheight;
	}
	public int diameter(Node root) {
		if(root==null) {
			return 0;
		}
		int diam1=diameter(root.left);
		int diam2=diameter(root.right);
		int diam3=height(root.left)+height(root.left)+1;
		return Math.max(diam3,Math.max(diam1, diam2));
	}
}

public class BinaryTreeDemo {

	public static void main(String[] args) {
		int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(nodes);
//		System.out.println(root.data);
		System.out.println("Preorder traversal");
		tree.preorder(root);
		System.out.println();
		System.out.println("Inorder traversal");
		tree.inorder(root);
		System.out.println();
		System.out.println("Postorder traversal");
		tree.postorder(root);
		System.out.println();
		System.out.println("LevelOrder traversal");
		tree.levelorder(root);
		System.out.println("No of Nodes ");
		int count = tree.countnodes(root);
		System.out.println(count);
		System.out.println("No of Nodes ");
		int sum = tree.sumnodes(root);
		System.out.println(sum);
		System.out.println("Height of the tree ");
		int height = tree.height(root);
		System.out.println(height);
		System.out.println("Diameter of the tree ");
		int diameter = tree.diameter(root);
		System.out.println(diameter);
	}

}



/*
 *     1
 *    / \ 
 *   2   3
 *  / \   \ 
 * 4   5   6
 * 
 * 
 */
// timeComplexity
// O(N);

//timeComplexity for diameter
//0(N^2)
