import java.util.LinkedList;
import java.util.Queue;

public class MST {

	Edge[] eg;
	String[] vertices;
	int weight;
	int[] height;
	int[] TV;
	int size;
	Queue<Edge> pq;
	LinkedList<Edge> leg;

	public MST(String[] args) {
		// TODO Auto-generated constructor stub
		size = args.length;
		weight = 0;
		eg = new Edge[size * size];
		TV = new int[size];
		vertices = new String[size];
		vertices = args;
		height = new int[size];
		for (int i = 0; i < size; i++) {
			TV[i] = -1;
			height[i] = 0;
		}
		pq = new LinkedList<Edge>();
		leg = new LinkedList<Edge>();
	}

	public void add(String pr, String to, int w) {
		// TODO Auto-generated method stub
		Edge e = new Edge(pr, to, w);
		int i = 0;
		boolean input = false;
		while (!input) {
			if (eg[i] == null) {
				eg[i] = e;
				input = true;
			}
			i++;
		}
	}

	public int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return vertices.length;
	}

	public void kruskal() {
		// TODO Auto-generated method stub
		this.sort();
		Edge e;
		int a, b;
		for (int i = 0; i < pq.size(); i++) {
			e = pq.poll();
			a = collapsingFind(index(e.pr));
			b = collapsingFind(index(e.to));
			if (a != b) {
				weightedUnion(a, b);
				leg.add(e);
				weight += e.w;
				if (leg.size() == size-1){
					break;
				}
			}
		}
		print();
	}

	public void sort() {
		LinkedList<Edge> steg = new LinkedList<Edge>();
		steg.add(eg[0]);
		int i = 1;
		boolean input;
		while (eg[i] != null) {
			input = false;
			for (int j = 0; j < steg.size(); j++) {
				if (eg[i].w < steg.get(j).w) {
					steg.add(j, eg[i]);
					input = true;
					break;
				}
			}
			if (!input) {
				steg.addLast(eg[i]);
				input = true;
			}
			i++;
		}
		for (int k = 0; k < steg.size(); k++) {
			pq.add(steg.get(k));
		}
	}

	public int collapsingFind(int v) {
		if (TV[v] == -1) {
			return v;
		} else {
			int i = TV[v];
			while (TV[i] >= 0) {
				i = TV[i];
			}
			return i;
		}
	}

	public void weightedUnion(int i, int j) {
		if (height[i] > height[j]) {
			TV[j] = i;
		} else if (height[i] < height[j]) {
			TV[i] = j;
		} else if (height[i] == height[j]) {
			TV[j] = i;
			height[i]++;
		}
	}

	public void print() {
		for(int i = 0; i < leg.size(); i++) {
	         System.out.println("선택된 간선 : " + leg.get(i).pr + "--> " + leg.get(i).to + " / weight = " + leg.get(i).w + " 추가");
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

}
