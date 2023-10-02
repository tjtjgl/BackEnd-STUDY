package study.java8to11;

import study.java8to11.interfaces.Print;
import study.java8to11.interfaces.PrintImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class PrintApp {

    public static void main(String[] args) {
        PrintImpl print = new PrintImpl("seohee");

        print.printName();
        print.printNameUpperCase();

        Print.printAnithing();

        //API의 기본메소드 / 스태틱메소드
        List<String> list = new ArrayList<>();

        list.add("java");
        list.add("spring");
        list.add("python");
        list.add("etc");

        //매소드레퍼런스
        list.forEach(System.out::println);

        Spliterator<String> spliterator = list.spliterator();


    }

}
