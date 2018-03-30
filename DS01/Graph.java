
public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
	}

	public void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	public String toString() {
		int i, j;
		for (i = 0; i < size; i++) {
			System.out.print("   " + vertices[i] + "   ");
		}
		for (i = 0; i < size; i++) {
			System.out.print("\n" + vertices[i] + "|");
			for (j = 0; j < size; j++) {
				System.out.printf("%-7b",a[i][j]);
			}
		}
		return null;
	}
}