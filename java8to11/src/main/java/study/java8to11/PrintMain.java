package study.java8to11;

import study.java8to11.interfaces.PrintImpl;

public class PrintMain {

    public static void main(String[] args) {
        PrintImpl print = new PrintImpl("seohee");

        print.printName();
        print.printNameUpperCase();

    }

}
