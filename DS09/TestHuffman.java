
public class TestHuffman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "Huffman.txt";
		Huffman hm = new Huffman(file);
		trecord a = (trecord) hm.hpq.remove();
		trecord b = (trecord) hm.hpq.remove();
		trecord huffman = hm.merge(a, b);
		hm.printFreq();
		hm.printCode();
	}

}
