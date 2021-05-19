//Loryn Duncombe (ld3dx) Homework 7
//used slides for assistance
//TA instruction
public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}



	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false; // o is null return false
		}
		if ( o instanceof BinaryTree) {
			BinaryTree <?> c = (BinaryTree<?>) o; // casting o to a binary tree named c
			if(this.root != null) //checking to see if this root is null
				if (this.root.equals(c.root)) // comparing
					return true;// returns true if all true
		}
		return false; // returns false if all false 
	}


	public BinaryTree<T> deepCopy() {
		//copies tree into a variable called copiedTree
		BinaryTree<T> copiedTree= new BinaryTree<T>();

		if (root==null)
			return null;
		else {
			copiedTree.setRoot(root.deepCopy()); 
		}
		return copiedTree; //returns the copiedTree
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,
			boolean left) {
		BinaryTree<T> combinedTree = new BinaryTree<T>();
		combinedTree.setRoot(newRoot.deepCopy());
		if (left == true) {
			//default
			combinedTree.getRoot().setLeft(this.getRoot().deepCopy());
			combinedTree.getRoot().setRight(t.getRoot().deepCopy());
		}
		//other option sets it to the other side
		else if (left != true){
			combinedTree.getRoot().setLeft(t.getRoot().deepCopy());
			combinedTree.getRoot().setRight(this.getRoot().deepCopy());
		}
		return combinedTree;
	}	

	public int size() { 
		if (root == null) // empty tree
			return 0; // size is 0
		else
			return root.size(); // recursively ask

	}		 

	public int height(){

		if (this.getRoot() == null) {
			return 0; // default height
		}

		return this.getRoot().height();
	}





	//complete tree is one in which all nodes other than leafs have two children
	//and all leafs have the same height.
	public boolean full(){
		return this.root.full();
	}


	public void mirror(){
		if (this.getRoot() ==null) {
			return;
		}
		else {
			this.getRoot().mirror();
		}
	}



	public String inOrder(){
		return this.getRoot().inOrder();
	}

}
