package study.java8to11;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LambdaExpressionMain {

    public static void main(String[] args) {
        new LambdaExpressionMain().run();
    }

    public void run() {
        // 자바8부터 사실상 final(=effective final)로 쓰이면 생략 가능
        int baseNum = 10;

        // 로컬클래스 : shadowing, run()과 다른 scope
        class LocalClass {
            void printBaseNum() {
                int baseNum = 11;
                System.out.println("baseNum = " + baseNum);
            }
        }

        // 익명클래스 : shadowing, run()과 다른 scope
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNum) {
                System.out.println("baseNum = " + baseNum);
            }
        };

        // 람다, run()과 같은 scope = baseNum 변수명 사용 불가
        IntConsumer printInt = (i) -> {
            //int baseNum = 11;
            System.out.println("i+baseNum = " + (i + baseNum));
        };

        printInt.accept(10);
    }
}
