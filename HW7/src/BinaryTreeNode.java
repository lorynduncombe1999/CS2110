
//Loryn Duncombe (ld3dx) Homework 7
//used slides for assistance
//TA instruction

public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode(){
		this(null,null,null);
	}

	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size(){
		int size = 0; //the size of the tree

		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}


	//Getters and setters in place already
	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	//deep copies the node into a new variable called node
	public BinaryTreeNode<T> deepCopy(){
		{

			BinaryTreeNode<T> node = new BinaryTreeNode<T>(this.getData(), this.getLeft(), this.getRight());

			return node;
		}





	}

	@Override
	//this method checks to see if trees are the same
	public boolean equals(Object o) {
		if (o == null) {
			return false; // o is null
		}
		if ( o instanceof BinaryTreeNode) {
			BinaryTreeNode <?> c = (BinaryTreeNode<?>) o;
			{
				if (left != null && right != null) {
					if (this.left.equals(c.getLeft()) &&this.right.equals(c.getRight())&& this.data.equals(c.getData()))
						return true; // returns true if left right and data is true
				}

				else if (left != null && right == null) {
					if (this.left.equals(c.getLeft())&& this.data.equals(c.getData()))
						return true; // returns true if left and data is true


				}
				else if (left == null && right != null) {
					if (this.right.equals(c.getRight()) && this.data.equals(c.getData()))
						return true; // returns true if right and data are the same
				}
				else if ( c.getData()== null && this.getData()== null)
					return true;
				else  {
					return this.data.equals(c.getData());// returns boolean value


				}
			}
		}

		return false;
	}




	//finds the height of the node by following the edge cases of each side and returning the larger number
	public int height() {
		if (this.getRight() == null && this.getLeft() == null) {
			return 1;
		}

		if (this.getLeft() == null) {
			return this.getRight().height() + 1;
		}

		if (this.getRight() == null) {
			return this.getLeft().height() + 1;
		}

		if (this.getLeft().height() > this.getRight().height()) {
			return this.getLeft().height() + 1;
		}

		else {
			return this.getRight().height() + 1;
		}

	}








	//this methods checks to see if the given tree is full
	public boolean full(){
		//checks to see if that right and left are not null
		if(this.getLeft() != null && this.getRight()!= null) {

			if (this.getLeft().height() == this.getRight().height())
				return getLeft().full() && getRight().full(); // recusive call 
			else return false;
			//if heights are not the same will return false 
		}
		if (this.getLeft()!= null | this.getRight() != null)
			return false;
		return true;
	}

	public void mirror(){
		if (this.getRight() == null && this.getLeft() == null)
			return ;

		if (this.left!=null) {
			this.getLeft().mirror();
		}	
		if (this.right!=null) {
			this.getRight().mirror();
		}

		//temporary variable 
		BinaryTreeNode<T> leftRight = left; 

		this.setLeft(right); //setting left to right and right to left 
		this.setRight(leftRight);
	}



	public String inOrder(){


		if (this.getLeft() == null && this.getRight() == null) {
			if (this.getData() != null) {
				return "{" + this.getData() + "}";
			}

			else {
				return "";
			}
		}



		if (this.getLeft() == null && this.getRight() != null) {
			if (this.getData() != null) {
				return "(" + this.getData().toString() + ")" + this.getRight().inOrder();
			}
			else {
				return "{}" + this.getRight().inOrder();
			}
		}

		if (this.getRight() == null && this.getLeft() != null) {
			if (this.getData() != null) {
				return this.getLeft().inOrder() + "(" + this.getData().toString() + ")";
			}
			else {
				return "{}" + this.getLeft().inOrder();
			}
		}

		else {
			return this.getLeft().inOrder() + "(" + this.getData() + ")" + this.getRight().inOrder();

		}


	}}
