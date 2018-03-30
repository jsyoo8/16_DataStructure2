public class SeparateChaining {
	private Entry[] entries;
	private int size, crash;
	private float loadFactor;

	public SeparateChaining(int capacity, float loadFactor) {
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
		size = 0;
		crash = 0;
	}

	public SeparateChaining(int capacity) {
		this(capacity, 0.5F);
	}

	public SeparateChaining() {
		this(101);
	}

	public int get(Object key) {
		int h = hash(key);
		for (Entry e = entries[h]; e != null; e = e.next) {
			if (e.key.equals(key))
				return e.value;
		}
		return 0;
	}

	public int put(Object key, int value) {
		int h = hash(key);
		for (Entry e = entries[h]; e != null; e = e.next) {
			if (e.key.equals(key)) {
				e.value++;
				return e.value;
			}
			crash++;
		}
		entries[h] = new Entry(key, value, entries[h]);
		++size;
		if (size > loadFactor * entries.length)
			rehash();
		return 0;
	}

	public int remove(Object key) {
		int h = hash(key);
		for (Entry e = entries[h], prev = null; e != null; prev = e, e = e.next) {
			if (e.key.equals(key)) {
				int oldValue = e.value;
				if (prev == null)
					entries[h] = e.next;
				else {
					prev.next = e.next;
				}
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

	private void rehash() {
		Entry[] oldEntries = entries;
		entries = new Entry[2 * oldEntries.length + 1];
		for (int k = 0; k < oldEntries.length; k++) {
			for (Entry old = oldEntries[k]; old != null;) {
				Entry e = old;
				old = old.next;
				int h = hash(e.key);
				e.next = entries[h];
				entries[h] = e;
			}
		}
	}

	private class Entry {
		Object key;
		int value;
		Entry next;

		Entry(Object k, int v, Entry n) {
			key = k;
			value = v;
			next = n;
		}
	}
}
