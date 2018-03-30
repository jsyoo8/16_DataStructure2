public class Graph {
	int size;
	Node[] edges;
	String[] a;

	public Graph(String[] args) {
		size = args.length;
		a = new String[size];
		edges = new Node[size];
		for (int i = 0; i < size; i++)
			a[i] = new String(args[i]);
	}

	public void add(String v, String w) {
		int i = 0, j = 0;
		while (!a[i].equals(v))
			i++;
		while (!a[j].equals(w))
			j++;
		edges[i] = new Node(j, edges[i]);
		edges[j] = new Node(i, edges[j]);
	}

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + a[0]);
		for (int i = 1; i < size; i++)
			buf.append("," + a[i]);
		buf.append("}\n{" + a[0]);
		for (int i = 0; i < size; i++) {
			if (edges[i] != null)
				buf.append(":");
			for (Node p = edges[i]; p != null; p = p.next)
				buf.append(a[p.to]);
			if (i < size - 1)
				buf.append("," + a[i + 1]);
		}
		return buf + "}";
	}

	private class Node {
		int to;
		Node next;

		Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
}
