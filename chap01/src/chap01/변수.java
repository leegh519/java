package chap01;

/*
 * 변수의 타입(유형)
 *                변수는 -> 메모리 저장위치. 저장하는 공간
 *                타입은 -> 값을 저장하는 형식(구조, 크기)
 * 
 *                   1          2       4       8
 * 숫자   정수    byte < short < int < long < BigDecimal
 * 
 * 
 *            유효 자리수   7         15
 *        실수              float < double
 * 
 * 
 * 문자      한글자      char         <=   'a'  '가'
 *           단어        String       <=   "홍길동"
 *           
 *           
 * 불린형          boolean      <-      true, false         
 *           
 * 날짜
 */
public class 변수 {

	public static void main(String[] args) {
		int korScore = 100; // 상수값의 기본형은 int
		int int2 = 0b1111111;
		int int8 = 017;
		int int16 = 0x7F;
		
		long rich = 2200000000l; // long형은 숫자 뒤에 l or L 붙여야함
		float avg = 0.123456789f; // float형은 숫자 뒤에 f or F 붙여야함
		double totalAvg = 0.1234567890123456789;
		
		System.out.println("int2 : \\"+int2+"\\");
		System.out.println("int8 : \""+int8+"\"");
		System.out.println("int16 : "+int16);

		boolean passYn = true;

		int k = 60, e = 60, m = 60;
		boolean fail = k > 50 && e > 50 && m > 50;
		System.out.println("fail = " + fail);

		int engScore = 10; // 변수선언, 초기화
		int mathScore; // 변수선언
		mathScore = 100; // 초기화

		System.out.println(avg);
		System.out.println(totalAvg);
		//System.out.println(engScore);

		char grade = 55200; // 67; //'A';
		String grade2 = "A+";

		System.out.println("grade = " + grade);

	}

}
