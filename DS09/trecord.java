
public class trecord implements Comparable {
	trecord lc, rc, parent;
	char apb = ' ';
	int freq = 0;
	String code = "";

	public trecord(char apb, int freq) {
		this.apb = apb;
		this.freq = freq;
	}

	public trecord(trecord a, trecord b, trecord parent) {
		if (b.compareTo(a) >= 0) {
			this.lc = a;
			this.rc = b;
		} else {
			this.lc = b;
			this.rc = a;
		}
		this.parent = parent;
		this.freq = lc.freq + rc.freq;
	}

	public int compareTo(Object object) {
		if (!(object instanceof trecord))
			throw new IllegalArgumentException();
		trecord that = (trecord) object;
		return that.freq - this.freq;
	}
}
