package study.java8to11;

public class Java8to11Application {

	public static void main(String[] args) {

		//8 이전에는 익명 내부 클래스로 호출하였음
		/*FunctionalInterface fi = new FunctionalInterface() {
			@Override
			public void doIt() {
				System.out.println("함수형 인터페이스 호출");
			}
		};*/

		// 함수형 인터페이스 호출은 람다식으로
		FunctionalInterface1 functionalInterface1_1 = () -> System.out.println("함수형 인터페이스 호출");

		FunctionalInterface1 functionalInterface1_2 = () -> {
			System.out.println("두줄일 땐 묶어서");
			System.out.println("변환");
		};

		functionalInterface1_1.doIt();
		functionalInterface1_2.doIt();

		//함수형 프로그래밍
		//퓨어함수(순수함수)
		FunctionalInterface2 functionalInterface2_1 = (number) -> number+10;

		//계속 호출해도 같은 값을 반환
		System.out.println(functionalInterface2_1.doIt2(1));
		System.out.println(functionalInterface2_1.doIt2(1));
		System.out.println(functionalInterface2_1.doIt2(1));

		//퓨어함수가 아닌 경우, 외부 변수를 사용, '상태값에 의존한다'고 함
		int baseNumber = 10;
		FunctionalInterface2 functionalInterface2_2 = (number) -> number+baseNumber;

	}

}
