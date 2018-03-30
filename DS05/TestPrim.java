
public class TestPrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prim prim = new Prim(new String[] { "A", "B", "C", "D", "E", "F", "G"});

		prim.add("A", "B", 4);
		prim.add("A", "G", 2);
		prim.add("A", "F", 1);
		prim.add("B", "G", 5);
		prim.add("B", "C", 2);
		prim.add("C", "G", 1);
		prim.add("C", "D", 4);
		prim.add("D", "G", 2);
		prim.add("D", "E", 1);
		prim.add("E", "G", 4);
		prim.add("E", "F", 3);
		prim.add("F", "G", 3);
		
		prim.prim("A");
	}

}
