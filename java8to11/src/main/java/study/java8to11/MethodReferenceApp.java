package study.java8to11;

import study.java8to11.methodEx.Greeting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReferenceApp {

    public static void main(String[] args) {

        //1) 스태틱 메소드 참조
        //UnaryOperator를 생성한 것이지 호출한게 아님
        //UnaryOperator<String> hi = (s) -> "hi " + s;
        UnaryOperator<String> hi = Greeting::hi;

        //호출
        String seohee = hi.apply("seohee");
        System.out.println("seohee = " + seohee);


        //2)
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;


        //3-1) 생성자 참조
        //Supplier를 생성한 것이지 Greeting 객체를 생성한게 아님
        Supplier<Greeting> greetingSupplier = Greeting::new;
        Greeting greeting1 = greetingSupplier.get();

        //3-2) 3-1)과 같아 보이지만 다른 생성자를 호출함
        Function<String, Greeting> seoheeGreeting = Greeting::new;
        Greeting greeting2 = seoheeGreeting.apply("seohee");
        System.out.println("greeting2 = " + greeting2.getName());

        //4) 임의의 객체의 인스턴스 메소드 침조
        String[] names = {"seohee", "java", "spring"};

        //  comparator로 정렬, java8부터 Functional Interface로 동작 -> 람다로 변경
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        
        /* 메소드레퍼런스로 변경
        Arrays.sort(names, ((o1, o2) -> 0));
        */

        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("Arrays.toString(names) = " + Arrays.toString(names));

    }
}
