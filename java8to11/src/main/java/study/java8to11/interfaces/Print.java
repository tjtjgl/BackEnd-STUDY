package study.java8to11.interfaces;

public interface Print {

    void printName();


    // 구현하는 클래스에서 Override 하지 않으면 에러 발생
    //void printNameUpperCase();

    //default 키워드를 이용하여 구현, 물론 재정의도 가능
    /**
    * @implSpec
    * 이 구현체는 getName()으로 가져온 문자열을 대문자로 변환해 출력
    * */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    static void printAnithing(){
        System.out.println("static method test");
    };

    String getName();


}
