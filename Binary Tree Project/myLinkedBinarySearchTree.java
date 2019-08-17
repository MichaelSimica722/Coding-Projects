package Lab3;
public class myLinkedBinarySearchTree<E extends Comparable<E>> {
	 protected BinaryNode<E> root = null;     // root of the tree
	
	  // constructor
	  public myLinkedBinarySearchTree() { }      // constructs an empty binary tree
	
	  protected BinaryNode<E> validate(BinaryNode<E> p) throws IllegalArgumentException {
		    if (!(p instanceof BinaryNode))
		      throw new IllegalArgumentException("Not valid BinaryNode type");
		    BinaryNode<E> node = (BinaryNode<E>) p;       // safe cast
		    if (getParent(node) == node)     // our convention for defunct node
		      throw new IllegalArgumentException("p is no longer in the tree");
		    return node;
		  }

	  public BinaryNode<E> root() {
		    return root;
		  }
 
		  public BinaryNode<E> left(BinaryNode<E> p) throws IllegalArgumentException {
			  BinaryNode<E> node = validate(p);
		    return node.getLeft();
		  }

		  public BinaryNode<E> right(BinaryNode<E> p) throws IllegalArgumentException {
			  BinaryNode<E> node = validate(p);
		    return node.getRight();
		  }

		  // update methods supported by this class
		  /**
		   * Places element e at the root of an empty tree and returns its new BinaryNode.
		   *
		   * @param e   the new element
		   * @return the BinaryNode of the new element
		   * @throws IllegalStateException if the tree is not empty
		   */
		  public BinaryNode<E> addRoot(E e) throws IllegalStateException {
		    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		    root = new BinaryNode(e, null, null);
		    return root;
		  }

		  private boolean isEmpty() {
			// TODO Auto-generated method stub
			  if(root ==null) return true;
			return false;
		}
		/**
		   * Creates a new left child of BinaryNode p storing element e and returns its BinaryNode.
		   *
		   * @param p   the BinaryNode to the left of which the new element is inserted
		   * @param e   the new element
		   * @return the BinaryNode of the new element
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
		   * @throws IllegalArgumentException if p already has a left child
		   */
		  public BinaryNode<E> addLeft(BinaryNode<E> p, E e)
		                          throws IllegalArgumentException {
			  BinaryNode<E> parent = validate(p);
		    if (parent.getLeft() != null)
		      throw new IllegalArgumentException("p already has a left child");
		    BinaryNode<E> child = new BinaryNode(e, null, null);
		    parent.setLeft(child);
		    return child;
		  }

		  /**
		   * Creates a new right child of BinaryNode p storing element e and returns its BinaryNode.
		   *
		   * @param p   the BinaryNode to the right of which the new element is inserted
		   * @param e   the new element
		   * @return the BinaryNode of the new element
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree.
		   * @throws IllegalArgumentException if p already has a right child
		   */
		  public BinaryNode<E> addRight(BinaryNode<E> p, E e)
		                          throws IllegalArgumentException {
			  BinaryNode<E> parent = validate(p);
		    if (parent.getRight() != null)
		      throw new IllegalArgumentException("p already has a right child");
		    BinaryNode<E> child = new BinaryNode(e, null, null);
		    parent.setRight(child);
		    return child;
		  }

		  /**
		   * Replaces the element at BinaryNode p with element e and returns the replaced element.
		   *
		   * @param p   the relevant BinaryNode
		   * @param e   the new element
		   * @return the replaced element
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree.
		   */
		  public E set(BinaryNode<E> p, E e) throws IllegalArgumentException {
			  BinaryNode<E> node = validate(p);
		    E temp = node.getElement();
		    node.setElement(e);
		    return temp;
		  }

		 
		  private boolean isInternal(BinaryNode<E> p) {
			  if(p.getLeft() !=null || p.getRight()!=null) 
				  return true;
			// TODO Auto-generated method stub
			return false;
		}
		 
		  
		  
		  
		  //************************************/
		  //LAB3 coding work starts here
		 //************************************/
		  public int size(BinaryNode<E> p){ //find and return the number of nodes on the tree
			 if(p =null)
			  return 0;
			 else
				 return(size(p.left) + 1 + size(p.right));
		  }
		  
		  public BinaryNode<E> getParent(BinaryNode<E> p, BinaryNode<E> curr) //find and return the parent node of p
		  {
			if(p==curr.left || p==curr.right)
				return curr; 
			if(p== null || p== root)
			  return null;
			if(curr.left != null)
				return getParent(curr.left, p);
			if(curr.right != null)
				return getParent(curr.right, p);
		  }
		  
		  private int numChildren(BinaryNode<E> p) {
				// TODO Auto-generated method stub
			  if(p ==null)
				return 0;
			  else
				  return 1 + numChildren(p.getLeft()) + numChildren(p.getRight());
		  }  
		  
		  public E remove(BinaryNode<E> p, E e) throws IllegalArgumentException {
				if(p == null)
					return p;
				int compareResult = e.compareTo(p.getElement());
				
				if(compareResult < 0 )
					p.left = remove(p.getLeft(), e);
				else if(compareResult > 0)
					p.right = remove(p.getRight(), e);
				else if(p.left != null && p.right != null)
				{
					p.setElement(findMin(p.getRight()));
					p.right = remove(p.getElement(), p.right);
				}
				else
					p= (p.left != null) ? p.left : p.right;
				return p;
		  }
		  
		  public Boolean search(BinaryNode<E> p, E e){// check if element e is on the tree or not
			  if( p == null )
				   return false;
				  
				   int compareResult = e.compareTo( p.getElement() );
				  
				   if( compareResult < 0 )
				   return search( e, p.getLeft() );
				   else if( compareResult > 0 )
				   return search( e, p.getRight() );
				   else
				   return true;
		  }
		 
		  public void insert(BinaryNode<E> p,  E e){//insert element e into the binary search tree, do nothing if found duplicate element
		  		if(p == null) {
		  			p = new BinaryNode<E>(e, null, null);}
		  		int compareResult = e.compareTo(p.getElement());
		  		
		  		if(compareResult <0)
		  			p.left = insert(p.left, e);
		  		else if(compareResult >0)
		  			p.right = insert(p.right, e);
		  		else
		  			; // dulplicate
		  	
		  }
		  
		
		  
		  public BinaryNode<E>  findMax(BinaryNode<E> p){//find and return the node contains the maximum element on a binary search tree rooted at p
			  if( p != null)
				  while( p.getRight() != null)
					  p=p.getRight();
			  return p;
		  }
		  
		  public Boolean isIdentical(BinaryNode<E> p, E e){
			  if(p == null && e ==null)
				  return true;
			  if(p != null && e != null) {
				  if(p.root != e.root) {
					  return false;
				  }
				  else if(p.getElement() != e.getElement()) {
					  return false;
				  }
				  else {
					  return true;
				  } 
			  }
			  
		  }
		  
		  public void printAncestors(BinaryNode<E> p, E e){
			 if(p == null)
				 return ;
			 if(printAncestors(p.left, e) || printAncestors(p.right, e)) {
				 System.out.print(p.getElement() + " ");
			 }
				 
			 
		  }
		  public ArrayList<E> inorderTraversal(BinaryNode<E> p){//find and return the inorder travesal for elements stored on the tree rooted at p
			  if(p == null)
				  return ;
			  inorderTraversal(p.left);
			  System.out.print(p.getElement() + " ");
			  inorderTraversal(p.right);
		  }
		  
		  
		  /////// added extra methods  //////////
		  
		  public BinaryNode<E> findMin(BinaryNode<E> p){
			  if(p == null)
				  return null;
			  else if(p.left == null)
				  return p;
			  return findMin(p.left);
		  }


}
