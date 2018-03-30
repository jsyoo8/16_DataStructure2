
public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		String file = "C:/Users/유정식/Desktop/과제/DS01_01_201302436_유정식/src/Graph.txt";
		ReadFile rf = new ReadFile(file);
		Graph g = new Graph(rf.vertex);
		for (i = 0; i < rf.v.length; i++) {
				g.add(rf.v[i], rf.w[i]);			
		}
		g.toString();
	}
}
