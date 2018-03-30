import java.util.HashMap;

public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "Caesar.txt";
		ReadFile rf = new ReadFile(file);
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int index = rf.text.size();
		String s = rf.text.poll();
		while (index > 0) {
			if (hm.containsKey(s)) {
				hm.replace(s, hm.get(s) + 1);
			} else {
				hm.put(s, 1);
			}
			s = rf.text.poll();
			index--;
		}
		s = "I";
		System.out.println("I : " + hm.get(s));
		s = "YOU";
		System.out.println("You : " + hm.get(s));
		s = "HE";
		System.out.println("he : " + hm.get(s));
		s = "BRUTUS";
		System.out.println("Brutus : " + hm.get(s));
		s = "EVIL";
		System.out.println("evil : " + hm.get(s));
		s = "THE";
		System.out.println("the : " + hm.get(s));
		s = "AND";
		System.out.println("and : " + hm.get(s));
	}
}
