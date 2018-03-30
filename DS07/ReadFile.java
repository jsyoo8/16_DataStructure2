import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ReadFile {
	int ln = 0;
	Queue<String> text = new LinkedList<String>();
	public ReadFile(String file) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			StringTokenizer parser;
			while (line != null) {
				++ln;
				parser = new StringTokenizer(line, " .,;:-'?!");
				while (parser.hasMoreTokens()) {
					text.offer(parser.nextToken().toUpperCase());
				}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
