public class BSTree<T extends Comparable<T>> {

	private class BSTNode {
		public String data;
		public BSTNode left;
		public BSTNode right;

		BSTNode(String newdata) {
			data = newdata;
		}
	}

	private BSTNode root;

	public boolean find(String String) {
		return find(root, String);
	}

	public boolean find(BSTNode tree, String string) {
		BSTNode tmp = tree;
		while (tmp != null) {
			if (string.compareTo(tmp.data) == 0) {
				return true;
			}else if (string.compareTo(tmp.data) < 0) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}
		return false;
	}

	public void insert(String string) {
		root = insert(root, string);
	}

	public BSTree<T>.BSTNode insert(BSTNode tree, String string) {
		if (tree == null) {
			return new BSTNode(string);
		}else if (string.compareTo(tree.data) < 0) {
			tree.left = insert(tree.left, string);
			return tree;
		} else {
			tree.right = insert(tree.right, string);
			return tree;
		}
	}

	public void delete(String string) {
		root = delete(root, string);
	}

	public BSTree<T>.BSTNode delete(BSTNode tree, String string) {
		if (tree == null) {
			return null;
		}else if (tree.data.compareTo(string) == 0) {
			if (tree.left == null) {
				return tree.right;
			} else if (tree.right == null) {
				return tree.left;
			} else {
				if (tree.right.left == null) {
					tree.data = tree.right.data;
					tree.right = tree.right.right;
					return tree;
				} else {
					tree.data = removeSmallest(tree.right);
					return tree;
				}
			}
		} else if (string.compareTo(tree.data) < 0) {
			tree.left = delete(tree.left, string);
			return tree;
		} else {
			tree.right = delete(tree.right, string);
			return tree;
		}

	}

	private String removeSmallest(BSTree<T>.BSTNode tree) {
		if (tree.left.left == null) {
			String min = tree.left.data;
			tree.left = tree.left.right;
			return min;
		} else {
			return removeSmallest(tree.left);
		}
	}

	public Object toStringInOrder() {
		return toStringInOrder(root);
	}

	public Object toStringInOrder(BSTree<T>.BSTNode tree) {
		String result = "";
		if (tree != null) {
			String leftString = (String) toStringInOrder(tree.left);
			String rightString = (String) toStringInOrder(tree.right);

			if (!leftString.equals("")) {
				result = result + leftString + " ";
			}

			result = result + tree.data;

			if (!rightString.equals("")) {
				result = result + " " + rightString;
			}

		}
		return result;
	}

	public Object toStringPreOrder() {
		return toStringPreOrder(root);
	}

	public Object toStringPreOrder(BSTree<T>.BSTNode tree) {

		String result = "";
		if (tree != null) {
			String leftString = (String) toStringPreOrder(tree.left);
			String rightString = (String) toStringPreOrder(tree.right);

			result = result + tree.data;

			if (!leftString.equals("")) {
				result = result + " " + leftString;
			}

			if (!rightString.equals("")) {
				result = result + " " + rightString;
			}

		}
		return result;
	}

}
