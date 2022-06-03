package chap01;

public class Work01 {

	public static void main(String[] args) {
		변수선언();
	}

	public static void 변수선언() {
		
		char grade = '상';
		String schoolName = "예담";
		int score = 85;
		double average = 4.235;
		int flag = 0b10000000;
		char firstChar = '\uAC00';
		int secondChar = 0xAC01;
		int salary = 1_000_000;
		boolean useYn = true;

		System.out.print("grade=" + grade+"\n");
		System.out.println("schoolName=" + schoolName);
		System.out.println("score=" + score);
		System.out.println("average=" + average);
		System.out.println("flag=" + flag);
		System.out.println("firstChar=" + firstChar);
		System.out.println("secondChar=" + (char)secondChar);
		System.out.println("salary=" + salary);
		System.out.print("useYn=" + useYn);
	}
}
