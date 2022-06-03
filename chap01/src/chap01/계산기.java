package chap01;

/*
 * 작성자 : 이기환
 * 작성일자 : 2022-5-18
 * 기능 : 숫자 계산기
 */

public class 계산기 {

	public static void main(String[] args) {
		// 두수의 합을 출력
		// add();

		// 두수의 뺄셈
		// sub();
		// 국어 영어 수학 성적의 합계와 평균 출력
		totalAvg();

	}

	public static void totalAvg() {
		
		// 국어 변수 선언
		int kor;
		// 국어 변수 초기화
		kor = 100;
		// 영어 변수 선언
		int eng;
		// 영어 변수 초기화
		eng = 43;
		// 수학 변수 선언
		int math;
		// 수학 변수 초기화
		math = 66;
		// 세과목의 합을 계산, 변수에 담고
		int sum = kor + eng + math;
		// 합을 3으로 나누어서 평균 계산, 변수에 담고
		double avg = sum / 3.0;
		// 합계출력
		System.out.println("합계 : "+sum);
		// 평균출력
		System.out.println("평균 : "+avg);
		
	}

	public static void add() {
		int num1 = 1; // 변수 num1을 선언하고 1을 저장
		int num2 = 2; // 변수 num2를 선언하고 2를 저장
		num1 = 10; // 변수에는 값을 바꿔서 저장할 수 있다.
		int result = num1 + num2; // 변수 result를 선언하고 num1과 num2를 더한 값 저장
		System.out.println(result); // 모니터에 출력하는 메소드 호출
		
	}

	public static void sub() {
		int x = 1;
		int y = 2;
		int result = x - y;
		System.out.println(result);
		
	}
	
}