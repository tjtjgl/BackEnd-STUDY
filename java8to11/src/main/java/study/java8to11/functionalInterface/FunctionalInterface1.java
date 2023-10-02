package study.java8to11.functionalInterface;

@java.lang.FunctionalInterface
public interface FunctionalInterface1 {

    void doIt();

    //이런건 같이 존재해도 됨, 추상 메소드가 하나 일 때! 함수형인터페이스
    static void testMethod(){
        System.out.println("hello~");
    }
}
