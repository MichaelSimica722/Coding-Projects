
public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		myLinkedBinarySearchTree<Integer> mtree = new myLinkedBinarySearchTree<Integer>();
		mtree.addroot(8);
		BinaryNode<Integer> left = mtree.addLeft(mtree.root, 5);
		left = mtree.addLeft(left, 3);
		BinaryNode<Integer> p=mtree.addLeft(left, 1);
		mtree.addRight(left, 4);
		
		Arraylist<Integer> inorderList= new Arraylist<Integer>();
		
		inorderList= inorderTraversal(mtree.root);
		
		myLinkedBinarySearchTree<Integer> anotherTree = mtree;
	}

}
