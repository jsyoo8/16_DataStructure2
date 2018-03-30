import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReadFile {
	int ln = 0;
	String[] vertex;
	String[] v;
	String[] w;

	public ReadFile(String file) {
		int i;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			StringTokenizer parser = new StringTokenizer(line, " ");
			++ln;
			String vertexSize = parser.nextToken();
			String edge = parser.nextToken();
			int vs = Integer.valueOf(vertexSize);
			int eg = Integer.valueOf(edge);
			vertex = new String[vs];
			v = new String[eg];
			w = new String[eg];
			++ln;
			line = in.readLine();
			parser = new StringTokenizer(line, " ");
			for (i = 0; i < vs; i++) {
					vertex[i] = parser.nextToken().toUpperCase();				
			}
			line = in.readLine();
			while (line != null) {
				++ln;
				parser = new StringTokenizer(line, " ");
				while (parser.hasMoreTokens()) {
					v[ln - 3] = parser.nextToken().toUpperCase();
					w[ln - 3] = parser.nextToken().toUpperCase();
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
