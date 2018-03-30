import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	boolean[] dfsCheck;

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
		dfsCheck = new boolean[size];
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
		if (size == 0)
			return "{ }";
		StringBuffer buf = new StringBuffer("{" + vertex(0));
		for (int i = 1; i < size; i++)
			buf.append("," + vertex(i));
		return buf + "}";
	}

	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for (int j = 0; j < size; j++)
			if (a[i][j])
				buf.append(vertices[j]);
		return buf + "";
	}

	public void bfsTree(String s) {
		Queue<String> q = new LinkedList<String>();
		boolean[] check = new boolean[size];
		String _s;
		q.add(s);
		check[index(s)] = true;
		System.out.print("ROOT : " + s);
		while (!q.isEmpty()) {
			_s = q.remove();
			System.out.print("\n" + _s + " 탐색 : ");
			for (int i = 0; i < size; i++) {
				if (a[index(_s)][i] == true && check[i] == false) {
					q.add(vertices[i]);
					System.out.print(vertices[i] + " ");
					check[i] = true;
				}
			}
		}
	}

	public void dfsTree(String s) {
		String _s;
		dfsCheck[index(s)] = true;
		for (int i = 0; i < size; i++) {
			if (a[index(s)][i] == true && dfsCheck[i] == false) {
				_s = vertices[i];
				dfsCheck[i] = true;
				System.out.print("\nROOT(" + s + ")-->" + _s);
				dfsTree(_s);
			}
		}
	}
}
