
public class TestHashing {
	public static void main(String[] args) {
		String file = "C:/Users/유정식/workspace/DS01_06_201302436_유정식/src/Caesar.txt";
		ReadFile rf = new ReadFile(file);
		LinearProbing lp = new LinearProbing();
		QuadraticProbing qp = new QuadraticProbing();
		DoubleHashing dh = new DoubleHashing();
		SeparateChaining sc = new SeparateChaining();
		int index = rf.text.size();
		String s = rf.text.poll();
		while (index > 0) {
			lp.put(s, 1);
			qp.put(s, 1);
			dh.put(s, 1);
			sc.put(s, 1);
			s = rf.text.poll();
			index--;
		}
		System.out.println("선형조사 총 충돌횟수 : " + lp.crash());
		System.out.println("제곱조사 총 충돌횟수 : " + qp.crash());
		System.out.println("이중해싱 총 충돌횟수 : " + dh.crash());
		System.out.println("폐쇄주소법 총 충돌횟수 : " + sc.crash());
		s = "I";
		System.out.println("선형조사 I : "+lp.get(s));
		System.out.println("제곱조사 I : "+qp.get(s));
		System.out.println("이중해싱 I : "+dh.get(s));
		System.out.println("폐쇄주소법 I : "+sc.get(s));
		s = "YOU";
		System.out.println("선형조사 You : "+lp.get(s));
		System.out.println("제곱조사 You : "+qp.get(s));
		System.out.println("이중해싱 You : "+dh.get(s));
		System.out.println("폐쇄주소법 You : "+sc.get(s));
		s = "HE";
		System.out.println("선형조사 he : "+lp.get(s));
		System.out.println("제곱조사 he : "+qp.get(s));
		System.out.println("이중해싱 he : "+dh.get(s));
		System.out.println("폐쇄주소법 he : "+sc.get(s));
		s = "BRUTUS";
		System.out.println("선형조사 Brutus : "+lp.get(s));
		System.out.println("제곱조사 Brutus : "+qp.get(s));
		System.out.println("이중해싱 Brutus : "+dh.get(s));
		System.out.println("폐쇄주소법 Brutus : "+sc.get(s));
		s = "EVIL";
		System.out.println("선형조사 evil : "+lp.get(s));
		System.out.println("제곱조사 evil : "+qp.get(s));
		System.out.println("이중해싱 evil : "+dh.get(s));
		System.out.println("폐쇄주소법 evil : "+sc.get(s));
		s = "THE";
		System.out.println("선형조사 the : "+lp.get(s));
		System.out.println("제곱조사  the : "+qp.get(s));
		System.out.println("이중해싱  the : "+dh.get(s));
		System.out.println("폐쇄주소법  the : "+sc.get(s));
		s = "AND";
		System.out.println("선형조사 and : "+lp.get(s));
		System.out.println("제곱조사 and : "+qp.get(s));
		System.out.println("이중해싱 and : "+dh.get(s));
		System.out.println("폐쇄주소법 and : "+sc.get(s));
	}
}