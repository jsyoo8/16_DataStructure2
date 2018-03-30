
public class TestMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MST mst = new MST(new String[] { "A", "B", "C", "D", "E", "F", "G"});

		mst.add("A", "B", 4);
		mst.add("A", "G", 2);
		mst.add("A", "F", 1);
		mst.add("B", "G", 5);
		mst.add("B", "C", 2);
		mst.add("C", "G", 1);
		mst.add("C", "D", 4);
		mst.add("D", "G", 2);
		mst.add("D", "E", 1);
		mst.add("E", "G", 4);
		mst.add("E", "F", 3);
		mst.add("F", "G", 3);
		
		mst.kruskal();
	}

}
