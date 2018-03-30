
public class Deap {
	int[] deap;
	int n = 0; // deap�� �ִ� ������ ����; ��Ʈ�� ��� �ִ�.

	public Deap(int maxSize) {
		deap = new int[maxSize];
	}

	// �ε��� i�� max-heap�� ��ġ�� ������ true�� �����ϰ�, �׷��� ������ false��
	// �����Ѵ�
	private boolean inMaxHeap(int i) {
		while (i > 2) {
			i = (i - 1) / 2;
		}
		if (i == 1)
			return false;
		return true;
	}

	// �ε��� pos�� min-heap�� ��ġ�� ������ max partner�� �ε����� �����Ѵ�
	private int maxPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		if ((pos + Math.pow(2, exponent)) >= n)
			return (int) (((pos + Math.pow(2, exponent))-1) / 2);
		return (int) (pos + Math.pow(2, exponent));
	}

	// �ε��� pos�� max-heap�� ��ġ�� ������ min partner�� �ε����� �����Ѵ�
	private int minPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		return (int) (pos - Math.pow(2, exponent));
	}

	// min-heap�� �ִ� �ε��� at ��ġ�� key�� ����
	private void minInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

	// max-heap�� �ִ� �ε��� at ��ġ�� key�� ����
	private void maxInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key > deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

	// max ���� �����Ͽ� �����Ѵ�
	public int deleteMax() {
		int i, j;
		int key;
		if (n >= 2) {
			key = deap[2];
		} else {
			n--;
			return deap[1];
		}
		int temp = deap[n--];
		for (i = 2; (i * 2) + 1 <= n; deap[i] = deap[j], i = j) {
			j = (i * 2) + 1;
			if (j + 1 <= n) {
				if (deap[j] < deap[j + 1]) {
					j++;
				}
			}
		}
		j = minPartner(i);
		int x = j;
		if ((j * 2) + 1 <= n) {
			x = (j * 2) + 1;
			if (x + 1 <= n) {
				if (deap[x] < deap[x + 1]) {
					x++;
				}
			}
		}
		if (temp < deap[x]) {
			deap[i] = deap[x];
			minInsert(x, temp);
		} else {
			maxInsert(i, temp);
		}
		return key;
	}

	// min ���� �����Ͽ� �����Ѵ�
	public int deleteMin() {
		int i, j;
		int key = deap[1];
		int temp = deap[n--];
		for (i = 1; (i * 2) + 1 <= n; deap[i] = deap[j], i = j) {
			j = (i * 2) + 1;
			if (j + 1 <= n) {
				if (deap[j] > deap[j + 1]) {
					j++;
				}
			}
		}
		j = maxPartner(i);
		if (temp > deap[j]) {
			deap[i] = deap[j];
			maxInsert(j, temp);
		} else {
			minInsert(i, temp);
		}
		return key;
	}

	// x�� �����Ѵ�
	public void insert(int x) {

		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;

		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}
		}
	}

	// deap�� ����Ʈ�Ѵ�
	public void print() {
		int levelNum = 2;
		int thisLevel = 0;
		int gap = 8;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < gap - 1; j++) {
				System.out.print(" ");
			}
			if (thisLevel != 0) {
				for (int j = 0; j < gap - 1; j++) {
					System.out.print(" ");
				}
			}
			if (Integer.toString(deap[i]).length() == 1) {
				System.out.print(" ");
			}
			System.out.print(deap[i]);
			thisLevel++;
			if (thisLevel == levelNum) {
				System.out.println();
				thisLevel = 0;
				levelNum *= 2;
				gap /= 2;
			}
		}
		System.out.println();
		if (thisLevel != 0) {
			System.out.println();
		}
	}

	public static void main(String[] argv) {
		Deap a = new Deap(1024);

		int[] data = { 4, 65, 8, 9, 48, 55, 10, 19, 20, 30, 15, 25, 50 };
		for (int i = 0; i < data.length; i++) {
			a.insert(data[i]);
		}

		System.out.println("initial Deap");
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();

	}
}