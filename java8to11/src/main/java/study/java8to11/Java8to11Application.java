package study.java8to11;

import java.util.function.*;

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

		//==========================
		//1) Function<T, R>
		Function1 function1 = new Function1();
		System.out.println(function1.apply(10));

		//클래스 없이 람다식으로 바로 구현 가능
		Function<Integer, Integer> plus5 = (number) -> number + 5;
		System.out.println(plus5.apply(10));
		
		Function<Integer, Integer> multiple2 = (number) -> number * 2;
		
		//1-2) UnaryOperator<T>
		UnaryOperator<Integer> plus20 = (number) -> number + 20;

		//두 함수를 조합 가능
		Function<Integer, Integer> multiple2AndPlus10 = plus5.compose(multiple2);
		System.out.println(multiple2AndPlus10.apply(10));

		System.out.println(plus5.andThen(multiple2).apply(10));

		//2) Consumer<T>
		Consumer<String> hello = (s) -> System.out.println(s);
		hello.accept("Hello~");

		//3) Supplier<T>
		Supplier<Integer> get10 = () -> 10;
		System.out.println("get10 = " + get10.get());

		//4) Predicate<T>
		Predicate<String> startsWithApple = (s) -> s.startsWith("apple");
		Predicate<Integer> isEven = (i) -> i%2==0;

		//5) BinaryOperator
		BinaryOperator<Integer> sum = (a,b) -> a+b;
		int result = sum.apply(10, 10);
		System.out.println("result = " + result);

	}


}
