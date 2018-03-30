import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class Huffman {
	HeapPriorityQueue hpq;
	Vector<trecord> vtc;
	trecord root = new trecord(' ', 0);

	public Huffman(String file) {
		Hashtable<Object, Integer> ht = new Hashtable<Object, Integer>();
		hpq = new HeapPriorityQueue();
		String key;
		char apb;
		int i;
		vtc = new Vector<trecord>();
		trecord tc;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			StringTokenizer parser;
			while (line != null) {
				parser = new StringTokenizer(line, " .,;:-'?!");
				while (parser.hasMoreTokens()) {
					key = parser.nextToken().toUpperCase();
					for (i = 0; i < key.length(); i++) {
						apb = key.charAt(i);
						if (ht.get(apb) != null) {
							ht.put(apb, ht.get(apb) + 1);
						} else {
							ht.put(apb, 1);
							tc = new trecord(apb, 1);
							vtc.add(tc);
						}
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		for (i = 0; i < vtc.size(); i++) {
			vtc.get(i).freq = ht.get(vtc.get(i).apb);
			hpq.add(vtc.get(i));
		}
	}

	public trecord merge(trecord a, trecord b) {
		if (hpq.size() == 1) {
			return (trecord) hpq.best();
		} else {
			trecord huffman = new trecord(a, b, root);
			a.parent = huffman;
			b.parent = huffman;
			hpq.add(huffman);
			trecord aa = (trecord) hpq.remove();
			trecord bb = (trecord) hpq.remove();
			return merge(aa, bb);
		}
	}
	
	public void coding(){
		trecord tc, tcc;
		for (int i = 0; i < vtc.size(); i++) {
			tc = vtc.get(i);
			tcc = vtc.get(i);
			while(tc != root){
				if(tc.equals(tc.parent.lc)){
					tcc.code = "0"+tcc.code;
				}else{
					tcc.code = "1"+tcc.code;
				}
				tc = tc.parent;
			}
		}
	}

	public void printFreq() {
		System.out.println("<<<<< Frequency >>>>>");
		for (int i = 0; i < vtc.size(); i++) {
			System.out.println(vtc.get(i).apb + " : " + vtc.get(i).freq);
		}
	}

	public void printCode() {
		this.coding();
		System.out.println("<<<<< Huffman Code >>>>>");
		for (int i = 0; i < vtc.size(); i++) {
			System.out.println(vtc.get(i).apb + " : " + vtc.get(i).code);
		}
	}

	public void printEncoding() {
		System.out.println("<<<<< Text Encoding >>>>>");

	}
}
