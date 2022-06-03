package chap01;


public class Hello {

	public static void main(String[] args) {
		
		//영어로 인사
		greetEn();	//메서드호출(실행)	
		greetEn();
		greetEn();
		greetEn();
		greetEn();

		
		//한글로 인사
		greetKr();
		
		//자기이름
		info();
	}

	//메서드선언
	public static void greetEn() {
		System.out.println("Hello");
	}

	public static void greetKr() {
		System.out.println("안녕");
	}

	public static void info() {
		System.out.println("이기환");
	}

}
