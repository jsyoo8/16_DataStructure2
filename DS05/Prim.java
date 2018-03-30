import java.util.LinkedList;

public class Prim {
	Edge[] T;
	String[] vertices;
	int weight;
	String[] TV;
	int size;
	Edges[] eg;

	public Prim(String[] args) {
		// TODO Auto-generated constructor stub
		size = args.length;
		weight = 0;
		T = new Edge[size - 1];
		TV = new String[size];
		vertices = new String[size];
		vertices = args;
		eg = new Edges[size];
	}

	public void add(String pr, String to, int w) {
		// TODO Auto-generated method stub
		Edge e1 = new Edge(pr, to, w);
		Edge e2 = new Edge(to, pr, w);
		int i = index(pr);
		int j = index(to);
		eg[i] = new Edges(e1, eg[i]);
		eg[j] = new Edges(e2, eg[j]);
	}

	public int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return vertices.length;
	}

	public void prim(String s) {
		// TODO Auto-generated method stub
		int i = 0;
		int k = 1;
		int vertex = index(s);
		Edge e1, e2;
		TV[i] = s;
		while (i != size - 1) {
			e1 = leastWeight(eg[vertex]);
			if (e1.w == 100) {
				vertex = index(TV[k++]);
				continue;
			}
			for (int j = 0; TV[j] != null; j++) {
				e2 = leastWeight(eg[index(TV[j])]);
				if (e1.w > e2.w) {
					e1 = e2;
				}
			}
			T[i] = e1;
			i++;
			TV[i] = e1.to;
		}

		print();
	}

	public Edge leastWeight(Edges _eg) {
		Edge e = new Edge(_eg.e.pr, _eg.e.to, 100);
		for (Edges p = _eg; p != null; p = p.next) {
			if (p.e.w < e.w && !find(p.e.to)) {
				e = p.e;
			}
		}
		return e;
	}

	public boolean find(String to) {
		int i = 0;
		while (TV[i] != null) {
			if (TV[i].equals(to)) {
				return true;
			}
			i++;
		}
		return false;
	}

	public void print() {
		for (int i = 0; i < T.length; i++) {
			System.out.println("선택된 간선 : (" + T[i].pr + ", " + T[i].to + ", " + T[i].w + " )");
			weight += T[i].w;
		}
		System.out.println("비용 합계 : " + weight);
	}

	private class Edge {
		String pr;
		String to;
		int w;

		Edge(String pr, String to, int w) {
			this.pr = pr;
			this.to = to;
			this.w = w;
		}
	}

	private class Edges {
		Edge e;
		Edges next;

		Edges(Edge e, Edges next) {
			this.e = e;
			this.next = next;
		}
	}
}
