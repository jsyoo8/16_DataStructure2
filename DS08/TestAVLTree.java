
public class TestAVLTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int insertNumber[] = {44, 88, 55, 77, 33, 99, 66, 22, 25, 75};
		int deleteNumber[] = {25, 55, 75, 44, 88};
		int i = 0;
		AVLTree tree;
		tree = new AVLTree(insertNumber[i++]);
		while(i<insertNumber.length){
			tree.add(insertNumber[i++]);
		}
		System.out.println(tree);
		i = 0;
		while(i<deleteNumber.length){
			tree.delete(deleteNumber[i++]);
		}
		System.out.println(tree);
	}

}
