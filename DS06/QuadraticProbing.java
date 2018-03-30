public class QuadraticProbing {
	private Entry[] entries;
	private int size, used, crash;
	private float loadFactor;
	private final Entry NIL = new Entry(null, 0);

	public QuadraticProbing(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
		size = 0;
		used = 0;
		crash = 0;
	}

	public QuadraticProbing(int capacity) {
		this(capacity, 0.5F);
	}

	public QuadraticProbing() {
		this(101);
	}

	public int get(Object key) {
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null)
				break;
			if (entry == NIL)
				continue;
			if (entry.key.equals(key))
				return entry.value;
		}
		return 0;
	}

	public int put(Object key, int value) {
		if (used > loadFactor * entries.length)
			rehash();
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null) {
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return 0;
			}
			if (entry == NIL) {
				crash++;
				continue;
			}
			if (entry.key.equals(key)) {
				entries[j].value++;
				return entries[j].value;
			}
			crash++;
		}
		return 0;
	}

	public int remove(Object key) {
		int h = hash(key);
		for (int i = 0; i < entries.length; i++) {
			int j = nextProbe(h, i);
			Entry entry = entries[j];
			if (entry == null)
				break;
			if (entry == NIL)
				continue;
			if (entry.key.equals(key)) {
				int oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return 0;
	}

	public int size() {
		return size;
	}

	public int crash() {
		return crash;
	}

	private int hash(Object key) {
		if (key == null)
			throw new IllegalArgumentException();
		return (key.hashCode() & 0X7FFFFFFF) % entries.length;
	}

	private int nextProbe(int h, int i) {
		return (h + i * i) % entries.length;
	}

	private void rehash() {
		Entry[] oldEntries = entries;
		entries = new Entry[2 * oldEntries.length + 1];
		for (int k = 0; k < oldEntries.length; k++) {
			Entry old = oldEntries[k];
			if (old == null || old == NIL)
				continue;
			int h = hash(old.key);
			for (int i = 0; i < entries.length; i++) {
				int j = nextProbe(h, i);
				if (entries[j] == null) {
					entries[j] = old;
					break;
				}
			}
		}
		used = size;
	}

	private class Entry {
		Object key;
		int value;

		Entry(Object k, int v) {
			key = k;
			value = v;
		}
	}
}
