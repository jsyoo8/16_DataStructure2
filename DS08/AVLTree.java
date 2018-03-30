
public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	private int root;

	public static final AVLTree NIL = new AVLTree();

	private AVLTree() {
		left = right = this;
		height = -1;
		root = 0;
	}

	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
		root = 1;
	}

	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		root = 0;
		height = 1 + Math.max(left.height, right.height);
	}

	public boolean add(int key) {
		int oldSize = size();
		grow(key);
		return size() > oldSize;
	}
	
	public AVLTree grow(int key) {
		if (this == NIL)
			return new AVLTree(key, NIL, NIL);
		if (key == this.key)
			return this;
		if (key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	public String toString() {
		if (this == NIL)
			return "";		
		return left + " " + key + " " + right;
	}

	private void rebalance() {
		if (right.height > left.height + 1) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		}
	}

	private void rotateLeft() {
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}

	private void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}

	public boolean delete(int key) {
		int oldSize = size();
		reduce(key);
		return size() < oldSize;
	}

	public AVLTree reduce(int key) {
		if (this == NIL)
			return this;
		if (key == this.right.key)
			this.right = searchLeap(this.right);
		if (key == this.left.key)
			this.left = searchLeap(this.left);
		if (key < this.key)
			left = left.reduce(key);
		if (key > this.key)
			right = right.reduce(key);
		if (key == this.key) {
			if (root == 1) {
				AVLTree nTree = searchLeap(this);
				this.key = nTree.key;
				this.left = nTree.left;
				this.right = nTree.right;
			} else {
				left = left.reduce(key);
			}

		}
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	private AVLTree searchLeap(AVLTree reducing) {
		AVLTree p = reducing;
		AVLTree t = reducing;
		AVLTree r;
		if (p.left == NIL) {
			r = p.right;
			r.left = t.right.left;
			r.right = t.right.right;
		} else {
			if (p.left.right == NIL) {
				r = p.left;
				p.left = p.left.left;
				r.right = t.right;
				r.left = t.left;
			} else {
				p = p.left;
				while (p.right.right != NIL) {
					p = p.right;
				}
				r = p.right;
				p.right = p.right.left;
				r.left = t.left;
				r.right = t.right;
			}
		}
		return r;
	}
}
